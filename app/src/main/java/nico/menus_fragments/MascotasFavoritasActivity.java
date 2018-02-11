package nico.menus_fragments;

import android.app.ActionBar;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

import nico.menus_fragments.adapters.MascotaAdaptador;
import nico.menus_fragments.pojo.Mascota;

public class MascotasFavoritasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Mascota> mascotas = new ArrayList<>();
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

        mascotas.add(new Mascota("Mascota_4", R.drawable.pet_4));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_2", R.drawable.pet_2));
        mascotas.add(new Mascota("Mascota_1", R.drawable.pet_1));
        mascotas.add(new Mascota("Mascota_6", R.drawable.pet_6));
    }

}
