package nico.menus_fragments;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import nico.menus_fragments.adapters.MascotaAdaptador;
import nico.menus_fragments.db.BaseDatos;
import nico.menus_fragments.db.ConstantesBaseDatos;
import nico.menus_fragments.db.ConstructorMascotas;
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
        prepararInfo();

    }

    private void prepararInfo() {
        ArrayList<Mascota> mf = new ArrayList<Mascota>();
        BaseDatos bd = new BaseDatos(getApplicationContext());
        mf = bd.obtenerMascotasFavoritas();

        for(int i=0;i<mf.size();i++){
                mascotas.add(new Mascota(mf.get(i).getId(), mf.get(i).getNombre(), mf.get(i).getFoto(), mf.get(i).getLikes()));
        }

    }
}
