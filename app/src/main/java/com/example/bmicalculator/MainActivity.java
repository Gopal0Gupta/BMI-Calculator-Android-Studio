package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtres,txtres2;
        Button btn;
        EditText txtw,txthi,txtf;
        LinearLayout ll;

        txtf = findViewById(R.id.edthtf);
        txthi = findViewById(R.id.edthtin);
        txtw = findViewById(R.id.edtwt);
        txtres = findViewById(R.id.rs);
        txtres2 = findViewById(R.id.rs1);
        btn = findViewById(R.id.btn);
        ll = findViewById(R.id.ll);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(txtw.getText().toString());
                int hti = Integer.parseInt(txthi.getText().toString());
                int htf = Integer.parseInt(txtf.getText().toString());

                int Toatalin = htf*12 + hti;
                double totalhtm = (Toatalin*2.54)/100;
                double bmi = wt/(totalhtm*totalhtm);

                txtres2.setText("Your BMI Is : "+bmi);

                if(bmi>25){
                    txtres.setText("You're OverWeight!");
                    ll.setBackgroundColor(getResources().getColor(R.color.ow));
                }
                else if (bmi<18){
                    txtres.setText("You're UnderWeight!");
                    ll.setBackgroundColor(getResources().getColor(R.color.uw));
                }
                else{
                    txtres.setText("You're Healthy!");
                    ll.setBackgroundColor(getResources().getColor(R.color.h));
                }
            }
        });
    }
}