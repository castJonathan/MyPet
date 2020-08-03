package com.jcastillo.mypet.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jcastillo.mypet.R;
import com.jcastillo.mypet.modelo.Pet;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 21,July,2020
 */


public class PetPerfilAdapter extends RecyclerView.Adapter<PetPerfilAdapter.PetPerfilViewHolder>{

    ArrayList<Pet> pets;
    Activity activity;

    public PetPerfilAdapter(ArrayList<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetPerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfilmascota, parent, false);
        return new PetPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetPerfilViewHolder petPerfilViewHolder, int position) {
        final Pet pet = pets.get(position);
        petPerfilViewHolder.ivGaleriaFoto.setImageResource(pet.getFoto());
        petPerfilViewHolder.tvPerfilRank.setText(Integer.toString(pet.getRank()));

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetPerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivGaleriaFoto;
        private ImageView ivPerfilSeeRank;
        private TextView tvPerfilRank;

        public PetPerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGaleriaFoto = (ImageView) itemView.findViewById(R.id.ivGaleriaFoto);
            ivPerfilSeeRank = (ImageView) itemView.findViewById(R.id.ivPerfilSeeRank);
            tvPerfilRank = (TextView) itemView.findViewById(R.id.tvPerfilRank);

        }
    }
}
