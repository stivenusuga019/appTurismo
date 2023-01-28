package com.example.holacomfama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //ATRIBUTOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar barra=getSupportActionBar();

        //Cambiando el color de la barra
        ColorDrawable colorBarra= new ColorDrawable(Color.parseColor("#D81B41"));
        barra.setBackgroundDrawable(colorBarra);
    }

    //Metodo para cambiar el idioma de mi app
     public void cambiarIdioma(String idioma){

        //Configurando el lenguaje del celular
         Locale lenguaje= new Locale(idioma);
         Locale.setDefault(lenguaje);

         //configuración global en el celular

         Configuration configurationTelefono=getResources().getConfiguration();
         configurationTelefono.locale=lenguaje;

         //ejecutamos la configuración
         getBaseContext().getResources().updateConfiguration(configurationTelefono,getBaseContext().getResources().getDisplayMetrics());

     }

    public void  pajaros(View view){
        Intent pajaros = new Intent(MainActivity.this,InfoAves.class);
        startActivity(pajaros);
    }

    //Cargar el menu xml creado previamente
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //DAR funcionamiento al menu
    public boolean onOptionsItemSelected(MenuItem item) {

        //observamos que item del menu le damos click

        int itemSeleccionado=item.getItemId();
        switch (itemSeleccionado){

            case(R.id.opcion1):
                Intent IntentA = new Intent(getApplicationContext(),Acercade.class);
                startActivity(IntentA);
                break;
            case(R.id.opcion2):
                this.cambiarIdioma("en");
                Intent intent1 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            case(R.id.opcion3):
                this.cambiarIdioma("es");
                Intent intent2 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}