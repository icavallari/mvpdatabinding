package com.example.mvpdatabinding;

public class MainModel {

    private String nome;
    private String sobrenome;

    public MainModel(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

}
