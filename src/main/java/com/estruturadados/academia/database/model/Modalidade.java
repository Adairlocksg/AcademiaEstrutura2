package com.estruturadados.academia.database.model;

public class Modalidade {

    private String modalidade;

    public Modalidade() {

    }

    public Modalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return modalidade;
    }
}
