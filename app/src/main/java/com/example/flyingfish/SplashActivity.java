package com.example.flyingfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread =new Thread(){
            @Override
            public void run() {
                try {

                    sleep(1000);
                }
                catch (Exception e){

                    e.printStackTrace();
                }
                finally {

                    Intent mainIntent=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                }
            }
        };
        thread.start();
        TextView highScoreTxt = findViewById(R.id.highScore);

        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        highScoreTxt.setText("HighScore: " + prefs.getInt("highscore", 0));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
