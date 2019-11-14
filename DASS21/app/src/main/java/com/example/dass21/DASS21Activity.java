package com.example.dass21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DASS21Activity extends AppCompatActivity {

    TextView tvPergunta;
    RadioButton rbResposta0, rbResposta1, rbResposta2, rbResposta3, rb;
    RadioGroup rgRespostas;
    Button btnConcluir;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dass21);

        tvPergunta = findViewById(R.id.tvPergunta);
        rgRespostas = findViewById(R.id.rgRespostas);
        rbResposta0 = findViewById(R.id.rbResposta0);
        rbResposta1 = findViewById(R.id.rbResposta1);
        rbResposta2 = findViewById(R.id.rbResposta2);
        rbResposta3 = findViewById(R.id.rbResposta3);

        btnConcluir = findViewById(R.id.btnConcluir);

        carregarPergunta();
    }

    List<Pergunta> perguntas = new ArrayList<Pergunta>() {
        {
            add(new Pergunta(1, "0-Minha boca ficou seca"));
            add(new Pergunta(2, "1-Nao tive nenhum sentimento positivo"));
            add(new Pergunta(1, "2-Em alguns momentos tive dificuldade de respirar (chiado e falta de ar sem esforço físico)"));
            add(new Pergunta(2, "3-Não consegui ter iniciativa para fazer as coisas"));
        }
    };

    //LISTA DE RESPOSTAS ANSIEDADE
    ArrayList<Integer> ansiedade = new ArrayList<Integer>(){
        {
            add(null);
            add(null);
        }
    };

    //LISTA DE RESPOSTAS DEPRESSAO
    ArrayList<Integer> depressao = new ArrayList<Integer>(){
        {
            add(null);
            add(null);
        }
    };

    private void carregarPergunta() {
        Pergunta p = perguntas.get(contador);
        tvPergunta.setText(p.getPergunta());
        rgRespostas.clearCheck();

        /*if(ansiedade.get(0) != 4 & ansiedade.get(1) != 4 & depressao.get(0) != 4 & depressao.get(1) != 4){
            btnConcluir.setVisibility(View.VISIBLE);
        }*/
    }

    public void btnConcluirOnClick(View v){

    }

    public void btnPrevOnClick (View v){
        if (contador <= 0) {
            contador = 0;
        } else {
            contador--;
        }
        onRestart();
    }

    public void btnNextOnClick (View v){
        Log.i("Evento", "btNext Clicado");
        adicionarResposta();

        if (contador >= 3) {
            contador = 3;
        } else {
            contador++;
        }
        onRestart();
    }

    public void adicionarResposta(){
        if (contador == 0) {
            Log.i("Evento", "Pergunta A1");
            adicionarAnsiedade();
        }else
        if (contador == 1) {
            Log.i("Evento", "Pergunta D1");
            adicionarDepressao();
        }else
        if (contador == 2) {
            Log.i("Evento", "Pergunta A2");
            adicionarAnsiedade();
        }else
        if(contador == 3) {
            Log.i("Evento", "Pergunta D2");
            adicionarDepressao();
        }
    }

    public void adicionarAnsiedade(){
        rgRespostas = findViewById(R.id.rgRespostas);
        rb = findViewById(rgRespostas.getCheckedRadioButtonId());

        if (contador == 0) {
            if (rb == rbResposta0){
                ansiedade.set(0, 0);
            }else
            if (rb == rbResposta1){
                ansiedade.set(0, 1);
            }else
            if (rb == rbResposta2){
                ansiedade.set(0, 2);
            }else
            if (rb == rbResposta3){
                ansiedade.set(0, 3);
            }
            log();
        }else
        if (contador == 2) {
            if (rb == rbResposta0){
                ansiedade.set(1, 0);
            }else
            if (rb == rbResposta1){
                ansiedade.set(1, 1);
            }else
            if (rb == rbResposta2){
                ansiedade.set(1, 2);
            }else
            if (rb == rbResposta3){
                ansiedade.set(1, 3);
            }
            log();
        }
    }

    public void adicionarDepressao(){
        if (contador == 1) {
            if (rb == rbResposta0){
                depressao.set(0, 0);
            }else
            if (rb == rbResposta1){
                depressao.set(0, 1);
            }else
            if (rb == rbResposta2){
                depressao.set(0, 2);
            }else
            if (rb == rbResposta3){
                depressao.set(0, 3);
            }
            log();
        }else
        if (contador == 3) {
            if (rb == rbResposta0){
                depressao.set(1, 0);
            }else
            if (rb == rbResposta1){
                depressao.set(1, 1);
            }else
            if (rb == rbResposta2){
                depressao.set(1, 2);
            }else
            if (rb == rbResposta3){
                depressao.set(1, 3);
            }
            log();
        }
    }

    public void log(){
        System.out.println("Contador " + contador);

        System.out.println("Lista A " + ansiedade);
        System.out.println("Lista D " + depressao);
    }

    @Override
    protected void onRestart () {
        super.onRestart();
        carregarPergunta();
    }
}
