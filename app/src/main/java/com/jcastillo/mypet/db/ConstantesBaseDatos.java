package com.jcastillo.mypet.db;

/**
 * Created by Jonathan Castillo on 24,July,2020
 */


public class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "mydatabasepet";
    public static final int DATABASE_VERSION =1;

    //TABLA DE MASCOTAS
    public static final String TABLE_PET = "pet";
    public static final String TABLE_PET_ID="id";
    public static final String TABLE_PET_NOMBRE = "nombre";
    public static final String TABLE_PET_FOTO = "foto";
    public static final String TABLE_PET_RANK = "rank";

    //TABLA DE LIKES
    public static final String TABLE_LIKES="pet_likes";
    public static final String TABLE_LIKES_ID="id";
    public static final String TABLE_LIKES_NUMERO_LIKES="numero_likes";
    public static final String TABLE_LIKES_PET_ID = "pet_id";



}
