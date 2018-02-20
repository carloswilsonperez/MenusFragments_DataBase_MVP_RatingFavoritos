package nico.menus_fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nico.menus_fragments.adapters.MascotaAdaptador;
import nico.menus_fragments.db.BaseDatos;
import nico.menus_fragments.db.ConstantesBaseDatos;
import nico.menus_fragments.pojo.Mascota;

public class MascotasFavoritasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    MascotaAdaptador mascotaAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        //Navegación hacia atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView        = findViewById(R.id.recycler_view_mascotas_favoritas);
        mascotaAdaptador    = new MascotaAdaptador(mascotas, this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(mascotaAdaptador);
        BaseDatos bd = new BaseDatos(this);
        mascotas = bd.obtenerMascotasFavoritas();
        //prepararInfo();

    }

    private void prepararInfo() {

        mascotas.add(new Mascota("Mascota_4", R.drawable.pet_4));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_2", R.drawable.pet_2));
        mascotas.add(new Mascota("Mascota_1", R.drawable.pet_1));
        mascotas.add(new Mascota("Mascota_6", R.drawable.pet_6));

    }

//    @Override
//    public void generarLinearLayoutVertical() {
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(llm);
//    }
//
//    @Override
//    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
//        mascotaAdaptador    = new MascotaAdaptador(mascotas, this);
//        return mascotaAdaptador;
//    }
//
//    @Override
//    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
//        recyclerView.setAdapter(mascotaAdaptador);
//    }
}
