package com.carmen;

import android.content.Context;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;

import org.json.simple.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okhttp3.internal.JavaNetCookieJar;
import okio.ByteString;

/**
 * Created by haewo on 2018-04-10.
 */

public final class EchoWebSocketListener extends WebSocketListener {
    private MainActivity main;
    private Convert con=new Convert();
    private MemberVO mem;
    private List<RoleVO> role;
    ClearableCookieJar cookieJar;

    public okhttp3.WebSocket createWebSocket(String url) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .readTimeout(0,  TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newWebSocket(request, this);
    }
    @Override
    public void onClosed(okhttp3.WebSocket webSocket, int code, String reason) {
        // TODO Auto-generated method stub
        super.onClosed(webSocket, code, reason);
        main.setWs(webSocket);
    }

    @Override
    public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
        // TODO Auto-generated method stub
        super.onClosing(webSocket, code, reason);
        main.setWs(webSocket);
    }

    @Override
    public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
        // TODO Auto-generated method stub
        super.onFailure(webSocket, t, response);
        main.setWs(webSocket);
    }

    @Override
    public void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) {
        // TODO Auto-generated method stub
        super.onMessage(webSocket, bytes);
    }

    @Override
    public void onMessage(okhttp3.WebSocket webSocket, String text) {
        // TODO Auto-generated method stub
        super.onMessage(webSocket, text);
        alertcheck(text);
    }

    @Override
    public void onOpen(okhttp3.WebSocket webSocket, Response response) {
        // TODO Auto-generated method stub
        super.onOpen(webSocket, response);
    }
    public void alertcheck(String text) {
        try {
            Gson gson = new Gson();
            JSONObject data = con.stj(text);
            String str = null;
            ReqVO req = gson.fromJson(data.get("json").toString(), ReqVO.class);
            if (main.loadrole().contains("sales")) {
                if (req.getEmp_id().equals(main.loadid().getEmp_id())) {
                    if (req.getOrdreq_state().equals("2")) {
                        str = "발주 신청이 확인되었습니다";
                    }
                } else if (req.getOrdreq_state().equals("4")) {
                    str = "입고 되었습니다";
                }
            }
            if(str!=null){
                main.displayNoti(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void makecookie(Context as){
        this.cookieJar=new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(as));
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
    public void setMain(MainActivity main){
        this.main=main;
    }
}