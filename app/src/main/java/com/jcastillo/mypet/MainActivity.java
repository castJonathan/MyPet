package com.jcastillo.mypet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jcastillo.mypet.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> pets;

    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();


    }

    public void inicializarAdaptador(){
        PetAdapter adaptador = new PetAdapter(pets);
        rvMascotas.setAdapter(adaptador);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mSettings:
                Toast.makeText(this, R.string.menu_titulo, Toast.LENGTH_LONG).show();
                break;
            case R.id.mTopPet:
                Intent i = new Intent(MainActivity.this, TopPet.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}