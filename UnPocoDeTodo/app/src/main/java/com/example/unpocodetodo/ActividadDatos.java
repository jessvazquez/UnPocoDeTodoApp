package com.example.unpocodetodo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ActividadDatos extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView date;
    private int mYear, mMonth, mDay;
    private String color, sexo, fecha, nombre1;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private DatePickerDialog.OnDateSetListener fechaNacimiento;
    private EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_datos);


        nombre = findViewById(R.id.id_nombre);

        obtenerDatosSpinner();
        date = findViewById(R.id.id_fecha);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarFecha();
            }
        });
        ponerFecha();
        findViewById(R.id.btn_ingresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sexoDatos();
                nombre1 = nombre.getText().toString();
                Intent intent = new Intent(ActividadDatos.this, MuestraDatos.class);
                enviar(intent);
                startActivity(intent);
            }
        });


    }


    private void enviar(Intent intent) {
        intent.putExtra("nombre", nombre1);
        intent.putExtra("fecha", fecha);
        intent.putExtra("color", color);
        intent.putExtra("sexo", sexo);
    }

    private void obtenerDatosSpinner() {
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void sexoDatos() {
        radioSexGroup = findViewById(R.id.radioSex);
        // get selected radio button from radioGroup
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        radioSexButton = findViewById(selectedId);
        sexo = radioSexButton.getText().toString();
    }

    private void mostrarFecha() {
        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog, fechaNacimiento,
                mYear, mMonth, mDay);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    private void ponerFecha() {
        fechaNacimiento = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                mes = mes + 1;
                fecha = anio + "/" + mes + "/" + dia;
                date.setText(fecha);
            }
        };
    }


    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        color = adapterView.getItemAtPosition(i).toString();
      //  Toast.makeText(adapterView.getContext(), color, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
