package com.carmen;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.os.Bundle;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;

public class MainActivity extends AppCompatActivity {
    public WebSocket ws;
    private WebView mWebView;
    private WebAppInterface wa=new WebAppInterface(this);
    private EchoWebSocketListener as=new EchoWebSocketListener();
    private Convert con=new Convert();
    private MemberVO mem=new MemberVO();
    private List<RoleVO> role=new ArrayList<RoleVO>();
    OkHttpClient client = new OkHttpClient();
    private String login_url="http://218.235.176.109:8389/m/login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wa.setMain(this);
        mWebView = (WebView) findViewById(R.id.activity_main_wv);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (url.equals(login_url)) {
                    if(loadidsave()){
                    setMem(loadid());

                    String script = "javascript:function afterLoad() {"
                                    + "document.getElementById('id').value = '" + mem.getEmp_id() + "';"
                                    + "document.getElementById('pw').value = '" + mem.getEmp_pw() + "';"
                                    + "idck();";
                            if(loadautologin()){
                            script+="savecheck();"
                                    +"login_go()";
                            }
                             script+= "};"
                                      + "afterLoad();";
                    view.loadUrl(script);
                     }
                }
            }
         });

        mWebView.addJavascriptInterface(wa,"Android");
        mWebView.loadUrl(login_url);
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if((keyCode== KeyEvent.KEYCODE_BACK)&&mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
    public void setWs(WebSocket ws){
        this.ws=ws;
    }
    public MemberVO getMem() {
        return this.mem;
    }
    public List<RoleVO> getRole(){
        return this.role;
    }
    public void setMem(MemberVO mem){
        this.mem=mem;
    }
    public void setRole(List<RoleVO> role){
        this.role=role;
    }
    public void saveid(MemberVO memvo){
        SharedPreferences mem=getSharedPreferences("mem",MODE_PRIVATE);
        SharedPreferences.Editor editor=mem.edit();
        editor.putString("emp_id",memvo.getEmp_id());
        editor.putString("password",memvo.getEmp_pw());
        editor.commit();
    }
    public void saveconfig(boolean idsave,boolean autologin){
        SharedPreferences mem=getSharedPreferences("mem",MODE_PRIVATE);
        SharedPreferences.Editor editor=mem.edit();
        editor.putBoolean("idsabe",idsave);
        editor.putBoolean("autologin",autologin);
        editor.commit();
    }
    public void saverole(List<RoleVO> role){
        Convert con=new Convert();
        SharedPreferences mem=getSharedPreferences("mem",MODE_PRIVATE);
        SharedPreferences.Editor editor=mem.edit();
        editor.putStringSet("role",con.lts(role));
        editor.commit();
    }
    public MemberVO loadid(){
        SharedPreferences mem=getSharedPreferences("mem",MODE_PRIVATE);
        String emp_id=mem.getString("emp_id",null);
        String password=mem.getString("password",null);
        MemberVO memberVO=new MemberVO();
        memberVO.setEmp_id(emp_id);
        memberVO.setEmp_pw(password);
        return memberVO;
    }
    public boolean loadidsave(){
        SharedPreferences mem=getSharedPreferences("mem",MODE_PRIVATE);
        return mem.getBoolean("idsabe",false);
    }
    public boolean loadautologin(){
        SharedPreferences mem=getSharedPreferences("mem",MODE_PRIVATE);
        return mem.getBoolean("autologin",false);
    }
    public Set<String> loadrole(){
        SharedPreferences mem=getSharedPreferences("mem",MODE_PRIVATE);
        Set<String> role=mem.getStringSet("role",null);
        return role;
    }
    public void httpRun(String emp_id)  {
        Gson gson=new Gson();
        String url="http://218.235.176.109:8389/mmemset/"+emp_id;
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject jo=con.stj(response.body().string());
            saveid(gson.fromJson(jo.get("mem").toString(),MemberVO.class));
            saverole(con.jtl((org.json.simple.JSONArray) jo.get("role")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public final void displayNoti(String text) throws Exception {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Carmen")
                .setContentText(text)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(contentIntent)
                .setVibrate(new long[]{1, 1000});
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, mBuilder.build());
        mBuilder.setContentIntent(contentIntent);
    }
}
