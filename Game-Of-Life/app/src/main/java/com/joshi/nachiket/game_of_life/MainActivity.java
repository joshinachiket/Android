package com.joshi.nachiket.game_of_life;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button start_button;

    public void startButton () {
        start_button = (Button)findViewById(R.id.button);
        start_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent purpose = new Intent(MainActivity.this, GameLife.class);
                startActivity(purpose);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton();
    }
}
