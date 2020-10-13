package com.thequicktax.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.thequicktax.Common.ShareData;
import com.thequicktax.R;
import com.thequicktax.Threads.GetAuthToken;

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    ShareData mshareData;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        if (!mshareData.containsKey("Auth_token")) {
            new GetAuthToken(this).execute();
        }
        mProgressBar.setVisibility(View.VISIBLE);
        handler=new Handler();
        handler.postDelayed(runnable,3000);
    }

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if (mshareData.getBoolean("is_user_logged_in",false)) {
                mProgressBar.setVisibility(View.INVISIBLE);
                Intent landingIntent = new Intent(SplashActivity.this, DashboardActivity.class);
                landingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(landingIntent);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
            }
            else {
                mProgressBar.setVisibility(View.INVISIBLE);
                Intent landingIntent = new Intent(SplashActivity.this, CategoryUserActivity.class);
                landingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(landingIntent);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
            }
            finish();
        }
    };

    public void init()
    {
        mshareData=new ShareData(SplashActivity.this);
        mProgressBar=(ProgressBar)findViewById(R.id.splash_activity_progress_bar);
    }
}