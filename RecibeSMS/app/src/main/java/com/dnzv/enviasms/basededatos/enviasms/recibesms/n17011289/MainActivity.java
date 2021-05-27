package com.dnzv.enviasms.basededatos.enviasms.recibesms.n17011289;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkSMSStatePermission();
        setContentView(R.layout.activity_main);
    }


    private void checkSMSStatePermission(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            Log.i("Mensaje","No tienes permiso para recibir SMS");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS},255);
        }else {
            Log.i("Mensaje","Si tienes permiso para recibir SMS");
        }

        permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            Log.i("Mensaje","No tienes permiso para leer SMS");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS},255);
        }else {
            Log.i("Mensaje","Si tienes permiso para leer SMS");
        }

    }

}