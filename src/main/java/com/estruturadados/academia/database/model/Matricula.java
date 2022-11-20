package com.estruturadados.academia.database.model;

import java.util.Date;

public class Matricula {

    private int codigoMatricula;
    private Aluno aluno;
    private Date dataMatricula;
    private int diaVencimento;
    private Date dataEncerramento;

    public Matricula() {

    }

    public Matricula(int codigoMatricula, Aluno aluno, Date dataMatricula, int diaVencimento, Date dataEncerramento) {
        this.codigoMatricula = codigoMatricula;
        this.aluno = aluno;
        this.dataMatricula = dataMatricula;
        this.diaVencimento = diaVencimento;
        this.dataEncerramento = dataEncerramento;
    }

    public int getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(int codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigoMatricula=" + codigoMatricula + ", aluno=" + aluno + ", dataMatricula=" + dataMatricula + ", diaVencimento=" + diaVencimento + ", dataEncerramento=" + dataEncerramento + '}';
    }

}
