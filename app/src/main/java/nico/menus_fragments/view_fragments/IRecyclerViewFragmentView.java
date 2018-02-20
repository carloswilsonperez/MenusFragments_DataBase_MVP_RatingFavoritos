package nico.menus_fragments.view_fragments;

import java.util.ArrayList;

import nico.menus_fragments.adapters.MascotaAdaptador;
import nico.menus_fragments.pojo.Mascota;

/**
 * Created by Nico on 15/02/2018.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical ();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
