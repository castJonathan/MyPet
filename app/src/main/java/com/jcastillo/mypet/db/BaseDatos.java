package com.jcastillo.mypet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.jcastillo.mypet.modelo.Pet;
import com.jcastillo.mypet.utils.Constantes;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 24,July,2020
 */


public class BaseDatos extends SQLiteOpenHelper {

    Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaPet = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PET + "(" +
                ConstantesBaseDatos.TABLE_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_PET_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_PET_FOTO + " INTEGER " +
                ")";

        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_PET_ID + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_PET + "(" + ConstantesBaseDatos.TABLE_PET_ID + ")" +
                ")";

        sqLiteDatabase.execSQL(queryCrearTablaPet);
        sqLiteDatabase.execSQL(queryCrearTablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_PET);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES);
        onCreate(sqLiteDatabase);
    }

    /**
     * @param numTop es el numero que devolvera el top 5, top 10 o top N
     */
    public ArrayList<Pet> obtenerTopPet(int numTop) {
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT a." + ConstantesBaseDatos.TABLE_PET_ID + ", a." + ConstantesBaseDatos.TABLE_PET_NOMBRE + ", a." + ConstantesBaseDatos.TABLE_PET_FOTO + ", " +
                "COUNT(b." + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + ") likes FROM " + ConstantesBaseDatos.TABLE_PET + " a " +
                "INNER JOIN " + ConstantesBaseDatos.TABLE_LIKES + " b ON a." + ConstantesBaseDatos.TABLE_PET_ID + "= b." + ConstantesBaseDatos.TABLE_LIKES_PET_ID +
                " GROUP BY b." + ConstantesBaseDatos.TABLE_LIKES_PET_ID +
                " ORDER BY likes DESC " +
                " LIMIT " + numTop;

        Log.i(Constantes.TAG, query);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext()) {
            Pet pet = new Pet();
            pet.setId(c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_PET_ID)));
            pet.setNombre(c.getString(c.getColumnIndex(ConstantesBaseDatos.TABLE_PET_NOMBRE)));
            pet.setFoto(c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_PET_FOTO)));
            pet.setRank(c.getInt(c.getColumnIndex("likes")));
            pets.add(pet);
        }
        db.close();
        return pets;
    }


    public void insertarPet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PET, null, contentValues);
        db.close();

    }

    public void insertarLikePet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES, null, contentValues);
        db.close();

    }


    /**
     * @verificarDB solo fue creado para no insertar los campos por cada vez que se corriera la aplicación
     */
    public boolean verificarDB() {
        String query = "SELECT COUNT(*) FROM " + ConstantesBaseDatos.TABLE_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor tablas = db.rawQuery(query, null);
        if (tablas.moveToFirst()) {
            if (tablas.getInt(0) == 0) {
                return true;
            }

        }
        db.close();
        return false;
    }

    public ArrayList<Pet> obtenerPets() {

        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Pet petActual = new Pet();
            petActual.setId(registros.getInt(registros.getColumnIndex(ConstantesBaseDatos.TABLE_PET_ID)));
            petActual.setNombre(registros.getString(registros.getColumnIndex(ConstantesBaseDatos.TABLE_PET_NOMBRE)));
            petActual.setFoto(registros.getInt(registros.getColumnIndex(ConstantesBaseDatos.TABLE_PET_FOTO)));
            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + ") as likes " +
                    "FROM " + ConstantesBaseDatos.TABLE_LIKES +
                    " where " + ConstantesBaseDatos.TABLE_LIKES_PET_ID + "=" + petActual.getId();
            Cursor registroLikes = db.rawQuery(queryLikes, null);
            if (registroLikes.moveToNext()) {
                petActual.setRank(registroLikes.getInt(0));
            } else {
                petActual.setRank(0);
            }
            pets.add(petActual);
        }
        db.close();
        return pets;

    }

    public int obtenerLikesPet(Pet pet) {
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID + "=" + pet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
