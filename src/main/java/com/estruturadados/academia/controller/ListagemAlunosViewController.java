/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.dao.MatriculaDAO;
import com.estruturadados.academia.database.model.Aluno;
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

    public void listarAlunos(DefaultTableModel modeloTabela) {
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            List<Aluno> listaAlunos = alunoDAO.Select();

            if (listaAlunos != null) {
                modeloTabela.setRowCount(0);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                for (Aluno a : listaAlunos) {
                    Object[] dados = {a.getCodigoAluno(), a.getAluno(), sdf.format(a.getDataNascimento()), a.getCidade().getCidade()};
                    modeloTabela.addRow(dados);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
}
