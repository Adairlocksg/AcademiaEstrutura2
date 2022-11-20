/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.academia.controller;

import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.dao.CidadeDAO;
import com.estruturadados.academia.database.model.Aluno;
import com.estruturadados.academia.database.model.Cidade;
import com.estruturadados.academia.database.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class CadastrarAlunoViewController {
    private Connection connection;
    
    public CadastrarAlunoViewController(Connection connection) {
        this.connection = connection;
    }    
    
    public List<Cidade> preencherComboCidades(JComboBox combobox){
        List<Cidade> listaCidades = new ArrayList<Cidade>();
        try {
            CidadeDAO cidadeDAO = new CidadeDAO(connection);
            listaCidades = cidadeDAO.Select();
            
            for(Cidade c : listaCidades){
                combobox.addItem(c.getCidade());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCidades;
    }
    
    public boolean cadastrarAluno(Aluno aluno){
        long qtdRowsAffected = 0;
        
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            
            qtdRowsAffected = alunoDAO.Insert(aluno);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return qtdRowsAffected > 0;
    }
    
    public boolean editarAluno(Aluno aluno){
        try {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            
            return alunoDAO.Update(aluno, null) > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
