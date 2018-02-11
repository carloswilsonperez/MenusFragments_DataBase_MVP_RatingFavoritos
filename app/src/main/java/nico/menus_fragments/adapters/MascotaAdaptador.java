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

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MiMascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_mascota, parent, false);
        return new MiMascotaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MiMascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.image_view_mascota.setImageResource(mascota.getFoto());
        holder.text_view_nombre_mascota.setText(mascota.getNombre());
        holder.text_view_like_counter.setText(String.valueOf(mascota.getLikes()));

        holder.image_view_dog_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setLikes(mascota.getLikes()+1);
                Toast.makeText(activity, mascota.getLikes() + " Likes a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MiMascotaViewHolder extends RecyclerView.ViewHolder{

        ImageView image_view_mascota;
        ImageView image_view_dog_like;
        TextView text_view_nombre_mascota;
        TextView text_view_like_counter;
        ImageView image_view_dog_total_like;
        ImageView image_view_back_button;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);

            image_view_mascota          = (ImageView)itemView.findViewById(R.id.image_view_mascota);
            image_view_dog_like         = (ImageView)itemView.findViewById(R.id.image_view_dog_like);
            text_view_nombre_mascota    = (TextView) itemView.findViewById(R.id.text_view_nombre_mascota);
            text_view_like_counter      = (TextView)itemView.findViewById(R.id.text_view_like_counter);
            image_view_dog_total_like   = (ImageView)itemView.findViewById(R.id.image_view_dog_total_like);

        }
    }
}
