package com.example.anamnese;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Pergunta> perguntas = new ArrayList<Pergunta>(){
        {
            add(new Pergunta(3, "Tive dificuldade de me acalmar", "0", "1", "2", "3"));
            add(new Pergunta(1, "Minha boca ficou seca", "0", "1", "2", "3"));
            add(new Pergunta(2, "Nao tive nenhum sentimento positivo",  "0", "1", "2", "3"));
            add(new Pergunta(1, "Em alguns momentos tive dificuldade de respirar (chiado e falta de ar sem esforço físico)",  "0", "1", "2", "3"));
            add(new Pergunta(2, "Não consegui ter iniciativa para fazer as coisas",  "0", "1", "2", "3"));
            add(new Pergunta(3, "Exagerei intencionalmente ao reagir a situações",  "0", "1", "2", "3"));
            add(new Pergunta(1, "Tive tremedeira (por exemplo, nas mãos)",  "0", "1", "2", "3"));
            add(new Pergunta(3, "Senti que estava sempre nervoso(a)",  "0", "1", "2", "3"));
            add(new Pergunta(1, "Me preocupei com situações em que poderia entrar em pânico e parecer ridículo(a)",  "0", "1", "2", "3"));
            add(new Pergunta(2, "Senti que não tinha vontade de nada",  "0", "1", "2", "3"));
            add(new Pergunta(3, "Me senti inquieto(a)",  "0", "1", "2", "3"));
            add(new Pergunta(3, "Tive dificuldade de relaxar",  "0", "1", "2", "3"));
            add(new Pergunta(2, "Me senti deprimido e sem motivação",  "0", "1", "2", "3"));
            add(new Pergunta(3, "Eu não conseguia tolerar as coisas que me impediam de continuar a fazer o que estava realizando",  "0", "1", "2", "3"));
            add(new Pergunta(1, "Eu senti que ia entrar em pânico",  "0", "1", "2", "3"));
            add(new Pergunta(2, "Nada me deixou entusiasmado",  "0", "1", "2", "3"));
            add(new Pergunta(2, "Eu senti que era uma pessoa sem valor",  "0", "1", "2", "3"));
            add(new Pergunta(3, "Eu senti que estava sendo muito sensível/emotivo",  "0", "1", "2", "3"));
            add(new Pergunta(1, "Eu percebi uma mudança nos meus batimentos cardíacos embora não estivesse praticando exercício rigoroso (ex. batimento cardíaco acelerado ou irregular)",  "0", "1", "2", "3"));
            add(new Pergunta(1, "Eu senti medo sem motivo",  "0", "1", "2", "3"));
            add(new Pergunta(2, "Senti que a vida não tinha sentido",  "0", "1", "2", "3"));
        }
    };

    TextView pergunta;
    RadioButton  rbResposta0 ,rbResposta1, rbResposta2, rbResposta3;
    int a, d, s, tipoADS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pergunta = (TextView)findViewById(R.id.pergunta);
        rbResposta0 = (RadioButton)findViewById(R.id.rbResposta0);
        rbResposta1 = (RadioButton)findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton)findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton)findViewById(R.id.rbResposta3);

        carregarPergunta();
    }

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

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        carregarPergunta();
    }

}
