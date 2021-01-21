package com.hr190005.kursat_uysal_final.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hr190005.kursat_uysal_final.MyApplication;
import com.hr190005.kursat_uysal_final.R;
import com.hr190005.kursat_uysal_final.utils.ConnectionCheckHelper;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashActivity();
    }


    public void splashActivity(){
        // interneti kontrol ediyoruz
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                if(ConnectionCheckHelper.isNetworkAvailable(MyApplication.getAppContext())){
                Intent mainIntent = new Intent(SplashActivity.this, ApplicationActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish(); }
                else {
                    alertDialog();
                }
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


        // internet yok ise ayarlara yönlendiriyoruz
    private void alertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(SplashActivity.this);
        dialog.setTitle(R.string.no_connection);
        dialog.setMessage(R.string.connect_to_internet);
        dialog.setCancelable(true);



        dialog.setPositiveButton(
                R.string.close,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int
                            id) {
                        finishAffinity();

                    }
                });


        dialog.setNegativeButton(
                R.string.open_network,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                        startActivity(intent);
                        dialog.cancel();
                    }
                });

        AlertDialog alert = dialog.create();
        alert.show();
    }
}
