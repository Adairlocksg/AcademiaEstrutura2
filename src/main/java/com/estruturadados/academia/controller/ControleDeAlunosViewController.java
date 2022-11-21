/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.model.Aluno;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.dao.MatriculaDAO;
import com.estruturadados.academia.database.dao.MatriculaModalidadeDAO;
import com.estruturadados.academia.database.model.MatriculasModalidades;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilhermefrag
 */
public class ControleDeAlunosViewController {
    private Connection connection;

    public ControleDeAlunosViewController(Connection connection) {
        this.connection = connection;
    }
    
    public void listarModalidadesMatriculas(DefaultTableModel modeloTabela, int cod_aluno) {
        try {
            MatriculaModalidadeDAO matriculaModalidadeDAO = new MatriculaModalidadeDAO(connection);
            List<MatriculasModalidades> listaMatriculaModalidades = matriculaModalidadeDAO.SelectByCodAluno(cod_aluno);

            if (listaMatriculaModalidades != null) {
                modeloTabela.setRowCount(0);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                for (MatriculasModalidades mm : listaMatriculaModalidades) {
                    if (mm.getDataFim() == null){
                        Object[] dados = {mm.getModalidade(), mm.getGraduacao(), mm.getPlano(), sdf.format(mm.getDataInicio())};
                        modeloTabela.addRow(dados);
                    }else{
                    Object[] dados = {mm.getModalidade(), mm.getGraduacao(), mm.getPlano(), sdf.format(mm.getDataInicio()), sdf.format(mm.getDataFim())};
                    modeloTabela.addRow(dados);
                    }
                 }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
