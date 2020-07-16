package com.jcastillo.mypet;

/**
 * Created by Jonathan Castillo on 14,July,2020
 */


public class Pet {
    private String nombre;
    private int foto;
    private int rank = 0;

    public Pet(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
