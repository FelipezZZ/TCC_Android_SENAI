package com.example.dass21;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {

    private int tipoADS;
    private String pergunta;


    public Pergunta(int tipoADS, String pergunta){
        this.tipoADS = tipoADS;
        this.pergunta = pergunta;
    }

    public int getTipoADS(){
        return this.tipoADS;
    }

    public String getPergunta(){
        return this.pergunta;
    }
}
