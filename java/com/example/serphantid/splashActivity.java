package com.example.serphantid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class splashActivity extends AppCompatActivity {
ProgressBar progress;
int CurrentProgress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progress=findViewById(R.id.progressBar);

        CurrentProgress = CurrentProgress + 20;
        progress.setProgress(CurrentProgress);



        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CurrentProgress = CurrentProgress + 30;
                progress.setProgress(CurrentProgress);

            }
        },2000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CurrentProgress = CurrentProgress + 50;
                progress.setProgress(CurrentProgress);
                progress.setMax(100);

                Intent inten1=new Intent(splashActivity.this,MainActivity.class);

                splashActivity.this.startActivity(inten1);

                finish();
            }
        },4000);

    }
}