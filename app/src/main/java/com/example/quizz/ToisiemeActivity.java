package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ToisiemeActivity extends AppCompatActivity {

    Button changelvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toisieme);

        this.changelvl = (Button) findViewById(R.id.changelvl);

        this.changelvl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ToisiemeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView scoreResultat = (TextView) findViewById(R.id.scoreResultat);

        int score = getIntent().getIntExtra("score_count", 0);
        scoreResultat.setText(score + " / 5");


    }

}