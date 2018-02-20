package nico.menus_fragments.view_fragments;


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
import nico.menus_fragments.presentador.IRecyclerViewFragmentPresenter;
import nico.menus_fragments.presentador.RecyclerViewFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    RecyclerView recyclerView;
    ArrayList<Mascota> mascotas = new ArrayList<>();
    MascotaAdaptador mascotaAdaptador;
    IRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter;


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
        iRecyclerViewFragmentPresenter = new RecyclerViewFragmentPresenter(this,getContext());

        return view;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        mascotaAdaptador = new MascotaAdaptador(mascotas, getActivity());
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        recyclerView.setAdapter(mascotaAdaptador);
    }
}
