package com.dnzv.holamundoandriod.n17011289;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    //Definimos los componentes del lado de JAVA
    private EditText editText2;
    private Button button3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //Enlazamos los componentes con su vista en XML
        editText2 = findViewById(R.id.editText2);
        button3 = findViewById(R.id.button3);

        //Recuperamos el paquete enviado
        Bundle bundle = this.getIntent().getExtras();
        //Recuperamos el nombre dentro del paquete
        String tmp = bundle.get("nombre").toString();
        String tmp2 = bundle.get("ap").toString();
        String tmp3 = bundle.get("am").toString();

        //Mostramos el texto recuperado
        editText2.setText(tmp+" "+tmp2+" "+tmp3);

        //Al boton de regreasar le agregamos un escuchador
        button3.setOnClickListener(
          new View.OnClickListener(){
              @Override
              public void onClick(View v){
                  //Creamos la intencion de lanzar la nueva actividad
                  Intent intent = new Intent(
                          MainActivity2.this,MainActivity.class
                  );
                  //Lanzamos la nueva actividad
                  startActivity(intent);
              }
          }
        );

    }
}