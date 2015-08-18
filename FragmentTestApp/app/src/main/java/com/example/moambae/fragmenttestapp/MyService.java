package com.example.moambae.fragmenttestapp;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyService extends Service {
    ImageView mIv;
    WindowManager mWm;
    WindowManager.LayoutParams mParams;
    boolean isPopView = false;

    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();

        mIv = new ImageView(this);
        mIv.setBackgroundResource(R.drawable.gg);
        mIv.getBackground().setAlpha(200);

        mParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        mParams.gravity = Gravity.CENTER;
        mWm = (WindowManager) getSystemService(WINDOW_SERVICE);
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String action = intent.getAction();

        if(action.equals("start")) {
            if (isPopView == false) {
                Log.v("mabae", "service start");
                mWm.addView(mIv, mParams);
                isPopView = true;
            }
        }
        else if (action.equals("stop")) {
            if (isPopView == true) {
                Log.v("mabae", "service stop");
                mWm.removeView(mIv);
                isPopView = false;
            }
        }

        return START_STICKY_COMPATIBILITY;
    }

}
