package com.dnzv.holamundoandriod.n17011289;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText editText1;
    private EditText editText3;
    private EditText editText4;
    private Button button1;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapeo de los componentes
        editText1 = findViewById(R.id.editText1);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Creamos una instancia del paquete
                        Bundle bundle = new Bundle();
                        //Recuperamos el nombre del edittext
                        bundle.putString("nombre",editText1.getText().toString());
                        bundle.putString("ap",editText3.getText().toString());
                        bundle.putString("am",editText4.getText().toString());

                        //Creamos la peticion de llamda
                        Intent intent = new Intent(
                                MainActivity.this, MainActivity2.class
                        );
                        //Se carga el paquete
                        intent.putExtras(bundle);

                        //llamamos a la actividad hija
                        startActivity(intent);
                    }
                }
        );

        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                }
        );
    }
}