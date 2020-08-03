package com.jcastillo.mypet.presentador;

import android.content.Context;

import com.jcastillo.mypet.fragment.IRecycledViewFragmentView;
import com.jcastillo.mypet.modelo.Pet;
import com.jcastillo.mypet.modelo.PetModel;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 03,August,2020
 */


public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecycledViewFragmentView iRecycledViewFragmentView;
    private Context context;
    private PetModel model;
    private ArrayList<Pet> pets;

    public RecyclerViewFragmentPresenter(IRecycledViewFragmentView iRecycledViewFragmentView, Context context) {

        this.iRecycledViewFragmentView = iRecycledViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();

    }

    @Override
    public void obtenerContactosBaseDatos() {
        model = new PetModel(context);
        pets = model.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecycledViewFragmentView.inicializarAdaptadorRV(iRecycledViewFragmentView.crearAdaptador(pets));
        iRecycledViewFragmentView.generarLinearLayoutVertical();
    }
}
