package nico.menus_fragments;

import java.util.ArrayList;

import nico.menus_fragments.adapters.MascotaAdaptador;
import nico.menus_fragments.pojo.Mascota;

/**
 * Created by Nico on 19/02/2018.
 */

public interface IMascotasFavoritasActivity {

    public void generarLinearLayoutVertical ();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
