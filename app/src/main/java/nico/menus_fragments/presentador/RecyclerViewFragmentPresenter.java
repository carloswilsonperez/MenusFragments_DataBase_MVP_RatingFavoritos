package nico.menus_fragments.presentador;

import android.content.Context;

import java.util.ArrayList;

import nico.menus_fragments.db.ConstructorMascotas;
import nico.menus_fragments.pojo.Mascota;
import nico.menus_fragments.view_fragments.IRecyclerViewFragmentView;

/**
 * Created by Nico on 17/02/2018.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    IRecyclerViewFragmentView iRecyclerViewFragmentView;
    Context context;
    ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
