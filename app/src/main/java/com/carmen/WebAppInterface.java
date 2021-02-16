package com.carmen;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by haewo on 2018-04-10.
 */

public class WebAppInterface {
    private MainActivity main;
    private EchoWebSocketListener ewsl=new EchoWebSocketListener();
    Context mContext;
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }
    public void setMain(MainActivity main){
        this.main=main;
        ewsl.setMain(this.main);
    }
    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(Object toast) {
        String tas=(String)toast;
        Toast.makeText(mContext, tas, Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public void setWS(){
        ewsl.makecookie(mContext);
        main.setWs(ewsl.createWebSocket("ws://218.235.176.109:8389/echo"));
    }
    @JavascriptInterface
    public void setMem(String id){
        main.httpRun(id);
    }
    @JavascriptInterface
    public void sendMessage(String text){
        main.ws.send(text);
    }
    @JavascriptInterface
    public void saveconfig(String idsave,String autologin){
        boolean iscon=false;
        boolean alcon=false;
        if(idsave.equals("1")){
            iscon=true;
        }
        if(autologin.equals("1")){
            alcon=true;
        }
        main.saveconfig(iscon,alcon);
    }
}
