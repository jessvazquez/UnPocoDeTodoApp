package com.example.unpocodetodo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;


public class VentanaPopActivity extends AppCompatDialogFragment {

    Button btn_activarVentana;
    private EditText webpage;
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Datos")
                .setMessage("Nombre: David de Jesus Vazquez Salas.\nMateria: Desarrollo Móvil\nGrupo: S9\nMaestra: Rocio E. Pulido A.")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

        return builder.create();
    }
}
