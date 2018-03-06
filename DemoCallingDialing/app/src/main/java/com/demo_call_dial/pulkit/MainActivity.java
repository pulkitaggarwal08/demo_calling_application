package com.demo_call_dial.pulkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_call, btn_dial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        init();
    }

    private void findIds() {

        btn_call = (Button) findViewById(R.id.btn_call);
        btn_dial = (Button) findViewById(R.id.btn_dial);
    }

    private void init() {

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), CallActivity.class);
                startActivity(intent);
            }
        });

        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), DialActivity.class);
                startActivity(intent);
            }
        });

    }


}