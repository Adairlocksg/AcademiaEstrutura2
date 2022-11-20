package com.estruturadados.academia.database.dao;

import com.estruturadados.academia.database.model.Modalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.estruturadados.academia.database.model.Plano;

public class PlanoDAO extends SistemaDAO {

    private Connection conexao;
    private String select = "select * from public.planos;";
    private String selectWithCondition = "SELECT * FROM public.planos WHERE modalidade = ? ";
    private String insert = "insert into public.planos (modalidade, plano, valor_mensal) values ( ?, ?, ?);";
    private String update = "update public.planos set modalidade = ?, plano = ?, valor_mensal = ? "
            + "WHERE modalidade = ? AND plano = ? ";
    private String delete = "delete from public.planos where modalidade = ? and plano = ? ";

    private PreparedStatement pstSelect;
    private PreparedStatement pstSelectWithCondition;
    private PreparedStatement pstInsert;
    private PreparedStatement pstUpdate;
    private PreparedStatement pstDelete;

    public PlanoDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelectWithCondition = this.conexao.prepareStatement(selectWithCondition);
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstUpdate = this.conexao.prepareStatement(update);
        pstDelete = this.conexao.prepareStatement(delete);
    }

    @Override
    public long Delete(Object param) {
        Plano p = (Plano) param;
        try {
            pstDelete.setString(1, p.getModalidade().getModalidade());
            pstDelete.setString(2, p.getPlano());
            pstDelete.execute();

            return pstDelete.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Plano p = (Plano) param;
        pstInsert.setString(1, p.getModalidade().getModalidade());
        pstInsert.setString(2, p.getPlano());
        pstInsert.setDouble(3, p.getValorMensal());
        pstInsert.execute();

        return pstInsert.getUpdateCount();
    }

    @Override
    public List<Plano> Select() throws SQLException {
        ResultSet resultado = pstSelect.executeQuery();
        List<Plano> lista = new ArrayList<>();

        while (resultado.next()) {
            Plano p = new Plano();
            Modalidade modalidade = new Modalidade(resultado.getString("modalidade"));
            p.setModalidade(modalidade);
            p.setPlano(resultado.getString("plano"));
            p.setValorMensal(resultado.getDouble("valor_mensal"));
            lista.add(p);
        }
        return lista;
    }

    @Override
    public long Update(Object planoAntigo, Object planoNovo) {
        Plano pAntigo = (Plano) planoAntigo;
        Plano pNovo = (Plano) planoNovo;

        try {
            pstUpdate.setString(1, pNovo.getModalidade().getModalidade());
            pstUpdate.setString(2, pNovo.getPlano());
            pstUpdate.setDouble(3, pNovo.getValorMensal());
            pstUpdate.setString(4, pAntigo.getModalidade().getModalidade());
            pstUpdate.setString(5, pAntigo.getPlano());

            pstUpdate.execute();

            return pstUpdate.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Boolean SelectWithCondition(Object modalidadeBuscar) throws SQLException {
        Modalidade modalidade = (Modalidade) modalidadeBuscar;

        pstSelectWithCondition.setString(1, modalidade.getModalidade());
        ResultSet rs = pstSelectWithCondition.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

}
