package com.jcastillo.mypet.fragment;

import com.jcastillo.mypet.adapter.PetAdapter;
import com.jcastillo.mypet.modelo.Pet;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 03,August,2020
 */


public interface IRecycledViewFragmentView {

    void generarLinearLayoutVertical();
    PetAdapter crearAdaptador(ArrayList<Pet> pets);
    void inicializarAdaptadorRV(PetAdapter adaptador);

}
