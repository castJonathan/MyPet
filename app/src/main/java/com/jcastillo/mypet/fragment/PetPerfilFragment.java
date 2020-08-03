package com.jcastillo.mypet.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcastillo.mypet.R;
import com.jcastillo.mypet.adapter.PetPerfilAdapter;
import com.jcastillo.mypet.modelo.Pet;

import java.util.ArrayList;


public class PetPerfilFragment extends Fragment{
    private RecyclerView rvPerfilMascotas;
    private ArrayList<Pet> pets;

    Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pet_perfil, container, false);
        activity = getActivity();
        rvPerfilMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascotas);
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        rvPerfilMascotas.setLayoutManager(glm);

        initializerLisaPets();
        initializerAdaptor();


        return v;
    }

    private void initializerLisaPets() {
        pets = new ArrayList<>();
        pets.add(new Pet("Hunter", R.drawable.funny_dog, 7));
        pets.add(new Pet("Minoshca", R.drawable.funny_dog2,3));
        pets.add(new Pet("Thrall", R.drawable.funny_dog3, 6));
        pets.add(new Pet("Oso", R.drawable.funny_dog4,2));
        pets.add(new Pet("Canelo", R.drawable.funny_dog5,9));
        pets.add(new Pet("Hunter", R.drawable.funny_dog, 7));
        pets.add(new Pet("Minoshca", R.drawable.funny_dog2,3));
        pets.add(new Pet("Thrall", R.drawable.funny_dog3, 6));
        pets.add(new Pet("Oso", R.drawable.funny_dog4,2));
        pets.add(new Pet("Canelo", R.drawable.funny_dog5,9));

    }
    private void initializerAdaptor() {
        PetPerfilAdapter adapter = new PetPerfilAdapter(pets, activity);
        rvPerfilMascotas.setAdapter(adapter);
    }
}