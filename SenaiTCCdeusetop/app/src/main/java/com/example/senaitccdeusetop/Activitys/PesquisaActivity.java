package com.example.senaitccdeusetop.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.senaitccdeusetop.R;

import java.lang.reflect.Array;

public class PesquisaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    Button btnPesquisar;
    Spinner spnDia,spnInicio,spnFim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);



        btnPesquisar = findViewById(R.id.btnPesquisar);
        spnDia = findViewById(R.id.spnDia);
        spnInicio = findViewById(R.id.spnInicio);
        spnFim = findViewById(R.id.spnFim);



       ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDia.setAdapter(adapter);
        spnDia.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adpHorario = ArrayAdapter.createFromResource(this,
                R.array.Horario, android.R.layout.simple_spinner_item);


        spnInicio.setOnItemSelectedListener(this);
        adpHorario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnInicio.setAdapter(adpHorario);
        spnInicio.setOnItemSelectedListener(this);


        spnFim.setOnItemSelectedListener(this);
        adpHorario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFim.setAdapter(adpHorario);
        spnFim.setOnItemSelectedListener(this);




    }
    

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch(adapterView.getId()){
            case 1:
                Toast.makeText(this, "aquui", Toast.LENGTH_SHORT).show();

        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
