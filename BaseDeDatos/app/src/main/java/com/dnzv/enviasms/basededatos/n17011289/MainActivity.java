package com.dnzv.enviasms.basededatos.n17011289;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private EditText editN;
    private Button botonG;
    private Button botonS;
    private Button botonB;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editN = findViewById(R.id.editN);
        botonG = findViewById(R.id.botonG);
        botonS = findViewById(R.id.botonS);
        botonB = findViewById(R.id.botonB);
        spinner = findViewById(R.id.spiner);

        //Cargamos el escuha
        spinner.setOnItemSelectedListener(this);
        //Cargamos los datos
        loadSpinnerData();

        botonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName();
            }
        });

        botonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        botonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteName();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String nombre =  parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Tu seleccionaste: "+nombre,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void loadSpinnerData(){
        DatabaseHandler dbh = new DatabaseHandler(getApplicationContext());
        List<String> l =  dbh.getAllNames();
        ArrayAdapter <String> aap = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, l);
        spinner.setAdapter(aap);
    }

    public void saveName(){
        String nombre = editN.getText().toString();
        if(nombre.trim().length()>0){
            DatabaseHandler dbh = new DatabaseHandler(getApplicationContext());
            dbh.insertName(nombre);
            editN.setText("");
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editN.getWindowToken(),0);
            loadSpinnerData();
        }else{
            Toast.makeText(getApplicationContext(),"Debes escribir un nombre!",Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteName(){
        if(spinner.getSelectedItem()!=null){
            String nom = spinner.getSelectedItem().toString();
            DatabaseHandler dbh = new DatabaseHandler(getApplicationContext());
            dbh.deleteName(nom);
            Toast.makeText(getApplicationContext(),"Se elemino correctamente\n"+nom,Toast.LENGTH_SHORT).show();
            loadSpinnerData();
        }else{
            Toast.makeText(getApplicationContext(),"Debes seleccionar un nombre!",Toast.LENGTH_SHORT).show();
        }
    }
}