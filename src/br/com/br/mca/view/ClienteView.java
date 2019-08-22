package br.com.br.mca.view;

import br.com.br.mca.controller.ClienteController;
import br.com.br.mca.model.Cliente;
import br.com.br.mca.util.OperacoesCrud;
import br.com.br.mca.util.ConnectionFactoty;
import br.com.br.mca.util.Util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class ClienteView extends javax.swing.JFrame {

    // Construtor
    public ClienteView() {
        initComponents();
        pnBotoesAcao.setVisible(false);
        limparCampos();
        carregarDadosTabela();
    }
    
    public Integer operacao;
    private String sexo;
    private DefaultTableModel model;
    private String enderecoCliente;
    
    // Variaveis em tempo de execução
    private Integer codigo;
    private String nomeCliente;
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnAcoesPrincipais = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtFone = new javax.swing.JTextField();
        txtDtNasc = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        pnBotoesAcao = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnAcoesPrincipais.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");

        javax.swing.GroupLayout pnAcoesPrincipaisLayout = new javax.swing.GroupLayout(pnAcoesPrincipais);
        pnAcoesPrincipais.setLayout(pnAcoesPrincipaisLayout);
        pnAcoesPrincipaisLayout.setHorizontalGroup(
            pnAcoesPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAcoesPrincipaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAcoesPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnAcoesPrincipaisLayout.setVerticalGroup(
            pnAcoesPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAcoesPrincipaisLayout.createSequentialGroup()
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jLabel1.setText("Nome: ");

        txtNome.setEnabled(false);

        jLabel2.setText("CPF : ");

        jLabel3.setText("Sexo");

        jLabel4.setText("DT Nasc");

        jLabel5.setText("Endereço");

        jLabel6.setText("Fone:");

        txtCpf.setEnabled(false);

        txtEndereco.setEnabled(false);

        txtFone.setEnabled(false);

        txtDtNasc.setEnabled(false);

        rbMasculino.setText("Masculino");
        rbMasculino.setEnabled(false);
        rbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMasculinoActionPerformed(evt);
            }
        });

        rbFeminino.setText("Feminino");
        rbFeminino.setEnabled(false);
        rbFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemininoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbMasculino)
                .addGap(18, 18, 18)
                .addComponent(rbFeminino)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMasculino)
                    .addComponent(rbFeminino)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(txtFone, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Sexo", "Data de Nascimento", "Fone"
            }
        ));
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotoesAcaoLayout = new javax.swing.GroupLayout(pnBotoesAcao);
        pnBotoesAcao.setLayout(pnBotoesAcaoLayout);
        pnBotoesAcaoLayout.setHorizontalGroup(
            pnBotoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesAcaoLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnBotoesAcaoLayout.setVerticalGroup(
            pnBotoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBotoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnAcoesPrincipais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnBotoesAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnAcoesPrincipais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnBotoesAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        operacao = OperacoesCrud.NOVO.getOperacao();
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnNovo.setEnabled(false);
        pnBotoesAcao.setVisible(true);
        limparCampos();
        abrirCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        operacao = OperacoesCrud.EDITAR.getOperacao();
                
        if(tabelaCliente.getSelectedRow() == -1){
            if(tabelaCliente.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A tabela esta vazia!");
            } else {
                JOptionPane.showMessageDialog(null, "Deve ser selecionado um cliente!");
            }
        } else {
            //Quando Selecionar um cliente
            btnExcluir.setEnabled(false);
            btnNovo.setEnabled(false);
            pnBotoesAcao.setVisible(true);
            btnSalvar.setEnabled(false);
            btnAtualizar.setEnabled(true);
            abrirCampos();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        operacao = OperacoesCrud.EXCLUIR.getOperacao();
        
        if(tabelaCliente.getSelectedRow() == -1){
            if(tabelaCliente.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A tabela esta vazia!");
            } else {
                JOptionPane.showMessageDialog(null, "Deve ser selecionado um cliente!");
            }
        } else {
            //Quando Selecionar um cliente
            btnNovo.setEnabled(false);
            pnBotoesAcao.setVisible(true);
            btnSalvar.setEnabled(false);
            btnAtualizar.setEnabled(false);
            btnCancelar.setEnabled(true);
            excluirDados();
            limparCampos();
            fecharCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        gravarAtualizarDados();        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        gravarAtualizarDados();
        btnNovo.setEnabled(true);
        btnAtualizar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnExcluir.setEnabled(true);
        pnBotoesAcao.setVisible(false);
        fecharCampos();        
        atualizaTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void rbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMasculinoActionPerformed
        rbFeminino.setSelected(false);
        sexo =  rbMasculino.getText();
    }//GEN-LAST:event_rbMasculinoActionPerformed

    private void rbFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemininoActionPerformed
        rbMasculino.setSelected(false);
        sexo = rbFeminino.getText();
    }//GEN-LAST:event_rbFemininoActionPerformed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        // Recuperar as informações da Tabela
        ListSelectionModel tabelaSelectionModel = tabelaCliente.getSelectionModel(); // Pegando a linha
        tabelaCliente.setSelectionModel(tabelaSelectionModel); // Refresh - Limpeza da tabela
        
        // Armazena a linha selecionada nas variaveis instância para utilizar nas operações de atualização e exclusão
        setCodigo(Integer.parseInt(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 0).toString()));
        setNomeCliente(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 1).toString());
        String rowCpf = tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 2).toString();
        String rowSexo = tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 3).toString();
        String rowFone = tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 5).toString();

        txtNome.setText(getNomeCliente()); // Atribuindo o SetNomeCliente e pega em tempo de execução
        txtCpf.setText(rowCpf);
        getSexoSelecionado(rowSexo);
        txtDtNasc.setDate(Util.converterToDate(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 4).toString()));
        txtFone.setText(rowFone);
        
        pegaEndereco(Integer.parseInt(tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 0).toString()));
        txtEndereco.setText(enderecoCliente);
        
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnNovo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnExcluir.setEnabled(true);
        pnBotoesAcao.setVisible(false);
        limparCampos();
        fecharCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnAcoesPrincipais;
    private javax.swing.JPanel pnBotoesAcao;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField txtCpf;
    private com.toedter.calendar.JDateChooser txtDtNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void gravarAtualizarDados() {
        // Recupera os Dados da Tela
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String fone = txtFone.getText();
        Date dateNasc = new Date(txtDtNasc.getDate().getTime());
        String endereco = txtEndereco.getText();
        
        // Atribuindo os Dados da tela e atributos para o objeto cliente
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setFone(fone);
        cliente.setNascimento(dateNasc);
        cliente.setEndereco(endereco);
        cliente.setSexo(formatarCampoSexo(sexo));
        
        ClienteController clienteController = new ClienteController();
        try {
            if(operacao == OperacoesCrud.NOVO.getOperacao()) {
                clienteController.cadastrar(cliente); 
                JOptionPane.showMessageDialog(null, "O cliente "+cliente.getNome()+" Foi criado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                model.addRow(new Object[]{clienteController.getCodigo(cliente),nome,cpf,sexo,cliente.getNascimento(),fone}); 
                limparCampos();
                fecharCampos();
            } else if(operacao == OperacoesCrud.EDITAR.getOperacao()){
                cliente.setCodigo(getCodigo());
               
                // Chamada do controller para realizar a persistencia
                clienteController.alterar(cliente); 
                
                // Recupera as informações inseridas nos casmpos e atuzlizar as linhas da tabela
                model.setValueAt(nome, tabelaCliente.getSelectedRow(), 1);
                model.setValueAt(cpf, tabelaCliente.getSelectedRow(), 2);
                model.setValueAt(sexo, tabelaCliente.getSelectedRow(), 3);
                model.setValueAt(Util.converterToString(dateNasc), tabelaCliente.getSelectedRow(), 4);
                model.setValueAt(fone, tabelaCliente.getSelectedRow(), 5);
                JOptionPane.showMessageDialog(null, "O cliente "+cliente.getNome()+" Foi atualizado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    private void abrirCampos(){
        txtCpf.setEnabled(true);
        txtNome.setEnabled(true);
        txtFone.setEnabled(true);
        txtDtNasc.setEnabled(true);
        txtEndereco.setEnabled(true);
        rbFeminino.setEnabled(true);
        rbMasculino.setEnabled(true);
    }
    
    private void limparCampos(){
        txtCpf.setText("");
        txtNome.setText("");
        txtFone.setText("");
        txtDtNasc.setDate(null);
        txtEndereco.setText("");
        rbFeminino.setSelected(false);
        rbMasculino.setSelected(false);
    }
    
    private void fecharCampos(){
        txtCpf.setEnabled(false);
        txtNome.setEnabled(false);
        txtFone.setEnabled(false);
        txtDtNasc.setEnabled(false);
        txtEndereco.setEnabled(false);
        rbFeminino.setEnabled(false);
        rbMasculino.setEnabled(false);
    }

    private String formatarCampoSexo(String sexo) {
        if ("Masculino".equals(sexo)){
            sexo = "F";
        } else {
            sexo = "M";
        }
        return sexo;
    }
    
    private void carregarDadosTabela(){
        String sql = "Select CLI_COD, CLI_NOME, CLI_CPF, CLI_SEXO, CLI_DT_NASC, CLI_FONE  from cliente order by CLI_COD desc";
        
        try {
            Connection connection = ConnectionFactoty.getConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            // Configurações de tamanho do JTable
            tabelaCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(50);   // Código
            tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(180);  // Nome
            tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(120);  // CPF
            tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(80);   // Sexo
            tabelaCliente.getColumnModel().getColumn(4).setPreferredWidth(120);   // Data de Nascimento
            tabelaCliente.getColumnModel().getColumn(5).setPreferredWidth(100);  // Fone
                        
            
            model = (DefaultTableModel) tabelaCliente.getModel();
        
            while(rs.next()){
                Integer rsCodigo = rs.getInt("CLI_COD");
                String rsNome = rs.getString("CLI_NOME");
                String rsCpf = rs.getString("CLI_CPF");
                String rsSexo = rs.getString("CLI_SEXO");

                if("M".equals(rsSexo)){
                    rsSexo = "Feminino";
                } else {
                    rsSexo = "Masculino";
                }
                
                Date rsNasc = rs.getDate("CLI_DT_NASC");
                String rsFone = rs.getString("CLI_FONE");
                
                // Preenche os Dados na JTable que estão retornando do Banco de Dados
                model.addRow(new Object[]{rsCodigo,rsNome,rsCpf,rsSexo,Util.converterToString(rsNasc),rsFone});
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getSexoSelecionado(String rowSexo) {
        if(rowSexo.equals("Masculino")){
            rbMasculino.setSelected(true);
            rbFeminino.setSelected(false);
        } else {
            rbMasculino.setSelected(false);
            rbFeminino.setSelected(true);
        }
    }
    
    private void excluirDados() {
        String msg = "Deletar o Cliente: " +getCodigo()+" - " +getNomeCliente() +"?";
        
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg,"Exclusão",JOptionPane.YES_NO_OPTION);
        if(opcaoEscolhida == JOptionPane.YES_OPTION){
            Cliente cliente = new Cliente();
            cliente.setCodigo(getCodigo());
            
            try {
                ClienteController clienteController = new ClienteController();
                clienteController.excluir(cliente);

                // Remover a linha Selecionada
                model.removeRow(tabelaCliente.getSelectedRow());
                JOptionPane.showMessageDialog(null, "O cliente "+getCodigo()+" - "+ getNomeCliente() +" Foi excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    private String pegaEndereco (int codigo) {
        String sql = "select cli_endereco from cliente where cli_cod = ?";
        
        try {
            Connection conn = ConnectionFactoty.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                 //setEnderecoCliente(rs.getString("CLI_ENDERECO")) ;
                enderecoCliente = rs.getString("CLI_ENDERECO");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return enderecoCliente;
    }
    
    private void atualizaTabela(){
        for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
            model.removeRow(i);
        }
        carregarDadosTabela();
    }
    
        
    
    // Get e Seter das variaveis em tempo de execução (Inicio)
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    // Get e Seter das variaveis em tempo de execução (Fim)
    
    /*
    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }
    */
}
