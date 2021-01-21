package com.hr190005.kursat_uysal_final;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        MyApplication.context = getApplicationContext();

    }

    public static Context getAppContext(){
        return MyApplication.context;
    }
}
