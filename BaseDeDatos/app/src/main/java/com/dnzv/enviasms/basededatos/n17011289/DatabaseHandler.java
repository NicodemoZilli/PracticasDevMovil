package com.dnzv.enviasms.basededatos.n17011289;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME  = "EjemploSqLite";
    private static final String TABLE_NAME  = "nombres";
    private static final String COLUMN_ID  = "id";
    private static final String COLUMN_NAME  = "nombre";





    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override //CREA LA TABLA
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +
                              "("+COLUMN_ID+" INTEGER PRIMARY KEY,"+
                              COLUMN_NAME + " TEXT)";
        db.execSQL(CREATE_TABLE);

    }

    @Override //Actualizamos tabla
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    //Insertamos un elemento en la tabla
    public void insertName(String nombre){
        //Creamos intancia editable
            SQLiteDatabase db = this.getWritableDatabase();
        //Creamos un nuevo registro
            ContentValues ct = new ContentValues();
        //Guardamos el nombre
            ct.put(COLUMN_NAME, nombre);
        //Lo insertamos
            db.insert(TABLE_NAME,null,ct);
    }

    //Extraemos todos los elementos de la base
    public List <String> getAllNames(){
        //Definimos la lista vacia
            List <String> l = new ArrayList<>();
        //Generamos el Query
            String query = "SELECT * FROM "+TABLE_NAME;
        //Abrimos la base de datos en solo lectura
            SQLiteDatabase db = this.getReadableDatabase();
        //Traemos un curso con el Query
            Cursor cursor = db.rawQuery(query,null);
        //Recorremos filas de la consulta
            if(cursor.moveToFirst()){
                do{
                    l.add(cursor.getString(1));
                }while(cursor.moveToNext());
            }
        //Cerramos la conexion a la base
            cursor.close();
        //Cerramos la base
            db.close();
        //Lo retornamos
            return l;
    }

    public void deleteName(String nom){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_NAME+" = '"+nom+"'",null);
    }
}
