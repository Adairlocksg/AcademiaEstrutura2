package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Assiduidade;
import com.estruturadados.academia.database.model.FaturasMatricula;
import com.estruturadados.academia.database.model.Assiduidade;

// Só vai select, insert e delete
public class AssiduidadeDAO extends SistemaDAO{

    private Connection conexao;
    private String select = "select * from public.assiduidade";
    private String insert = "insert into public.assiduidade (codigo_matricula, data_entrada) values (?, ?);";
    private String delete = "delete from public.assiduidade where codigo_matricula = ?;";
    private String selectByCodAluno = "select data_entrada\n" +
                                        "from assiduidade a \n" +
                                        "where codigo_matricula = (select codigo_matricula from matriculas m where codigo_aluno = ?)";
    
    private PreparedStatement pstSelect;
    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;
    private PreparedStatement pstSelectByCodAluno;
    
    public AssiduidadeDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstDelete = this.conexao.prepareStatement(delete);
        pstSelectByCodAluno = this.conexao.prepareStatement(selectByCodAluno);    
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
    
    public List<Assiduidade> SelectByCodAluno(int cod_aluno) throws SQLException {
        pstSelectByCodAluno.setInt(1, cod_aluno);
        ResultSet resultado = pstSelectByCodAluno.executeQuery();
        List<Assiduidade> lista = new ArrayList<Assiduidade>();

        while(resultado.next()){
            Assiduidade a = new Assiduidade();
            
            a.setDataEntrada(resultado.getDate("data_entrada"));
            lista.add(a);
        }

        return lista;
    
    }

    @Override
    public long Update(Object param, Object param2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object SelectWithCondition(Object param) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}

