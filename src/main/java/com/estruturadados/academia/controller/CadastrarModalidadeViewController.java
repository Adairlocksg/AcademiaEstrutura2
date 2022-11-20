/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.ModalidadeDAO;
import com.estruturadados.academia.database.model.Modalidade;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class CadastrarModalidadeViewController {

    private Connection connection;

    public CadastrarModalidadeViewController(Connection connection) {
        this.connection = connection;
    }

    public boolean inserirModalidade(Modalidade modalidade) {
        int qtdRowsAffected = 0;

        try {
            ModalidadeDAO modalidadeDAO = new ModalidadeDAO(connection);
            qtdRowsAffected = modalidadeDAO.Insert(modalidade);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAffected > 0;
    }

    public boolean atualizarModalidade(Modalidade modalidadeAntiga, Modalidade modalidadeNova) {
        long qtdRowsAffected = 0;

        try {
            ModalidadeDAO modalidadeDAO = new ModalidadeDAO(connection);
            qtdRowsAffected = modalidadeDAO.Update(modalidadeAntiga, modalidadeNova);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAffected > 0;
    }
}
