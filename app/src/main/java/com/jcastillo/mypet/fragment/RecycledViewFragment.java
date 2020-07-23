package com.jcastillo.mypet.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcastillo.mypet.R;
import com.jcastillo.mypet.adapter.PetAdapter;
import com.jcastillo.mypet.pojo.Pet;

import java.util.ArrayList;

public class RecycledViewFragment extends Fragment {

    private RecyclerView rvMascotas;
    private ArrayList<Pet> pets;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycled_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();
        return v;
    }

    public void inicializarListaPets() {
        //llenado de los dummy
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Hunter", R.drawable.funny_dog,4));
        pets.add(new Pet("Minoshca", R.drawable.funny_dog2,6));
        pets.add(new Pet("Thrall", R.drawable.funny_dog3,2));
        pets.add(new Pet("Oso", R.drawable.funny_dog4,8));
        pets.add(new Pet("Canelo", R.drawable.funny_dog5,3));
    }

    public void inicializarAdaptador() {
        PetAdapter adaptador = new PetAdapter(pets);
        rvMascotas.setAdapter(adaptador);
    }

}