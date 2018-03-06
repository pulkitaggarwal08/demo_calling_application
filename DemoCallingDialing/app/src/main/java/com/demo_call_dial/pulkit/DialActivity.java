package com.demo_call_dial.pulkit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by pulkit on 5/11/17.
 */

public class DialActivity extends AppCompatActivity {

    private EditText idNumText;
    private Button idBtnCall;
    private String str_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);

        findIds();
        initDial();
    }

    private void findIds() {

        idNumText = (EditText) findViewById(R.id.idNumText);
        idBtnCall = (Button) findViewById(R.id.idBtnCall);
    }

    private void initDial() {

        idBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                str_number = idNumText.getText().toString();

                if (str_number.isEmpty()) {
                    intent.setData(Uri.parse("tel: 7788994455"));
                }
                else {
                    intent.setData(Uri.parse("tel:" + str_number));
                }
                startActivity(intent);

            }
        });
    }

}
