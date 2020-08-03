package com.jcastillo.mypet.activity;

import com.jcastillo.mypet.adapter.PetAdapter;
import com.jcastillo.mypet.modelo.Pet;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 29,July,2020
 */


public interface ITopPetView {
    void generarLinearLayoutVertical();
    PetAdapter crearAdaptador(ArrayList<Pet> pets);
    void inicializarAdaptadorRV(PetAdapter adaptador);

}
