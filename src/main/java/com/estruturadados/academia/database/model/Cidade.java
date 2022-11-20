package com.estruturadados.academia.database.model;

public class Cidade {
    private String cidade;
    private String estado;
    private String pais;

    public Cidade() {

    }

    public Cidade(String cidade, String estado, String pais) {
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + "";
    }
}
