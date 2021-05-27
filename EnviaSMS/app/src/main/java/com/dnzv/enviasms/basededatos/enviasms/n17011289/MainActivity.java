package com.dnzv.enviasms.basededatos.enviasms.n17011289;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText numT;
    private EditText textM;
    private Button btsend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkSMSStatePermission();

        setContentView(R.layout.activity_main);
        numT = findViewById(R.id.numT);
        textM = findViewById(R.id.textM);
        btsend =  findViewById(R.id.btsend);

        btsend.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enviaSMS(numT.getText().toString(),textM.getText().toString());
                    numT.setText("");
                    textM.setText("");
                }
        });
    }

    private void enviaSMS(String n, String m){
        SmsManager smsm = SmsManager.getDefault();
        smsm.sendTextMessage(n,null,m,null,null);
    }

    private void checkSMSStatePermission(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            Log.i("mensaje","No tienes permiso para recibir SMS");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},255);
        }else {
            Log.i("mensaje","Si tienes permiso para recibir SMS");
        }
    }
}