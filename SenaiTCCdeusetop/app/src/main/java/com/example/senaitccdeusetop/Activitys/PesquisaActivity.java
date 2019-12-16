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

<<<<<<< HEAD
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PesquisaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
=======
import java.lang.reflect.Array;

public class PesquisaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
>>>>>>> parent of f1993f7... 16/12 marcos

    Button btnPesquisar;
    Spinner spnDia,spnInicio,spnFim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
<<<<<<< HEAD
        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pesquisar(diaFormatado, inicio, fim);
            }
        });
=======

>>>>>>> parent of f1993f7... 16/12 marcos


        spnDia = findViewById(R.id.spnDia);
        spnDia.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adpDias = ArrayAdapter.createFromResource(this,
                R.array.dias, android.R.layout.simple_spinner_item);
        adpDias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDia.setAdapter(adpDias);



        ArrayAdapter<CharSequence> adpHorario = ArrayAdapter.createFromResource(this,
                R.array.Horario, android.R.layout.simple_spinner_item);

        spnInicio = findViewById(R.id.spnInicio);
        spnInicio.setOnItemSelectedListener(this);
        adpHorario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnInicio.setAdapter(adpHorario);


        spnFim = findViewById(R.id.spnFim);
        spnFim.setOnItemSelectedListener(this);
        adpHorario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFim.setAdapter(adpHorario);




    }
    

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
