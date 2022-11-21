package com.estruturadados.academia.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.MatriculasModalidades;
import com.estruturadados.academia.database.model.Usuario;

public class MatriculaModalidadeDAO extends SistemaDAO{
    
    private Connection conexao;
    private String select = "select * from public.matriculas_modalidades;";
    private String insert = "insert into public.matriculas_modalidades (codigo_matricula, modalidade, graduacao, plano, data_inicio, data_fim) values ( ?, ?, ?, ?, ?, ?);";
    private String update = "update public.matriculas_modalidades set data_fim = ? where codigo_matricula = ? and modalidade = ?;";
    private String delete = "delete from public.matriculas_modalidades where codigo_matricula = ? ;";
    private String selectByCodAluno = "select modalidade,graduacao,plano,data_inicio,data_fim \n" +
                                        "from matriculas_modalidades mm \n" +
                                        "where codigo_matricula = (select codigo_matricula from matriculas m where codigo_aluno = ?)";
    
    private PreparedStatement pstSelect;
    private PreparedStatement pstInsert;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstDelete;
    private PreparedStatement pstSelectByCodAluno;
        
    public MatriculaModalidadeDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
        pstDelete = this.conexao.prepareStatement(delete);
        pstSelectByCodAluno = this.conexao.prepareStatement(selectByCodAluno);
    }
    @Override
    public long Delete(Object param) {
        MatriculasModalidades mm = (MatriculasModalidades) param;
        try{
            pstDelete.setInt(1, mm.getCodigoMatricula());
            pstDelete.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public List<MatriculasModalidades> SelectByCodAluno(int cod_aluno) throws SQLException {
        pstSelectByCodAluno.setInt(1, cod_aluno);
        ResultSet resultado = pstSelectByCodAluno.executeQuery();
        List<MatriculasModalidades> lista = new ArrayList<MatriculasModalidades>();

        while(resultado.next()){
            MatriculasModalidades mm = new MatriculasModalidades();
            mm.setModalidade(resultado.getString("modalidade"));
            mm.setGraduacao(resultado.getString("graduacao"));
            mm.setPlano(resultado.getString("plano"));
            mm.setDataInicio(resultado.getDate("data_inicio"));
            mm.setDataFim(resultado.getDate("data_fim"));
            lista.add(mm);
        }

        return lista;
    
    }

    @Override
    public int Insert(Object param) throws SQLException {
        MatriculasModalidades mm = (MatriculasModalidades) param;
        pstInsert.setInt(1, mm.getCodigoMatricula());
        pstInsert.setString(2, mm.getModalidade());
        pstInsert.setString(3, mm.getGraduacao());
        pstInsert.setString(4, mm.getPlano());
        pstInsert.setTimestamp(5, new Timestamp(mm.getDataInicio().getTime()));
        pstInsert.setTimestamp(6, new Timestamp(mm.getDataFim().getTime()));
        pstInsert.execute();
        
        return 0;
    }

    @Override
    public List<Object> Select() throws SQLException {

        ResultSet resultado = pstSelect.executeQuery();
        List<Object> lista = new ArrayList<Object>();

        while(resultado.next()){
            MatriculasModalidades mm = new MatriculasModalidades();
            mm.setCodigoMatricula(resultado.getInt("codigo_matricula"));
            mm.setModalidade(resultado.getString("modalidade"));
            mm.setGraduacao(resultado.getString("graduacao"));
            mm.setPlano(resultado.getString("plano"));
            mm.setDataInicio(resultado.getDate("data_inicio"));
            mm.setDataFim(resultado.getDate("data_fim"));
            lista.add(mm);
        }

        return lista;
    }

    @Override
    public long Update(Object param, Object param2) {
        MatriculasModalidades mm = (MatriculasModalidades) param;
        try{
            pstUpdate.setTimestamp(6, new Timestamp(mm.getDataFim().getTime()));
            pstUpdate.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Usuario SelectWithCondition(Object usuarioBuscar) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
