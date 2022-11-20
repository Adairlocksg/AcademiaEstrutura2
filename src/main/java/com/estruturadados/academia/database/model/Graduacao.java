package com.estruturadados.academia.database.model;

public class Graduacao {

    private Modalidade modalidade;
    private String graduacao;

    public Graduacao() {
    }

    public Graduacao(Modalidade modalidade, String graduacao) {
        this.modalidade = modalidade;
        this.graduacao = graduacao;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    @Override
    public String toString() {
        return "Graduacao{" + "modalidade=" + modalidade + ", graduacao=" + graduacao + '}';
    }

}
