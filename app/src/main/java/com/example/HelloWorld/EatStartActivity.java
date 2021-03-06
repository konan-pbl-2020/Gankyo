package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EatStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_start);

        Button backbotton = findViewById(R.id.bottom);
        backbotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EatStartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void startGame(View view) {
        startActivity(new Intent(getApplicationContext(), EatFruitsActivity.class));
    }
}