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
    List<Pergunta> perguntas;

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


        perguntas = new ArrayList<Pergunta>() {
            {
                add(new Pergunta(1, "0-Minha boca ficou seca", 4));
                add(new Pergunta(2, "1-Nao tive nenhum sentimento positivo", 4));
                add(new Pergunta(1, "2-Em alguns momentos tive dificuldade de respirar (chiado e falta de ar sem esforço físico)", 4));
                add(new Pergunta(2, "3-Não consegui ter iniciativa para fazer as coisas", 4));
            }
        };

        carregarPergunta();
    }


    private void carregarPergunta() {
        Pergunta p = perguntas.get(contador);
        tvPergunta.setText(p.getPergunta());
        rgRespostas.clearCheck();

        print();

        if(verificaResposta()){
            btnConcluir.setVisibility(View.VISIBLE);
        }
    }

    public void btnConcluirOnClick(View v){
        int a = 0 , d = 0, s = 0;

        for(int i =0; i <= 3 ; i++){
            if(perguntas.get(i).getTipoADS() == 1){
                a += perguntas.get(i).getRes();
            }else
            if(perguntas.get(i).getTipoADS() == 2){
                d += perguntas.get(i).getRes();
            }else
            if(perguntas.get(i).getTipoADS() == 3){
                s += perguntas.get(i).getRes();
            }
        }

        a = a * 2;
        d = d * 2;
        s = s * 2;


        Log.i("Valor", String.valueOf(a));
        Log.i("Valor", String.valueOf(d));
        Log.i("Valor", String.valueOf(s));

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
        perguntas.get(contador).setRes(getRes());
    }

    public int getRes(){
        rgRespostas = findViewById(R.id.rgRespostas);
        rb = findViewById(rgRespostas.getCheckedRadioButtonId());

        if (rb == rbResposta0){
            return 0;
        }else
        if (rb == rbResposta1){
            return 1;
        }else
        if (rb == rbResposta2){
            return 2;
        }else
        if (rb == rbResposta3){
            return 3;
        }
        return 0;
    }

    public boolean verificaResposta() {
        boolean respondida = false;
        int respondidas = 0;


        for (int i = 0; i <= 3; i++) {
            if (perguntas.get(i).getRes() == 4) {

            } else if (perguntas.get(i).getRes() != 4) {
                respondidas++;
            }
        }

        if (respondidas == 4) {
            return true;
        } else {
            return false;
        }

    }

    public void print(){
        Log.i("Evento", "Resposta 0 " + + perguntas.get(0).getRes());
        Log.i("Evento", "Resposta 1 " + + perguntas.get(1).getRes());
        Log.i("Evento", "Resposta 2 " + + perguntas.get(2).getRes());
        Log.i("Evento", "Resposta 3 " + + perguntas.get(3).getRes());
    }

    @Override
    protected void onRestart () {
        super.onRestart();
        carregarPergunta();
    }
}
