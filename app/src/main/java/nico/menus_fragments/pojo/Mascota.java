package nico.menus_fragments.pojo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Nico on 10/02/2018.
 */

public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int likes;

    public Mascota(String nombre, int foto){
        this.nombre =nombre;
        this.foto   =foto;
//        this.likes  = ThreadLocalRandom.current().nextInt(1, 10);
        this.likes  = 0;
    }

    public Mascota() {

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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


