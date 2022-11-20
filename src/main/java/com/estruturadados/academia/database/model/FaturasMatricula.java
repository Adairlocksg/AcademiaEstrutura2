package com.estruturadados.academia.database.model;

import java.util.Date;

public class FaturasMatricula {
    
    private int codigoMatricula;
    private Date dataVencimento;
    private double valor;
    private Date dataPagamento;
    private Date dataCancelamento;

    public FaturasMatricula(){
        
    }

    public FaturasMatricula(int codigoMatricula, Date dataVencimento, double valor, Date dataPagamento, Date dataCancelamento) {
        this.codigoMatricula = codigoMatricula;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataCancelamento = dataCancelamento;
    }

    public int getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(int codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    @Override
    public String toString() {
        return "codigoMatricula=" + codigoMatricula + ", dataVencimento=" + dataVencimento + ", valor=" + valor + ", dataPagamento=" + dataPagamento + ", dataCancelamento=" + dataCancelamento + "";
    }

}
