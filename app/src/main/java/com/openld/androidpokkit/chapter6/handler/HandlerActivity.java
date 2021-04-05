package com.openld.androidpokkit.chapter6.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.openld.androidpokkit.R;

import java.lang.ref.WeakReference;

public class HandlerActivity extends AppCompatActivity {
    private static TextView mTxtShow;

    private Handler mHandlerInMainThread = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1000) {
                mTxtShow.setText(String.valueOf(msg.obj));
            }
        }
    };

    private Handler mHandlerInChildThread;

    private Handler mHandlerInChildThreadWithoutInitLooper;

    private HandlerDelay mHandlerDelay = new HandlerDelay(this);

    private Handler mHandlerPost = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        initWidgets();
    }

    private void initWidgets() {
        mTxtShow = findViewById(R.id.txt_show);
    }


    public void onClickUseHandlerInMainThread(View view) {
        Message msg = new Message();
        msg.what = 1000;
        msg.obj = "主线程创建并使用Handler";
        mHandlerInMainThread.sendMessage(msg);
    }

    public void onClickUseHandlerInChildThread(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 1001;
                msg.obj = "子线程创建并使用Handler";

                Looper.prepare();
                mHandlerInChildThread = new Handler(Looper.getMainLooper()) {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 1001) {
                            mTxtShow.setText(String.valueOf(msg.obj));
                        }
                    }
                };
                mHandlerInChildThread.sendMessage(msg);
            }
        }).start();
    }

    public void onClickUseHandlerInChildThreadWithoutInitLooper(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 1002;
                msg.obj = "子线程创建并使用Handler，没有初始化Looper";
                mHandlerInChildThreadWithoutInitLooper = new Handler();
                mHandlerInChildThreadWithoutInitLooper.sendMessage(msg);
            }
        }).start();
    }

    public void onClickUseHandlerDelay(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 1003;
                msg.obj = "主线程创建，子线程使用延时Handler";
                mHandlerDelay.sendMessageDelayed(msg, 3000);
            }
        }).start();
    }

    public void onClickUseHandlerPost(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandlerPost.post(new Runnable() {
                    @Override
                    public void run() {
                        mTxtShow.setText("主线程创建，子线程使用Handler，调用了post方法");
                    }
                });
            }
        }).start();

    }

    static class HandlerDelay extends Handler {
        private final WeakReference<AppCompatActivity> ref;

        public HandlerDelay(AppCompatActivity appCompatActivity) {
            this.ref = new WeakReference<>(appCompatActivity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            final AppCompatActivity appCompatActivity = ref.get();
            if (appCompatActivity != null && msg.what == 1003) {
                mTxtShow.setText(String.valueOf(msg.obj));
            }
        }
    }

    @Override
    protected void onDestroy() {
        mHandlerDelay.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}