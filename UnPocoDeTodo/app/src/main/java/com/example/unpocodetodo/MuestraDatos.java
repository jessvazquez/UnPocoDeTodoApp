package com.example.unpocodetodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MuestraDatos extends AppCompatActivity {

    private TextView nombre, fecha, color, sexo;
    private Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_datos);

        nombre= findViewById(R.id.nombre);
        color= findViewById(R.id.id_colorFavorito);
        sexo= findViewById(R.id.sexo);
        Bundle bundle= getIntent().getExtras();
        if(!bundle.isEmpty()){
            nombre.setText(getIntent().getExtras().getString("nombre"));
            color.setText(getIntent().getExtras().getString("color"));
            sexo.setText(getIntent().getExtras().getString("sexo"));
        }else {
            Toast.makeText(this,"No se recibieron datos",Toast.LENGTH_LONG).show();
        }

        findViewById(R.id.btn_sig).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MuestraDatos.this,Botones.class);
                startActivity(intent);
            }
        });


    }


}
