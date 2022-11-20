/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.ModalidadeDAO;
import com.estruturadados.academia.database.dao.PlanoDAO;
import com.estruturadados.academia.database.model.Modalidade;
import com.estruturadados.academia.database.model.Plano;
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
public class CadastrarPlanoViewController {

    private Connection connection;

    public CadastrarPlanoViewController(Connection connection) {
        this.connection = connection;
    }

    public boolean inserirPlano(Plano plano) {
        int qtdRrowsAffected = 0;

        PlanoDAO planoDAO;
        try {
            planoDAO = new PlanoDAO(connection);
            qtdRrowsAffected = planoDAO.Insert(plano);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRrowsAffected > 0;
    }

    public boolean atualizarPlano(Plano planoAntigo, Plano planoNovo) {
        long qtdRrowsAffected = 0;

        try {
            PlanoDAO planoDAO = new PlanoDAO(connection);
            qtdRrowsAffected = planoDAO.Update(planoAntigo, planoNovo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRrowsAffected > 0;
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
}
