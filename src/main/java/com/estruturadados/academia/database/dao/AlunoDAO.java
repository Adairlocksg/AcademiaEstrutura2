package com.estruturadados.academia.database.dao;

import com.estruturadados.academia.database.model.Aluno;
import com.estruturadados.academia.database.model.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends SistemaDAO {

    private Connection conexao;
    private String select = "select * from public.alunos order by codigo_aluno asc";
    private String selectComClasula = "SELECT * FROM ALUNOS WHERE codigo_aluno = ?";
    private String insert = "INSERT INTO public.alunos "
            + "(aluno,data_nascimento,sexo,telefone,celular,email,observacao,endereco,numero,complemento,bairro,cidade, estado, pais, cep) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private String update = "UPDATE public.alunos "
            + "SET aluno=?, data_nascimento=?, sexo=?, telefone=?, celular=?, email=?, observacao=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, pais=?, cep=? "
            + "WHERE codigo_aluno=?;";
    private String delete = "DELETE FROM public.alunos WHERE codigo_aluno=?;";

    private PreparedStatement pstSelect;
    private PreparedStatement pstSelectComClasula;
    private PreparedStatement pstInsert;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstDelete;

    public AlunoDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstSelectComClasula = this.conexao.prepareStatement(selectComClasula);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
        pstDelete = this.conexao.prepareStatement(delete);
    }

    @Override
    public List<Aluno> Select() throws SQLException {
        ResultSet resultado = pstSelect.executeQuery();
        List<Aluno> arlPessoa = new ArrayList<>();

        while (resultado.next()) {
            Aluno p = new Aluno();
            p.setCodigoAluno(resultado.getInt("codigo_aluno"));
            p.setAluno(resultado.getString("aluno"));
            p.setDataNascimento(resultado.getDate("data_nascimento"));
            p.setSexo(resultado.getString("sexo").charAt(0));
            p.setTelefone(resultado.getString("telefone"));
            p.setCelular(resultado.getString("celular"));
            p.setEmail(resultado.getString("email"));
            p.setObservacao(resultado.getString("observacao"));
            p.setEndereco(resultado.getString("endereco"));
            p.setNumero(resultado.getString("numero"));
            p.setComplemento(resultado.getString("complemento"));
            p.setBairro(resultado.getString("bairro"));

            Cidade cidade = new Cidade();
            cidade.setCidade(resultado.getString("cidade"));
            cidade.setEstado(resultado.getString("estado"));
            cidade.setPais(resultado.getString("pais"));
            p.setCidade(cidade);

            p.setCep(resultado.getString("cep"));

            arlPessoa.add(p);
        }

        return arlPessoa;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Aluno p = (Aluno) param;
        pstInsert.setString(1, p.getAluno());
        pstInsert.setTimestamp(2, new Timestamp(p.getDataNascimento().getTime()));
        pstInsert.setString(3, String.valueOf(p.getSexo()));
        pstInsert.setString(4, p.getTelefone());
        pstInsert.setString(5, p.getCelular());
        pstInsert.setString(6, p.getEmail());
        pstInsert.setString(7, p.getObservacao());
        pstInsert.setString(8, p.getEndereco());
        pstInsert.setString(9, p.getNumero());
        pstInsert.setString(10, p.getComplemento());
        pstInsert.setString(11, p.getBairro());
        pstInsert.setString(12, p.getCidade().getCidade());
        pstInsert.setString(13, p.getCidade().getEstado());
        pstInsert.setString(14, p.getCidade().getPais());
        pstInsert.setString(15, p.getCep());

        pstInsert.execute();

        return pstInsert.getUpdateCount();
    }

    @Override
    public long Delete(Object param) {        
        try {
            pstDelete.setInt(1, Integer.parseInt(param.toString()));
            pstDelete.execute();
            return pstDelete.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long Update(Object param, Object param2) {
        
        Aluno p = (Aluno) param;
        try {
            pstUpdate.setString(1, p.getAluno());
            pstUpdate.setTimestamp(2, new Timestamp(p.getDataNascimento().getTime()));
            pstUpdate.setString(3, String.valueOf(p.getSexo()));
            pstUpdate.setString(4, p.getTelefone());
            pstUpdate.setString(5, p.getCelular());
            pstUpdate.setString(6, p.getEmail());
            pstUpdate.setString(7, p.getObservacao());
            pstUpdate.setString(8, p.getEndereco());
            pstUpdate.setString(9, p.getNumero());
            pstUpdate.setString(10, p.getComplemento());
            pstUpdate.setString(11, p.getBairro());
            pstUpdate.setString(12, p.getCidade().getCidade());
            pstUpdate.setString(13, p.getCidade().getEstado());
            pstUpdate.setString(14, p.getCidade().getPais());
            pstUpdate.setString(15, p.getCep());
            pstUpdate.setInt(16, p.getCodigoAluno());
            pstUpdate.execute();
            return pstUpdate.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Aluno SelectWithCondition(Object param) throws SQLException {
        pstSelectComClasula.setInt(1, Integer.parseInt(param.toString()));
        ResultSet rs = pstSelectComClasula.executeQuery();
        
        Aluno aluno = new Aluno();
        while(rs.next()){
            int cod = rs.getInt("codigo_aluno");
            aluno.setCodigoAluno(cod);
            aluno.setAluno(rs.getString("aluno"));
            aluno.setDataNascimento(rs.getDate("data_nascimento"));
            aluno.setSexo(rs.getString("sexo").charAt(0));
            aluno.setTelefone(rs.getString("telefone"));
            aluno.setCelular(rs.getString("celular"));
            aluno.setEmail(rs.getString("email"));
            aluno.setObservacao(rs.getString("observacao"));
            aluno.setEndereco(rs.getString("endereco"));
            aluno.setNumero(rs.getString("numero"));
            aluno.setComplemento(rs.getString("complemento"));
            aluno.setBairro(rs.getString("bairro"));
            
            Cidade cidade = new Cidade();
            cidade.setCidade(rs.getString("cidade"));
            cidade.setEstado(rs.getString("estado"));
            cidade.setPais(rs.getString("pais"));
            aluno.setCidade(cidade);
            
            aluno.setCep(rs.getString("cep"));
        }
        return aluno;
    }
}
