package com.example.unpocodetodo;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class BotonImagenActivity extends AppCompatActivity {
    Switch swElegido;
    ImageView ivCmbiarr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton_imagen);


        swElegido = (Switch) findViewById(R.id.swSwitch);
        ivCmbiarr = (ImageView) findViewById(R.id.ivCambioImagen);
        ivCmbiarr.setImageResource(R.mipmap.calor);

        swElegido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swElegido.isChecked()) {
                    ivCmbiarr.setImageResource(R.mipmap.frio);
                } else {

                    ivCmbiarr.setImageResource(R.mipmap.calor);
                }
            }
        });
    }
}
