package com.jcastillo.mypet.presentador;

import android.content.Context;

import com.jcastillo.mypet.activity.ITopPetView;
import com.jcastillo.mypet.modelo.Pet;
import com.jcastillo.mypet.modelo.PetModel;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 29,July,2020
 */


public class TopPetPresentador implements ITopPetPresentador{

    private ITopPetView iTopPetView;
    private Context contexto;
    private PetModel modelo;
    private ArrayList<Pet> pets;

    public TopPetPresentador(ITopPetView view, Context contexto) {
        this.iTopPetView = view;
        this.contexto = contexto;
        obtenerTopPetBD();
    }

    @Override
    public void obtenerTopPetBD() {
        modelo = new PetModel(contexto);
        pets = modelo.mostrarTopPet();
        mostrarTopPetRV();
    }

    @Override
    public void mostrarTopPetRV() {

        iTopPetView.inicializarAdaptadorRV(iTopPetView.crearAdaptador(pets));
        iTopPetView.generarLinearLayoutVertical();
    }
}
