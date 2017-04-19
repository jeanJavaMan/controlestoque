/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.interfacesV2;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jeanderson.br.interfaces.TelaDetalhe;
import jeanderson.br.interfacesV2.TelaPrincipal;
import jeanderson.br.main.Main;
import jeanderson.br.produtos.Produto;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TelaAdiciona extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaAdiciona
     */
    public TelaAdiciona() {
        initComponents();
        setSize(674, 566);
        setResizable(false);
    }

    private boolean verificarCampos() {
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Campo NOME não preenchido corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtQuantidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Campo QUANTIDADE não preenchido corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Campo VALOR não preenchido corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Campo DESCRIÇÃO não preenchido corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStatus = new javax.swing.JTextArea();
        btnAdicionar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Adicionar Produto");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome do Produto:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 15, 115, 17);
        getContentPane().add(txtNome);
        txtNome.setBounds(129, 11, 416, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantidade:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 49, 75, 17);
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(129, 45, 127, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Valor(R$):");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(63, 88, 62, 17);
        getContentPane().add(txtValor);
        txtValor.setBounds(129, 84, 127, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Descrição");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(290, 143, 74, 22);

        txtStatus.setColumns(20);
        txtStatus.setRows(5);
        jScrollPane1.setViewportView(txtStatus);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(129, 183, 416, 210);

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionar.setText("Adicionar Produto");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar);
        btnAdicionar.setBounds(129, 411, 141, 25);

        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar Tudo");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(436, 411, 109, 25);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jeanderson/br/imagens/2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 660, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (verificarCampos()) {
            return;
        }
        Produto p = new Produto(txtNome.getText(), Integer.parseInt(txtQuantidade.getText().replace(",", "")), Double.parseDouble(txtValor.getText().replace(",", ".")), txtStatus.getText());
        Main obj = new Main();
        if (obj.adicionarProduto(p)) {
            txtStatus.setForeground(Color.red);
            txtStatus.setText("Já existe um produto com o mesmo nome!\n");
            txtStatus.setEditable(false);
        } else {
            txtStatus.setForeground(Color.green);
            txtStatus.setText("Produto Adicionado com SUCESSO!\n");
            txtStatus.setForeground(Color.BLACK);
            txtStatus.append("Nome: " + txtNome.getText() + "\nQuantidade: " + txtQuantidade.getText() + "\nValor: R$ " + txtValor.getText() + "\nPara Adicionar um novo produto aperte LIMPAR TUDO");
            obj.atualizarBanco();
            txtStatus.setEditable(false);
        }
        Main.atualizaTabela();
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtStatus.setText(null);
        txtStatus.setEditable(true);
        txtValor.setText(null);
        txtQuantidade.setText(null);
        txtNome.setText(null);
        txtNome.requestFocus();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextArea txtStatus;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
