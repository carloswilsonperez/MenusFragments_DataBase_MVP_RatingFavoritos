package nico.menus_fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nico.menus_fragments.R;
import nico.menus_fragments.adapters.MascotaAdaptador;
import nico.menus_fragments.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Mascota> mascotas = new ArrayList<>();
    MascotaAdaptador mascotaAdaptador;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_recycler_view, container, false);

        recyclerView    =(RecyclerView)view.findViewById(R.id.recycler_view_mascotas);
        mascotaAdaptador = new MascotaAdaptador(mascotas, getActivity());

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(mascotaAdaptador);
        prepararInfo();


        return view;
    }

    private void prepararInfo() {
        mascotas.add(new Mascota("Mascota_1", R.drawable.pet_1));
        mascotas.add(new Mascota("Mascota_2", R.drawable.pet_2));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_4", R.drawable.pet_4));
        mascotas.add(new Mascota("Mascota_5", R.drawable.pet_5));
        mascotas.add(new Mascota("Mascota_6", R.drawable.pet_6));
    }

}
