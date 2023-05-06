package com.example.viktorina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String selectedTopik = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout pravila = findViewById(R.id.line2);


        final Button startbtn = findViewById(R.id.startbtn);

        pravila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopik = "pravila";
                pravila.setBackgroundResource(R.drawable.round_back_white_stroke10);

            }
        });



        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedTopik.isEmpty()) {
                    Toast.makeText(MainActivity.this, "выберите викторину", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopik",selectedTopik);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}