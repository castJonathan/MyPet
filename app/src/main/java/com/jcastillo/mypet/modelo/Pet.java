package com.jcastillo.mypet.modelo;

/**
 * Created by Jonathan Castillo on 14,July,2020
 */


public class Pet {
    private int id;
    private String nombre;
    private int foto;
    private int rank;

    public Pet(String nombre, int foto, int rank) {
        this.nombre = nombre;
        this.foto = foto;
        this.rank = rank;
    }

    public Pet() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
