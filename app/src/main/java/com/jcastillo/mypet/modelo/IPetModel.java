package com.jcastillo.mypet.modelo;

import com.jcastillo.mypet.db.BaseDatos;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 29,July,2020
 */


public interface IPetModel {

    void generarTopPets(BaseDatos db);
    ArrayList<Pet> mostrarTopPet();
    ArrayList<Pet> obtenerDatos();
}
