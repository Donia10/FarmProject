package com.example.farmproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                /*
                finish();
                Intent mainIntent = new Intent (MainActivity.this, AllButtons.class);
                /*MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
                startActivity(mainIntent);
                **/
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 3000);


    }
}
