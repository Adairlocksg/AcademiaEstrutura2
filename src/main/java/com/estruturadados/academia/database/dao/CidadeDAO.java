package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Cidade;
import com.estruturadados.academia.database.model.Usuario;

// Só vai select e delete
public class CidadeDAO extends SistemaDAO {

    private Connection conexao;
	private String select = "select * from public.cidades;";
    private String delete = "delete from public.cidades where codigo_cidade = ?;";

    private PreparedStatement pstSelect;
	private PreparedStatement pstDelete;

    public CidadeDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstDelete = this.conexao.prepareStatement(delete);
    }

    @Override
	public List<Cidade> Select() throws SQLException {
        
        ResultSet resultado = pstSelect.executeQuery();		
        List<Cidade> arlCidade = new ArrayList<Cidade>();
        
        while (resultado.next()) {
            
            Cidade c = new Cidade();
            c.setCidade(resultado.getString("cidade"));
            c.setEstado(resultado.getString("estado"));
            c.setPais(resultado.getString("pais"));
            arlCidade.add(c);
        }
        
        return arlCidade;
    }    

    @Override
    public int Insert(Object param) throws SQLException{
        return 0;
    }

    @Override
	public long Delete(Object param){
        Cidade c = (Cidade)param;
        try {
            pstDelete.setString(1, c.getCidade());
            pstDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Usuario SelectWithCondition(Object usuarioBuscar) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long Update(Object param, Object param2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
