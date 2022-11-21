/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.database.model;

import java.util.Date;

/**
 *
 * @author guilhermefrag
 */
public class AlunoGeral {
    private int codigoAluno;
    private String aluno;
    private String modalidade;
    private String graduacao;
    private String plano;
    private Date dataInicio;
    private Date dataFim;

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public String getAluno() {
        return aluno;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public String getPlano() {
        return plano;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    
}
