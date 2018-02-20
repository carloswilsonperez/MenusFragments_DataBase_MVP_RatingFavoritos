package nico.menus_fragments.db;

import android.content.ContentValues;
import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import nico.menus_fragments.R;
import nico.menus_fragments.pojo.Mascota;

/**
 * Created by Nico on 17/02/2018.
 */

public class ConstructorMascotas {

    Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos bd = new BaseDatos(context);
        insertarMascotas(bd);
        return bd.obtenerTodasLasMascotas();

    }

    public void insertarMascotas(BaseDatos bd){
        ContentValues cv = new ContentValues();

        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota_1");
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pet_1);
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, ThreadLocalRandom.current().nextInt(1, 10));

        bd.insertarMascota(cv);

        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota_2");
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pet_2);
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, ThreadLocalRandom.current().nextInt(1, 10));

        bd.insertarMascota(cv);

        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota_3");
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pet_3);
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, ThreadLocalRandom.current().nextInt(1, 10));

        bd.insertarMascota(cv);

        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota_4");
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pet_4);
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, ThreadLocalRandom.current().nextInt(1, 10));

        bd.insertarMascota(cv);
        bd.close();
    }

    public void darLikeMascota(Mascota mascota){

        BaseDatos bd = new BaseDatos(context);

        ContentValues cv = new ContentValues();

        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, mascota.getId());
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, mascota.getLikes());
        bd.insertarLikesMascota(cv);
    }

    public ArrayList<Mascota> obtenerDatosMascotasFavoritas() {
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerMascotasFavoritas();
    }
}
