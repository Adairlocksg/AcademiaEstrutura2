/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.UsuarioDAO;
import com.estruturadados.academia.database.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class CadastrarUsuarioViewController {

    private Connection connection;

    public CadastrarUsuarioViewController(Connection connection) {
        this.connection = connection;
    }

    public boolean atualizarUsuario(Usuario usuarioAntigo, Usuario usuarioNovo) {
        long qtdRowsAffected = 0;

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

            return usuarioDAO.Update(usuarioAntigo, usuarioNovo) > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean inserirUsuario(Usuario usuario) {
        long qtdRowsAffected = 0;

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            qtdRowsAffected = usuarioDAO.Insert(usuario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return qtdRowsAffected > 0;
    }

    public boolean verificarUsuarioExiste(String chavePrimariaUsuario) {
        Usuario usuario = null;

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            usuario = usuarioDAO.SelectWithCondition(chavePrimariaUsuario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuario != null;
    }
}
