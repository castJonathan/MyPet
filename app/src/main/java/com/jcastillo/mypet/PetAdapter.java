package com.jcastillo.mypet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 14,July,2020
 */


public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    ArrayList<Pet> pets;
    Context context;

    public PetAdapter(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Inflara el layout y lo pasara al viewholder para obtener los views
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        context = parent.getContext();
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetViewHolder petViewHolder, final int position) { //asocia cada elemento de la lista con cada view
        final Pet pet = pets.get(position);
        petViewHolder.ivFoto.setImageResource(pet.getFoto());
        petViewHolder.tvRank.setText(Integer.toString(pet.getRank()));
        petViewHolder.tvNombre.setText(pet.getNombre());

        petViewHolder.ivLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int r = pet.getRank();
                pet.setRank(r + 1);
                petViewHolder.tvRank.setText(Integer.toString(pet.getRank()));
            }
        });

        petViewHolder.ivSeeRank.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogoRank = new AlertDialog.Builder(context);
                dialogoRank.setTitle(context.getString(R.string.dialog_title_ranking));
                dialogoRank.setMessage(context.getString(R.string.dialog_msj_ranking) + pet.getNombre() + " es " + pet.getRank());
                dialogoRank.setCancelable(false);
                dialogoRank.setPositiveButton(context.getString(R.string.dialog_btnAceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });
                dialogoRank.show();
            }
        });

    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista de pets
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFoto;
        private ImageView ivSeeRank;
        private ImageView ivLike;
        private TextView tvRank;
        private TextView tvNombre;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            ivSeeRank = (ImageView) itemView.findViewById(R.id.ivSeeRank);
            ivLike = (ImageView) itemView.findViewById(R.id.ivLike);
            tvRank = (TextView) itemView.findViewById(R.id.tvRank);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
        }
    }
}
