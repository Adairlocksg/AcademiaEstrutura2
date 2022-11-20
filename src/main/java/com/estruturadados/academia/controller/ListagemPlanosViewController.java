/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.PlanoDAO;
import com.estruturadados.academia.database.model.Plano;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ListagemPlanosViewController {

    private Connection connection;

    public ListagemPlanosViewController(Connection connection) {
        this.connection = connection;
    }

    public void listarPlanos(DefaultTableModel modeloTabela) {
        try {
            PlanoDAO planoDAO = new PlanoDAO(connection);
            List<Plano> listaPlanos = planoDAO.Select();

            if (listaPlanos != null) {
                modeloTabela.setRowCount(0);

                for (Plano p : listaPlanos) {
                    Object[] dados = {p.getModalidade().getModalidade(), p.getPlano(), p.getValorMensal()};
                    modeloTabela.addRow(dados);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean deletarPlano(Plano plano) {
        long qtdRowsAffected = 0;
        try {
            PlanoDAO planoDAO = new PlanoDAO(connection);

            qtdRowsAffected = planoDAO.Delete(plano);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAffected > 0;
    }

}
