/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.UsuarioDAO;
import com.estruturadados.academia.database.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ListagemUsuariosViewController {

    private Connection connection;

    public ListagemUsuariosViewController(Connection connection) {
        this.connection = connection;
    }

    public void listarUsuarios(DefaultTableModel modeloTabela) {        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            List<Usuario> listaUsuarios = usuarioDAO.Select();

            if (listaUsuarios != null) {
                modeloTabela.setRowCount(0);

                for (Usuario u : listaUsuarios) {
                    Object[] dados = {u.getUsuario(), u.getPerfil()};
                    modeloTabela.addRow(dados);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Usuario buscarUsuarioByUsuario(String usuario) {
        Usuario u = null;
        
        try {
            u = new Usuario();            
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            u = usuarioDAO.SelectWithCondition(usuario);            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }
    
    public boolean deletarUsuario(String chavePrimaria){
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            
            return usuarioDAO.Delete(chavePrimaria) > 0;            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
