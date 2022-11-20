package com.estruturadados.academia.database.dao;

import java.util.ArrayList;
import java.util.List;
import com.estruturadados.academia.database.model.Modalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModalidadeDAO extends SistemaDAO {

    private Connection conexao;
    private String select = "select * from modalidades order by modalidade asc";
    private String insert = "insert into modalidades (modalidade) VALUES (?)";
    private String delete = "delete from modalidades where modalidade = ? ;";
    private String update = "UPDATE modalidades SET modalidade = ? WHERE modalidade = ?";

    private PreparedStatement pstSelect;
    private PreparedStatement pstInsert;
    private PreparedStatement pstDelete;
    private PreparedStatement pstUpdate;

    public ModalidadeDAO(Connection conexao) throws SQLException {
        this.conexao = conexao;
        pstSelect = this.conexao.prepareStatement(select);
        pstInsert = this.conexao.prepareStatement(insert);
        pstDelete = this.conexao.prepareStatement(delete);
        pstUpdate = this.conexao.prepareStatement(update);
    }

    @Override
    public long Delete(Object param) {
        Modalidade m = (Modalidade) param;
        try {
            pstDelete.setString(1, m.getModalidade());
            pstDelete.execute();
            
            return pstDelete.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Insert(Object param) throws SQLException {
        Modalidade m = (Modalidade) param;
        pstInsert.setString(1, m.getModalidade());
        pstInsert.executeUpdate();
        return pstInsert.getUpdateCount();
    }

    @Override
    public List<Modalidade> Select() throws SQLException {
        ResultSet resultado = pstSelect.executeQuery();

        List<Modalidade> lista = new ArrayList<>();

        while (resultado.next()) {
            Modalidade m = new Modalidade();
            m.setModalidade(resultado.getString("modalidade"));
            lista.add(m);
        }
        return lista;
    }

    @Override
    public long Update(Object modalidadeAntiga, Object modalidadeNova) {
        Modalidade mAntiga = (Modalidade) modalidadeAntiga;
        Modalidade mNova = (Modalidade) modalidadeNova;

        try {
            pstUpdate.setString(1, mNova.getModalidade());
            pstUpdate.setString(2, mAntiga.getModalidade());
            
            pstUpdate.execute();
            
            return pstUpdate.getUpdateCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Object SelectWithCondition(Object param) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
