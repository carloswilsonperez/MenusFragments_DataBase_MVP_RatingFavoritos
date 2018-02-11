package nico.menus_fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nico.menus_fragments.email.SendMail;
import nico.menus_fragments.main.MainActivity;

public class ContactoActivity extends AppCompatActivity {

    EditText input_nombre;
    EditText input_email;
    EditText input_comentario;
    Button btn_enviar_com;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        //Navegación hacia atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        input_nombre        =(EditText)findViewById(R.id.input_nombre);
        input_email         =(EditText)findViewById(R.id.input_email);
        input_comentario    =(EditText)findViewById(R.id.input_comentario);
        btn_enviar_com      =(Button) findViewById(R.id.btn_enviar_com);

        btn_enviar_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = input_email.getText().toString().trim();
                String subject = "Nuevo Correo";
                String message = input_comentario.getText().toString().trim();

                //Creating SendMail object
                SendMail sm = new SendMail(getBaseContext(), email, subject, message);
                //Executing sendmail to send email
                sm.execute();

                Toast.makeText(getApplicationContext(), getResources().getString(R.string.msj_enviado) , Toast.LENGTH_SHORT).show();

                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
