package com.jcastillo.mypet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TopPet extends AppCompatActivity {

    private Button btnTopPet;
    private RecyclerView rvTopMascotas;
    ArrayList<Pet> pets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_pet);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnTopPet = myActionBar.findViewById(R.id.btnTopPet);
        btnTopPet.setVisibility(View.GONE);

        rvTopMascotas = (RecyclerView) findViewById(R.id.rvTopMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvTopMascotas.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();

    }
    public void inicializarAdaptador(){
        PetAdapter adaptador = new PetAdapter(pets);
        rvTopMascotas.setAdapter(adaptador);
    }

    public void inicializarListaPets() {
        //llenado de los dummy
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Hunter", R.drawable.funny_dog));
        pets.add(new Pet("Minoshca", R.drawable.funny_dog2));
        pets.add(new Pet("Thrall", R.drawable.funny_dog3));
        pets.add(new Pet("Oso", R.drawable.funny_dog4));
        pets.add(new Pet("Canelo", R.drawable.funny_dog5));
    }
}