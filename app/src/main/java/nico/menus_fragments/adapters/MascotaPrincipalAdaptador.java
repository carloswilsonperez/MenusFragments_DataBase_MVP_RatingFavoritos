package nico.menus_fragments.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import nico.menus_fragments.R;
import nico.menus_fragments.pojo.Mascota;

/**
 * Created by Nico on 10/02/2018.
 */

public class MascotaPrincipalAdaptador extends RecyclerView.Adapter<MascotaPrincipalAdaptador.MiMascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaPrincipalAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_mascota_principal, parent, false);
        return new MiMascotaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MiMascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.image_view_mascota.setImageResource(mascota.getFoto());
        holder.text_view_like_counter.setText(String.valueOf(mascota.getLikes()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MiMascotaViewHolder extends RecyclerView.ViewHolder{

        ImageView image_view_mascota;
        TextView text_view_like_counter;
        ImageView image_view_dog_total_like;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);

            image_view_mascota          = (ImageView)itemView.findViewById(R.id.image_view_mascota);
            text_view_like_counter      = (TextView)itemView.findViewById(R.id.text_view_like_counter);
            image_view_dog_total_like   = (ImageView)itemView.findViewById(R.id.image_view_dog_total_like);

        }
    }
}
