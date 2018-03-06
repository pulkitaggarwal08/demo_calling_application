package com.demo_call_dial.pulkit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by pulkit on 5/11/17.
 */
public class CallActivity extends AppCompatActivity {

    private EditText idNumText;
    private Button idBtnCall;
    private String str_number;

    private static final int PERMISSIONS_REQUEST_CALL_PHONE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        findIds();
        checkPermissions();

    }

    private void findIds() {

        idNumText = (EditText) findViewById(R.id.idNumText);
        idBtnCall = (Button) findViewById(R.id.idBtnCall);
    }

    private void checkPermissions() {

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            initCall();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},
                    PERMISSIONS_REQUEST_CALL_PHONE);
        }

    }

    private void initCall() {

        idBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                str_number = idNumText.getText().toString();

                if (str_number.isEmpty()) {
                    intent.setData(Uri.parse("tel: 7788994455"));
                } else {
                    intent.setData(Uri.parse("tel:" + str_number));
                }
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    checkPermissions();
                } else {
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults.length >= 0) {
                initCall();
            } else {
                Toast.makeText(this, "Until you grant the permission, we cannot call", Toast.LENGTH_SHORT).show();
            }

        }

    }

}
