package com.example.anamnese;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements RecyclerViewAdapter.OnNoteListenner {

    List<Integer> ansiedade = new ArrayList<Integer>();

    List<Pergunta> perguntas = new ArrayList<Pergunta>() {
        {
            add(new Pergunta(3, "1-Tive dificuldade de me acalmar", "0", "1", "2", "3"));
            add(new Pergunta(1, "2-Minha boca ficou seca", "0", "1", "2", "3"));
            add(new Pergunta(2, "3-Nao tive nenhum sentimento positivo", "0", "1", "2", "3"));
            add(new Pergunta(1, "4-Em alguns momentos tive dificuldade de respirar (chiado e falta de ar sem esforço físico)", "0", "1", "2", "3"));
            add(new Pergunta(2, "5-Não consegui ter iniciativa para fazer as coisas", "0", "1", "2", "3"));
            add(new Pergunta(3, "6-Exagerei intencionalmente ao reagir a situações", "0", "1", "2", "3"));
            add(new Pergunta(1, "7-Tive tremedeira (por exemplo, nas mãos)", "0", "1", "2", "3"));
            add(new Pergunta(3, "8-Senti que estava sempre nervoso(a)", "0", "1", "2", "3"));
            add(new Pergunta(1, "9-Me preocupei com situações em que poderia entrar em pânico e parecer ridículo(a)", "0", "1", "2", "3"));
            add(new Pergunta(2, "10-Senti que não tinha vontade de nada", "0", "1", "2", "3"));
            add(new Pergunta(3, "11-Me senti inquieto(a)", "0", "1", "2", "3"));
            add(new Pergunta(3, "12-Tive dificuldade de relaxar", "0", "1", "2", "3"));
            add(new Pergunta(2, "13-Me senti deprimido e sem motivação", "0", "1", "2", "3"));
            add(new Pergunta(3, "14-Eu não conseguia tolerar as coisas que me impediam de continuar a fazer o que estava realizando", "0", "1", "2", "3"));
            add(new Pergunta(1, "15-Eu senti que ia entrar em pânico", "0", "1", "2", "3"));
            add(new Pergunta(2, "16-Nada me deixou entusiasmado", "0", "1", "2", "3"));
            add(new Pergunta(2, "17-Eu senti que era uma pessoa sem valor", "0", "1", "2", "3"));
            add(new Pergunta(3, "18-Eu senti que estava sendo muito sensível/emotivo", "0", "1", "2", "3"));
            add(new Pergunta(1, "19-Eu percebi uma mudança nos meus batimentos cardíacos embora não estivesse praticando exercício rigoroso (ex. batimento cardíaco acelerado ou irregular)", "0", "1", "2", "3"));
            add(new Pergunta(1, "20-Eu senti medo sem motivo", "0", "1", "2", "3"));
            add(new Pergunta(2, "21-Senti que a vida não tinha sentido", "0", "1", "2", "3"));
        }
    };

    TextView pergunta;
    RadioButton rbResposta0, rbResposta1, rbResposta2, rbResposta3;
    int tipoADS, contador = 0;
    Resposta a, d, s;
    private ArrayList<Integer> mNumeros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pergunta = (TextView) findViewById(R.id.pergunta);
        rbResposta0 = (RadioButton) findViewById(R.id.rbResposta0);
        rbResposta1 = (RadioButton) findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton) findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton) findViewById(R.id.rbResposta3);
        getNumeros();
        carregarPergunta();
    }

    private void getNumeros() {

        mNumeros.add(1);
        mNumeros.add(2);
        mNumeros.add(3);
        mNumeros.add(4);
        mNumeros.add(5);
        mNumeros.add(6);
        mNumeros.add(7);
        mNumeros.add(8);
        mNumeros.add(9);
        mNumeros.add(10);
        mNumeros.add(11);
        mNumeros.add(12);
        mNumeros.add(13);
        mNumeros.add(14);
        mNumeros.add(15);
        mNumeros.add(16);
        mNumeros.add(17);
        mNumeros.add(18);
        mNumeros.add(19);
        mNumeros.add(20);
        mNumeros.add(21);

        initRecyclerView();
    }

        private void initRecyclerView() {

            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(layoutManager);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNumeros, this);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void onNoteClick(int position) {
            Log.i("OnNoteClick", "clicado chapa");
            if (mNumeros.get(position) == 0) {
                contador = mNumeros.get(position+1);
            } else if(mNumeros.get(position)>= 1){
                contador = mNumeros.get(position);
                contador--;
            }
            Log.i("position",String.valueOf(mNumeros.get(position)));
            onRestart();
        }

        private void carregarPergunta(){

            RadioGroup rgRespostas = (RadioGroup) findViewById(R.id.rgRespostas);

            if (perguntas.size() > 0) {
                Pergunta p = perguntas.get(contador);
                tipoADS = p.getTipoADS();
                pergunta.setText(p.getPergunta());
                List<String> respostas = p.getRespostas();
                rbResposta0.setText(respostas.get(0));
                rbResposta1.setText(respostas.get(1));
                rbResposta2.setText(respostas.get(2));
                rbResposta3.setText(respostas.get(3));
                rgRespostas.clearCheck();
            } else { //acabaram as questões
                //mandar para outra tela
            }

        }

        public void rvButtonOnclick (View v){
            /*carregarPergunta(btPergunta.getId());*/
        }

        public void btnPrevOnClick (View v){
            RadioGroup rgRespostas = (RadioGroup) findViewById(R.id.rgRespostas);
            RadioButton rb = (RadioButton) findViewById(rgRespostas.getCheckedRadioButtonId());

            if (contador <= 0) {
                contador = 0;
            } else {
                contador--;
            }
            onRestart();
        }

        public void btnNextOnClick (View v){
            RadioGroup rgRespostas = (RadioGroup) findViewById(R.id.rgRespostas);
            RadioButton rb = (RadioButton) findViewById(rgRespostas.getCheckedRadioButtonId());

            if (contador == 0) {

            }

            if (contador >= 20) {
                contador = 20;
            } else {
                contador++;
            }
            onRestart();
        }

    /*
    private void carregarPergunta(){

        RadioGroup rgRespostas = (RadioGroup)findViewById(R.id.rgRespostas);

        if(perguntas.size() > 0){
            Pergunta p = perguntas.remove(0);;
            tipoADS = p.getTipoADS();
            pergunta.setText(p.getPergunta());
            List<String> respostas = p.getRespostas();
            rbResposta0.setText(respostas.get(0));
            rbResposta1.setText(respostas.get(1));
            rbResposta2.setText(respostas.get(2));
            rbResposta3.setText(respostas.get(3));
            rgRespostas.clearCheck();
        }else{ //acabaram as questões
            //mandar para outra tela
        }

    }


    public void btnResponderOnClick(View v){
        RadioGroup rgRespostas = (RadioGroup)findViewById(R.id.rgRespostas);
        RadioButton rb = (RadioButton)findViewById(rgRespostas.getCheckedRadioButtonId());
        if(tipoADS == 1){
            Log.i("tipoADS", "1");
            if(rbResposta0.isChecked()){
                a = a + 0;
            }
            if(rbResposta1.isChecked()){
                a = a + 1;
            }
            if(rbResposta2.isChecked()){
                a = a + 2;
            }
            if(rbResposta3.isChecked()){
                a = a + 3;
            }
        }

        if(tipoADS == 2){
            Log.i("tipoADS", "2");
            if(rbResposta0.isChecked()){
                d = d + 0;
            }
            if(rbResposta1.isChecked()){
                d = d + 1;
            }
            if(rbResposta2.isChecked()){
                d = d + 2;
            }
            if(rbResposta3.isChecked()){
                d = d + 3;
            }
        }

        if(tipoADS == 3){
            Log.i("tipoADS", "3");
            if(rbResposta0.isChecked()){
                s = s + 0;
            }
            if(rbResposta1.isChecked()){
                s = s + 1;
            }
            if(rbResposta2.isChecked()){
                s = s + 2;
            }
            if(rbResposta3.isChecked()){
                s = s + 3;
            }
        }

        Log.i("a", String.valueOf(a));
        Log.i("d", String.valueOf(d));
        Log.i("s", String.valueOf(s));

        onRestart();

    }*/

        @Override
        protected void onRestart () {
            super.onRestart();
            //if(contador <= 0){
            //   contador = 1;
            // }else {
            carregarPergunta();
        }
    }


