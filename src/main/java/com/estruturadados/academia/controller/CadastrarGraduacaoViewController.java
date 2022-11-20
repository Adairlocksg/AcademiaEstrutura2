/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.GraduacaoDAO;
import com.estruturadados.academia.database.dao.ModalidadeDAO;
import com.estruturadados.academia.database.model.Graduacao;
import com.estruturadados.academia.database.model.Modalidade;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class CadastrarGraduacaoViewController {

    private Connection connection;

    public CadastrarGraduacaoViewController(Connection connection) {
        this.connection = connection;
    }

    public void carregarModalidades(JComboBox<Object> jCombobox) {
        try {
            ModalidadeDAO modalidadeDAO = new ModalidadeDAO(connection);
            List<Modalidade> listaModalidades = modalidadeDAO.Select();

            for (Modalidade m : listaModalidades) {
                jCombobox.addItem(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean inserirGraduacao(Graduacao graduacao) {
        int qtdRowsAffected = 0;

        try {
            GraduacaoDAO graduacaoDAO = new GraduacaoDAO(connection);
            qtdRowsAffected = graduacaoDAO.Insert(graduacao);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAffected > 0;
    }

    public boolean atualizarGraduacao(Graduacao graduacaoAntiga, Graduacao graduacaoNova) {
        long qtdRowsAffected = 0;
        try {
            GraduacaoDAO graduacaoDAO = new GraduacaoDAO(connection);
            qtdRowsAffected = graduacaoDAO.Update(graduacaoAntiga, graduacaoNova);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAffected > 0;
    }
}
