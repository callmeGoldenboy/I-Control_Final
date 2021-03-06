package com.example.da981108.i_control.GeomtricalFocus.Level1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.da981108.i_control.R;

public class AnswerSheet extends AppCompatActivity {

    private int varx = 0;
    private int donex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet);

        final ImageButton Square= (ImageButton) findViewById(R.id.arrows_button1);
        Square.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx += 17;
                donex += 1;
                Square.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Triangle= (ImageButton) findViewById(R.id.grass_button1);
        Triangle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx *=3;
                donex += 1;
                Triangle.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Diamond= (ImageButton) findViewById(R.id.ace_button1);
        Diamond.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx -= 13;
                donex += 1;
                Diamond.setVisibility(View.INVISIBLE);
            }
        });

        final Button Check = (Button) findViewById(R.id.check1);
        Check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (donex != 3){
                    Toast.makeText(getApplicationContext(), "Please select all Figures!",
                            Toast.LENGTH_LONG).show();
                }
                if (donex == 3 && varx == 38) {
                    Toast.makeText(getApplicationContext(), "Success",
                            Toast.LENGTH_LONG).show();
                }
                if(donex == 3 && varx != 38){
                    Toast.makeText(getApplicationContext(), "Fail",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        final Button Refresh = (Button) findViewById(R.id.refresh1);
        Refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(AnswerSheet.this,AnswerSheet.class);
                //starts new activity
                startActivity(i);
                finish();
            }
        });

    }
}
