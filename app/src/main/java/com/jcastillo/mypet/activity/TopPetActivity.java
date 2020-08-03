package com.jcastillo.mypet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.jcastillo.mypet.R;
import com.jcastillo.mypet.adapter.PetAdapter;
import com.jcastillo.mypet.modelo.Pet;
import com.jcastillo.mypet.presentador.ITopPetPresentador;
import com.jcastillo.mypet.presentador.TopPetPresentador;

import java.util.ArrayList;

public class TopPetActivity extends AppCompatActivity  implements ITopPetView{

    private RecyclerView rvTopMascotas;
    private ITopPetPresentador presentador;
    //ArrayList<Pet> pets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_pet);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvTopMascotas = (RecyclerView) findViewById(R.id.rvTopMascotas);
        presentador = new TopPetPresentador(this, this);

        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //rvTopMascotas.setLayoutManager(llm);
        //inicializarListaPets();
        //inicializarAdaptador();

    }

    /*public void inicializarAdaptador() {
        PetAdapter adaptador = new PetAdapter(pets);
        rvTopMascotas.setAdapter(adaptador);
    }*/

    /*public void inicializarListaPets() {
        //llenado de los dummy
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Hunter", R.drawable.funny_dog,4));
        pets.add(new Pet("Minoshca", R.drawable.funny_dog2,5));
        pets.add(new Pet("Thrall", R.drawable.funny_dog3,2));
        pets.add(new Pet("Oso", R.drawable.funny_dog4,1));
        pets.add(new Pet("Canelo", R.drawable.funny_dog5,6));
    }*/


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvTopMascotas.setLayoutManager(llm);
    }

    @Override
    public PetAdapter crearAdaptador(ArrayList<Pet> pets) {
        PetAdapter adaptador = new PetAdapter(pets, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(PetAdapter adaptador) {
        rvTopMascotas.setAdapter(adaptador);
    }


}