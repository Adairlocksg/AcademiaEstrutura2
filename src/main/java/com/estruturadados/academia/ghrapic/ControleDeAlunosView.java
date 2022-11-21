/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.estruturadados.academia.ghrapic;

import com.estruturadados.academia.controller.ControleDeAlunosViewController;
import com.estruturadados.academia.database.model.Usuario;
import java.sql.Connection;
import com.estruturadados.academia.database.ConnectionFactory;
import com.estruturadados.academia.database.dao.AlunoDAO;
import com.estruturadados.academia.database.dao.MatriculaModalidadeDAO;
import com.estruturadados.academia.database.model.Usuario;
import com.estruturadados.academia.database.model.Aluno;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilhermefrag
 */
public class ControleDeAlunosView extends javax.swing.JFrame {

    private Connection connection;
    private Usuario usuario;
    private ControleDeAlunosViewController controller;
    /**
     * Creates new form ControleDeAlunosView
     */
    public ControleDeAlunosView() {
        initComponents();
        this.conectarBanco();
        controller = new ControleDeAlunosViewController(connection);
        jCodigoNomeAluno.setEnabled(false);
        usuario = new Usuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        FotoUsuario = new javax.swing.JPanel();
        txtCodigoAluno = new javax.swing.JTextField();
        jTableModalidade = new javax.swing.JScrollPane();
        jTableModalidadeColumns = new javax.swing.JTable();
        jCodigoNomeAluno = new javax.swing.JTextField();
        jSituacao = new javax.swing.JTextField();
        jButtonAcessarDadosAluno = new javax.swing.JButton();
        jButtonAcessarDadosMatricula = new javax.swing.JButton();
        jTableFaturas = new javax.swing.JScrollPane();
        jTableFaturasColumns = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FotoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout FotoUsuarioLayout = new javax.swing.GroupLayout(FotoUsuario);
        FotoUsuario.setLayout(FotoUsuarioLayout);
        FotoUsuarioLayout.setHorizontalGroup(
            FotoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        FotoUsuarioLayout.setVerticalGroup(
            FotoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        txtCodigoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoAlunoActionPerformed(evt);
            }
        });
        txtCodigoAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoAlunoKeyPressed(evt);
            }
        });

        jTableModalidadeColumns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Modalidade", "Graduação", "Plano", "Data Inicio", "Data Fim"
            }
        ));
        jTableModalidade.setViewportView(jTableModalidadeColumns);
        if (jTableModalidadeColumns.getColumnModel().getColumnCount() > 0) {
            jTableModalidadeColumns.getColumnModel().getColumn(4).setHeaderValue("Data Fim");
        }

        jSituacao.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jSituacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jSituacao.setText("Situação Regular");
        jSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSituacaoActionPerformed(evt);
            }
        });

        jButtonAcessarDadosAluno.setText("Acessar dados do Aluno");

        jButtonAcessarDadosMatricula.setText("Acessar dados da Matricula");

        jTableFaturasColumns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vencimento", "Valor", "Pagamento", "Cancelamento"
            }
        ));
        jTableFaturas.setViewportView(jTableFaturasColumns);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FotoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTableFaturas, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jCodigoNomeAluno))
                        .addComponent(jTableModalidade)
                        .addComponent(jSituacao)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonAcessarDadosAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonAcessarDadosMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCodigoNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTableModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAcessarDadosAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAcessarDadosMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTableFaturas, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoAlunoActionPerformed

    private void txtCodigoAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoAlunoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                
                AlunoDAO alunoDAO = new AlunoDAO(connection);
                Aluno aluno = alunoDAO.SelectWithCondition(txtCodigoAluno.getText());
                
                jCodigoNomeAluno.setText(aluno.getCodigoAluno() + " - " + aluno.getAluno());
                controller.listarModalidadesMatriculas((DefaultTableModel) jTableModalidadeColumns.getModel(),aluno.getCodigoAluno());
                controller.listarFaturas((DefaultTableModel) jTableFaturasColumns.getModel(),aluno.getCodigoAluno());
            } catch (SQLException ex) {
                Logger.getLogger(ControleDeAlunosView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCodigoAlunoKeyPressed

    
    private void jSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSituacaoActionPerformed
    
    public void conectarBanco() {
        try {
            connection = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControleDeAlunosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleDeAlunosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleDeAlunosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleDeAlunosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ControleDeAlunosView().setVisible(true);
        });
    }
    
    public void preencherUsuario(Usuario usuario, Connection connection) {
        this.connection = connection;
        this.usuario.setUsuario(usuario.getUsuario());
        this.usuario.setPerfil(usuario.getPerfil());
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FotoUsuario;
    private javax.swing.JButton jButtonAcessarDadosAluno;
    private javax.swing.JButton jButtonAcessarDadosMatricula;
    private javax.swing.JTextField jCodigoNomeAluno;
    private javax.swing.JTextField jSituacao;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JScrollPane jTableFaturas;
    private javax.swing.JTable jTableFaturasColumns;
    private javax.swing.JScrollPane jTableModalidade;
    private javax.swing.JTable jTableModalidadeColumns;
    private javax.swing.JTextField txtCodigoAluno;
    // End of variables declaration//GEN-END:variables

}