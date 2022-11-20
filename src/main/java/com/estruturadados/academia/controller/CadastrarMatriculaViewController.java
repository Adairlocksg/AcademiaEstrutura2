/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.dao.MatriculaDAO;
import com.estruturadados.academia.database.model.Aluno;
import com.estruturadados.academia.database.model.Matricula;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class CadastrarMatriculaViewController {

    private Connection connection;

    public CadastrarMatriculaViewController(Connection connection) {
        this.connection = connection;
    }

    public void carregarAlunos(JComboBox<Object> jCombobox) {
        List<Aluno> listaAlunos = null;
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            listaAlunos = alunoDAO.Select();

            if (listaAlunos != null) {
                for (Aluno a : listaAlunos) {
                    jCombobox.addItem(a);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean cadastrarMatricula(Matricula matricula) {
        int qtdRowsAfected = 0;

        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(connection);
            qtdRowsAfected = matriculaDAO.Insert(matricula);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAfected > 0;
    }

    public boolean atualizarMatricula(Matricula matriculaAntiga, Matricula matriculaNova) {
        long qtdRowsAffected = 0;

        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(connection);
            qtdRowsAffected = matriculaDAO.Update(matriculaAntiga, matriculaNova);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAffected > 0;
    }    
}
