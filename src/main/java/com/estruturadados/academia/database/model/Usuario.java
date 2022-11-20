package com.estruturadados.academia.database.model;

public class Usuario {

    private String usuario;
    private String senha;
    private String perfil;

    public Usuario() {

    }

    public Usuario(String usuario, String senha, String perfil) {
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario + " senha: " + senha + " perfil: " + perfil; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
