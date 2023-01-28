package com.example.holacomfama;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

public class InfoAves extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_aves);
        ActionBar barra=getSupportActionBar();

        //Cambiando el color de la barra
        ColorDrawable colorBarra= new ColorDrawable(Color.parseColor("#D81B41"));
        barra.setBackgroundDrawable(colorBarra);
    }
    //Cargar el menu xml creado previamente
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
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

    //DAR funcionamiento al menu
    public boolean onOptionsItemSelected(MenuItem item) {

        //observamos que item del menu le damos click

        int itemSeleccionado=item.getItemId();
        switch (itemSeleccionado){

            case(R.id.opcion1):
                Toast.makeText(this, "Selecionaste Acerca De", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.opcion2):
                this.cambiarIdioma("en");
                Intent intent1 = new Intent(InfoAves.this,InfoAves.class);
                startActivity(intent1);
                break;
            case(R.id.opcion3):
                this.cambiarIdioma("es");
                Intent intent2 = new Intent(InfoAves.this,InfoAves.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}