package nico.menus_fragments.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;

import nico.menus_fragments.pojo.Mascota;

/**
 * Created by Nico on 18/02/2018.
 */

public class BaseDatos extends SQLiteOpenHelper {

    Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String quertyCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "("+
                ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO     + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES    + " INTEGER )";

        sqLiteDatabase.execSQL(quertyCrearTablaMascota);
        //sqLiteDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String querty = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =  db.rawQuery(querty, null);

        while (registros.moveToNext()){
            Mascota actual = new Mascota();
            actual.setId(registros.getInt(0));
            actual.setNombre(registros.getString(1));
            actual.setFoto(registros.getInt(2));
            actual.setLikes(registros.getInt(3));
            mascotas.add(actual);
        }

        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        sqLiteDatabase.close();
    }

    public void insertarLikesMascota(ContentValues cv){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update (ConstantesBaseDatos.TABLE_MASCOTAS, cv,
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + cv.get(ConstantesBaseDatos.TABLE_MASCOTAS_ID),
                null);
        sqLiteDatabase.close();
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {
        ArrayList<Mascota> mascotas_f = new ArrayList<Mascota>();

        String querty = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS
                + " ORDER BY " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " DESC LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =  db.rawQuery(querty, null);

        while (cursor.moveToNext()){
            Mascota actual = new Mascota();
            actual.setId(cursor.getInt(0));
            actual.setNombre(cursor.getString(1));
            actual.setFoto(cursor.getInt(2));
            actual.setLikes(cursor.getInt(3));
            mascotas_f.add(actual);
        }

        db.close();
        return mascotas_f;
    }
}
