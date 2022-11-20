package com.estruturadados.academia.database.model;

import java.util.Date;

public class Assiduidade {
    private int codigoMatricula;
    private Date dataEntrada;

    public Assiduidade(){
        
    }

    public Assiduidade(int codigoMatricula, Date dataEntrada) {
        this.codigoMatricula = codigoMatricula;
        this.dataEntrada = dataEntrada;
    }

    public int getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(int codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public String toString() {
        return "codigoMatricula=" + codigoMatricula + ", dataEntrada=" + dataEntrada + "";
    }

}
