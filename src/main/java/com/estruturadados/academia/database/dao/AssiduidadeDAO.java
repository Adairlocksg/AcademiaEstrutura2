package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Assiduidade;
import com.estruturadados.academia.database.model.Usuario;

// Só vai select, insert e delete
public class AssiduidadeDAO extends SistemaDAO{

    private Connection conexao;
    private String select = "select * from public.assiduidade";
    private String insert = "insert into public.assiduidade (codigo_matricula, data_entrada) values (?, ?);";
    private String delete = "delete from public.assiduidade where codigo_matricula = ?;";
    
    private PreparedStatement pstSelect;
	private PreparedStatement pstInsert;
	private PreparedStatement pstDelete;

    public AssiduidadeDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstDelete = this.conexao.prepareStatement(delete);
    }
    
    @Override
    public long Delete(Object param) {
        Assiduidade a = (Assiduidade) param;
        try {
            pstDelete.setInt(1, a.getCodigoMatricula());
            pstDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Assiduidade a = (Assiduidade) param;
        pstInsert.setInt(1, a.getCodigoMatricula());
        pstInsert.setTimestamp(2, new Timestamp(a.getDataEntrada().getTime()));
        
        pstInsert.execute();

        return pstInsert.getUpdateCount();
    }

    @Override
    public List<Object> Select() throws SQLException {
        ResultSet resultado = pstSelect.executeQuery();
        List<Object> arlAssiduidade = new ArrayList<Object>();

        while (resultado.next()) {
            Assiduidade a = new Assiduidade();
            a.setCodigoMatricula(resultado.getInt("codigo_matricula"));
            a.setDataEntrada(resultado.getTimestamp("data_entrada"));
            arlAssiduidade.add(a);
        }
        return arlAssiduidade;
    }

    @Override
    public Usuario SelectWithCondition(Object param) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long Update(Object param, Object param2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

