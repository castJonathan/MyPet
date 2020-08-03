package com.jcastillo.mypet.modelo;

import android.content.ContentValues;
import android.content.Context;

import com.jcastillo.mypet.R;
import com.jcastillo.mypet.db.BaseDatos;
import com.jcastillo.mypet.db.ConstantesBaseDatos;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 29,July,2020
 */


public class PetModel implements IPetModel {

    private static final int LIKE = 1;
    private Context context;

    public PetModel(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> mostrarTopPet() {
        BaseDatos db = new BaseDatos(context);
        //esto es solo para no estar insertando las mismas pet por cada vez que se ejecute la aplicación
        if(db.verificarDB()) {
            generarTopPets(db);
        }
        return db.obtenerTopPet(5);
    }

    @Override
    public ArrayList<Pet> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        //esto es solo para no estar insertando las mismas pet por cada vez que se ejecute la aplicación
        if(db.verificarDB()) {
            generarTopPets(db);
        }
        return db.obtenerPets();
    }


    @Override
    public void generarTopPets(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Hunter");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Minoshca");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog2);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Thrall");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog3);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Oso");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog4);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Canelo");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog5);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Max");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Negro");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog2);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Blanco");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog3);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Pirata");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog4);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NOMBRE, "Ted");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_FOTO, R.drawable.funny_dog5);
        db.insertarPet(contentValues);

    }

    public void darLike(Pet pet) {

        BaseDatos db = new BaseDatos(context);
        ContentValues values = new ContentValues();
        values.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID, pet.getId());
        values.put(ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES, LIKE);
        db.insertarLikePet(values);
    }

    public int obtenerLikescontacto(Pet pet) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesPet(pet);
    }
}
