package com.example.myapplication;

import android.os.SystemClock;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Created by Игорь on 21.10.2018.
 */

public class WebSocketGolos extends WebSocketListener {

    private static final Object MODE_PRIVATE = 0;
    Callback callback;
    final String LOG_TAG = "myLogs";

    final String FILE_NAME = "file";

    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "fileSD";

    /*private Color parseColor(String Message){
        int Red = Integer.parseInt(Message.split(",")[0]);
        int Green = Integer.parseInt(Message.split(",")[1]);
        int Blue = Integer.parseInt(Message.split(",")[2]);
        return new Color(Red/255f,Green/255f,Blue/255f,1);
    }*/
    interface Callback {
        void callingBack(String s);
    }

    public void registerCallBack(Callback callback) {
        this.callback = callback;
    }


    // вызываем метод обратного вызова


    WebSocketGolos() {
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {

    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        String[] Mass = text.split(":");
        String Code = Mass[0];

        String[] Message = {};
        if (Mass.length > 1) {
            Message = Mass[1].split(" ");
        }
        long diff = SystemClock.elapsedRealtimeNanos() - Long.parseLong(Message[0]);
        webSocket.send("Diff:" + diff);
        //callback.callingBack(String.valueOf(diff));
    }
}