/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.database.dao;

import com.estruturadados.academia.database.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lab202a
 */
public class UsuarioDAO extends SistemaDAO {

    private final Connection connection;
    private final String select = "SELECT * FROM public.usuarios";
    private final String selectComClasula = "SELECT * FROM public.usuarios WHERE USUARIO = ?";
    private final String selectLogin = "SELECT * FROM public.usuarios WHERE usuario = ? AND senha = ?";
    private final String insert = "INSERT INTO public.usuarios (usuario, senha, perfil) VALUES (?, ?, ?)";
    private final String delete = "DELETE FROM public.usuarios WHERE usuario = ?";
    private final String update = "UPDATE public.usuarios SET usuario = ?, senha = ?, perfil = ? WHERE usuario = ?";

    private PreparedStatement psSelect;
    private PreparedStatement psSelectClasula;
    private PreparedStatement psSelectLogin;
    private PreparedStatement psInsert;
    private PreparedStatement psDelete;
    private PreparedStatement psUpdate;

    public UsuarioDAO(Connection connection) throws SQLException {
        this.connection = connection;
        psSelect = this.connection.prepareStatement(select);
        psSelectClasula = this.connection.prepareStatement(selectComClasula);
        psSelectLogin = this.connection.prepareStatement(selectLogin);
        psInsert = this.connection.prepareStatement(insert);
        psDelete = this.connection.prepareStatement(delete);
        psUpdate = this.connection.prepareStatement(update);
    }

    public boolean selectLogin(Usuario usuario) throws SQLException {
        psSelectLogin.setString(1, usuario.getUsuario());
        psSelectLogin.setString(2, usuario.getSenha());
        ResultSet rs = psSelectLogin.executeQuery();

        if (rs.next()) {
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setPerfil(rs.getString("perfil"));
            return true;
        }else{
            usuario.setUsuario(null);
            usuario.setSenha(null);
        }                
        
        return false;
    }

    @Override
    public List<Usuario> Select() throws SQLException {
        ResultSet rs = psSelect.executeQuery();
        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setUsuario(rs.getString("usuario"));
            u.setSenha(rs.getString("senha"));
            u.setPerfil(rs.getString("perfil"));

            usuarios.add(u);
        }
        return usuarios;
    }

    @Override
    public Usuario SelectWithCondition(Object usuarioBuscar) throws SQLException {
        psSelectClasula.setString(1, usuarioBuscar.toString());

        ResultSet rs = psSelectClasula.executeQuery();
        Usuario usuario = null;

        while (rs.next()) {
            usuario = new Usuario();
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setPerfil(rs.getString("perfil"));

        }
        return usuario;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Usuario usuario = (Usuario) param;

        psInsert.setString(1, usuario.getUsuario());
        psInsert.setString(2, usuario.getSenha());
        psInsert.setString(3, usuario.getPerfil());

        psInsert.execute();

        return psInsert.getUpdateCount(); //retorna o numero de linhas afetadas
    }

    @Override
    public long Delete(Object param) {
        try {
            String usuario = (String) param;

            psDelete.setString(1, usuario);

            psDelete.execute();

            return psDelete.getUpdateCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public long Update(Object usuarioAntigo, Object usuarioNovo) {
        try {
            Usuario uAntigo = (Usuario) usuarioAntigo;
            Usuario uNovo = (Usuario) usuarioNovo;

            psUpdate.setString(1, uNovo.getUsuario());
            psUpdate.setString(2, uNovo.getSenha());
            psUpdate.setString(3, uNovo.getPerfil());
            psUpdate.setString(4, uAntigo.getUsuario());

            psUpdate.execute();

            return psUpdate.getUpdateCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
