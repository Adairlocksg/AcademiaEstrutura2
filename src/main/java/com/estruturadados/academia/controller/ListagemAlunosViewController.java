/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.dao.MatriculaDAO;
import com.estruturadados.academia.database.model.Aluno;
import com.estruturadados.academia.database.model.AlunoGeral;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ListagemAlunosViewController {

    private Connection connection;

    public ListagemAlunosViewController(Connection connection) {
        this.connection = connection;
    }

    public List<Aluno> buscarAlunos() {
        List<Aluno> listaAlunos = null;
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            listaAlunos = alunoDAO.Select();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaAlunos;
    }

    public Aluno buscarAlunoByAluno(int codigoUsuario) {
        Aluno aluno = null;
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            aluno = alunoDAO.SelectWithCondition(codigoUsuario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aluno;
    }

    public boolean deletarAluno(int codigoAluno) {
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);

            return alunoDAO.Delete(codigoAluno) > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean verificarVinculoAlunoMatricula(Aluno aluno){
        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(connection);
            return matriculaDAO.SelectWithCondition(aluno);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public void listarAlunos(DefaultTableModel modeloTabela, int cod_aluno) {
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            List<AlunoGeral> listarAlunos = alunoDAO.SelectByCodAluno(cod_aluno);

            if (listarAlunos != null) {
                modeloTabela.setRowCount(0);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                for (AlunoGeral ag : listarAlunos) {
                    if (ag.getDataFim() == null){
                        Object[] dados = {ag.getCodigoAluno(), ag.getAluno(), ag.getModalidade(), ag.getGraduacao(), ag.getPlano(), sdf.format(ag.getDataInicio())};
                        modeloTabela.addRow(dados);
                    }else{
                    Object[] dados = {ag.getCodigoAluno(), ag.getAluno(), ag.getModalidade(), ag.getGraduacao(), ag.getPlano(), sdf.format(ag.getDataInicio()), sdf.format(ag.getDataFim())};
                    modeloTabela.addRow(dados);
                    }
                 }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
