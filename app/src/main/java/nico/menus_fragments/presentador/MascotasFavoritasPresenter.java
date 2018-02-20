package nico.menus_fragments.presentador;

import android.content.Context;

import java.util.ArrayList;

import nico.menus_fragments.IMascotasFavoritasActivity;
import nico.menus_fragments.db.ConstructorMascotas;
import nico.menus_fragments.pojo.Mascota;
import nico.menus_fragments.view_fragments.IRecyclerViewFragmentView;

/**
 * Created by Nico on 19/02/2018.
 */

public class MascotasFavoritasPresenter implements IMascotasFavoritasPresenter {

    IMascotasFavoritasActivity iMascotasFavoritasActivity;
    Context context;
    ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public MascotasFavoritasPresenter(IMascotasFavoritasActivity iMascotasFavoritasActivity, Context context) {
        this.iMascotasFavoritasActivity = iMascotasFavoritasActivity;
        this.context = context;
        obtenerMascotasFavoritasBD();
    }

    @Override
    public void obtenerMascotasFavoritasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosMascotasFavoritas();
        mostrarMascotasFavoritas();
    }

    @Override
    public void mostrarMascotasFavoritas() {
        iMascotasFavoritasActivity.inicializarAdaptadorRV(iMascotasFavoritasActivity.crearAdaptador(mascotas));
        iMascotasFavoritasActivity.generarLinearLayoutVertical();

    }
}
