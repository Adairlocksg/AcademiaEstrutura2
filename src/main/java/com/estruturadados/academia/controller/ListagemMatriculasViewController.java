package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.MatriculaDAO;
import com.estruturadados.academia.database.model.Matricula;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class ListagemMatriculasViewController {

    private Connection connection;

    public ListagemMatriculasViewController(Connection connection) {
        this.connection = connection;
    }

    public void listarMatriculas(DefaultTableModel modeloTabela) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            MatriculaDAO matriculaDAO = new MatriculaDAO(connection);
            List<Matricula> listaMatriculas = matriculaDAO.Select();

            if (listaMatriculas != null) {
                modeloTabela.setRowCount(0);

                for (Matricula m : listaMatriculas) {
                    Object[] dados = {m.getCodigoMatricula(), m.getAluno().getCodigoAluno(), m.getAluno().getAluno(), sdf.format(m.getDataMatricula()),
                        m.getDiaVencimento(), m.getDataEncerramento()};
                    modeloTabela.addRow(dados);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean deletarMatriuclar(int codigoMatricula) {
        long qtdRowsAffected = 0;

        try {
            MatriculaDAO matriculaDAO = new MatriculaDAO(connection);
            qtdRowsAffected = matriculaDAO.Delete(codigoMatricula);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAffected > 0;
    }
}
