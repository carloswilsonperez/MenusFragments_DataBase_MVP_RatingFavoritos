package nico.menus_fragments.fragments;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nico.menus_fragments.R;
import nico.menus_fragments.adapters.MascotaAdaptador;
import nico.menus_fragments.adapters.MascotaPrincipalAdaptador;
import nico.menus_fragments.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Mascota> mascotas = new ArrayList<>();
    MascotaPrincipalAdaptador mascotaPrincipalAdaptador;
    ImageView imageView;
    TextView text_view_nombre_mascota;
    private Resources mResources;

    public MascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mResources = getResources();

        View view;
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_mascota, container, false);

        recyclerView    =(RecyclerView)view.findViewById(R.id.recycler_view_mascota);
        mascotaPrincipalAdaptador = new MascotaPrincipalAdaptador(mascotas, getActivity());
        imageView = (ImageView)view.findViewById(R.id.image_view_round);
        text_view_nombre_mascota = (TextView)view.findViewById(R.id.text_view_nombre_mascota);
        text_view_nombre_mascota.setText("Mascota_3");

        //Round image
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pet_3);
        RoundedBitmapDrawable rbd = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        rbd.setCircular(true);
        imageView.setImageDrawable(createRoundedBitmapDrawableWithBorder(bitmap));


//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(llm);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mascotaPrincipalAdaptador);
        
        prepararInfo();
        
        return view;
    }

    private void prepararInfo() {
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));
        mascotas.add(new Mascota("Mascota_3", R.drawable.pet_3));

    }

    private RoundedBitmapDrawable createRoundedBitmapDrawableWithBorder(Bitmap bitmap){
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int borderWidthHalf = 10; // In pixels
        //Toast.makeText(mContext,""+bitmapWidth+"|"+bitmapHeight,Toast.LENGTH_SHORT).show();

        // Calculate the bitmap radius
        int bitmapRadius = Math.min(bitmapWidth,bitmapHeight)/2;

        int bitmapSquareWidth = Math.min(bitmapWidth,bitmapHeight);
        //Toast.makeText(mContext,""+bitmapMin,Toast.LENGTH_SHORT).show();

        int newBitmapSquareWidth = bitmapSquareWidth+borderWidthHalf;
        //Toast.makeText(mContext,""+newBitmapMin,Toast.LENGTH_SHORT).show();

        /*
            Initializing a new empty bitmap.
            Set the bitmap size from source bitmap
            Also add the border space to new bitmap
        */
        Bitmap roundedBitmap = Bitmap.createBitmap(newBitmapSquareWidth,newBitmapSquareWidth,Bitmap.Config.ARGB_8888);

        /*
            Canvas
                The Canvas class holds the "draw" calls. To draw something, you need 4 basic
                components: A Bitmap to hold the pixels, a Canvas to host the draw calls (writing
                into the bitmap), a drawing primitive (e.g. Rect, Path, text, Bitmap), and a paint
                (to describe the colors and styles for the drawing).

            Canvas(Bitmap bitmap)
                Construct a canvas with the specified bitmap to draw into.
        */
        // Initialize a new Canvas to draw empty bitmap
        Canvas canvas = new Canvas(roundedBitmap);

        /*
            drawColor(int color)
                Fill the entire canvas' bitmap (restricted to the current clip) with the specified
                color, using srcover porterduff mode.
        */
        // Draw a solid color to canvas
        canvas.drawColor(mResources.getColor(R.color.colorPrimaryDark));

        // Calculation to draw bitmap at the circular bitmap center position
        int x = borderWidthHalf + bitmapSquareWidth - bitmapWidth;
        int y = borderWidthHalf + bitmapSquareWidth - bitmapHeight;

        /*
            drawBitmap(Bitmap bitmap, float left, float top, Paint paint)
                Draw the specified bitmap, with its top/left corner at (x,y), using the specified
                paint, transformed by the current matrix.
        */
        /*
            Now draw the bitmap to canvas.
            Bitmap will draw its center to circular bitmap center by keeping border spaces
        */
        canvas.drawBitmap(bitmap, x, y, null);

        // Initializing a new Paint instance to draw circular border
        Paint borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(borderWidthHalf*2);
        borderPaint.setColor(Color.WHITE);

        /*
            drawCircle(float cx, float cy, float radius, Paint paint)
                Draw the specified circle using the specified paint.
        */
        /*
            Draw the circular border to bitmap.
            Draw the circle at the center of canvas.
         */
        canvas.drawCircle(canvas.getWidth()/2, canvas.getWidth()/2, newBitmapSquareWidth/2, borderPaint);

        /*
            RoundedBitmapDrawable
                A Drawable that wraps a bitmap and can be drawn with rounded corners. You can create
                a RoundedBitmapDrawable from a file path, an input stream, or from a Bitmap object.
        */
        /*
            public static RoundedBitmapDrawable create (Resources res, Bitmap bitmap)
                Returns a new drawable by creating it from a bitmap, setting initial target density
                based on the display metrics of the resources.
        */
        /*
            RoundedBitmapDrawableFactory
                Constructs RoundedBitmapDrawable objects, either from Bitmaps directly, or from
                streams and files.
        */
        // Create a new RoundedBitmapDrawable
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mResources,roundedBitmap);

        /*
            setCornerRadius(float cornerRadius)
                Sets the corner radius to be applied when drawing the bitmap.
        */
        // Set the corner radius of the bitmap drawable
        roundedBitmapDrawable.setCornerRadius(bitmapRadius);

        /*
            setAntiAlias(boolean aa)
                Enables or disables anti-aliasing for this drawable.
        */
        roundedBitmapDrawable.setAntiAlias(true);

        // Return the RoundedBitmapDrawable
        return roundedBitmapDrawable;
    }

}
