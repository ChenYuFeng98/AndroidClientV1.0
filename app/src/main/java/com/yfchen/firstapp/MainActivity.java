package com.yfchen.firstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Time;
import java.util.concurrent.Delayed;


public class MainActivity extends Activity {

    Button btnUP;
    Button btnDN;
    Button btnLUP;
    Button btnLDN;
    Button btnRUP;
    Button btnRDN;
    EditText IP_Text;
    EditText Port_Text;

    public boolean isConnect = false;
    public static String wifiModuleIp = "";
    public static int wifiModulePort = 0;
    public static String CMD = "0";
    //Socket socket;
    //DataOutputStream dataOutputStream;

    public void getIPandPort()//获取编辑框ID
    {
        wifiModuleIp = IP_Text.getText().toString();
        wifiModulePort = Integer.valueOf(Port_Text.getText().toString());
    }

    public class Socket_AsyncTask extends AsyncTask<Void,Void,Void>
    {
        Socket socket;
        @Override
        protected Void doInBackground(Void... params){
            try{
                wifiModuleIp = IP_Text.getText().toString();
                wifiModulePort = Integer.valueOf(Port_Text.getText().toString());
                InetAddress inetAddress = InetAddress.getByName(MainActivity.wifiModuleIp);
                socket = new java.net.Socket(inetAddress,MainActivity.wifiModulePort);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeBytes(CMD);
                dataOutputStream.close();
                //isConnect = true;
                socket.close();
            }catch (UnknownHostException e){
                //isConnect = false;
                e.printStackTrace();
            }catch (IOException e){
                //isConnect = false;
                e.printStackTrace();
            }
            return null;
        }
    }

    public class Socket_Connect extends AsyncTask<Void,Void,Void>
    {
        Socket socket;
        @Override
        protected Void doInBackground(Void... params){
            try{
                wifiModuleIp = IP_Text.getText().toString();
                wifiModulePort = Integer.valueOf(Port_Text.getText().toString());
                InetAddress inetAddress = InetAddress.getByName(MainActivity.wifiModuleIp);
                socket = new java.net.Socket(inetAddress,MainActivity.wifiModulePort);
                isConnect = true;
                socket.close();
            }
            catch (UnknownHostException e){
                isConnect = false;
                e.printStackTrace();
            }
            catch (IOException e){
                isConnect = false;
                e.printStackTrace();
            }
            return null;
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUP = (Button) findViewById(R.id.btnUP);
        btnDN = (Button) findViewById(R.id.btnDN);
        btnLUP = (Button) findViewById(R.id.btnLUP);
        btnLDN = (Button) findViewById(R.id.btnLDN);
        btnRUP = (Button) findViewById(R.id.btnRUP);
        btnRDN = (Button) findViewById(R.id.btnRDN);
        IP_Text = (EditText) findViewById(R.id.IP_Text);
        Port_Text = (EditText) findViewById(R.id.Port_Text);

        //监听
        btnLUP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    getIPandPort();
                    CMD = "A";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    getIPandPort();
                    CMD = "R";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }
                return false;
            }
        });
        btnUP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    CMD = "B";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    CMD = "P";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }
                return false;
            }
        });
        btnRUP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    CMD = "C";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    CMD = "R";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }
                return false;
            }
        });
        btnLDN.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    CMD = "D";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    CMD = "R";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }
                return false;
            }
        });
        btnDN.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    CMD = "E";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    CMD = "P";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }
                return false;
            }
        });
        btnRDN.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    CMD = "F";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    CMD = "R";
                    Socket_AsyncTask MOVE = new Socket_AsyncTask();
                    MOVE.execute();
                }
                return false;
            }
        });



        //初始化连接按钮事件
        findViewById(R.id.btnConnect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Socket_Connect init_connect = new Socket_Connect();
                init_connect.execute();
                Toast.makeText(MainActivity.this, "尝试连接中...",Toast.LENGTH_SHORT).show();
                SystemClock.sleep(30);
                if (isConnect){
                    Toast.makeText(MainActivity.this, "连接成功！",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "连接失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    //再按一次返回关闭
    private long lastExitTime = 0;
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                // 判断2次点击事件时间
                if ((System.currentTimeMillis() - lastExitTime) > 2000) {
                    Toast.makeText(MainActivity.this, "再按一次退出",Toast.LENGTH_SHORT).show();
                    lastExitTime = System.currentTimeMillis();
                } else {

                    finish();
                }

            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}

