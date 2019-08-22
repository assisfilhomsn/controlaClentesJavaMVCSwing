package br.com.br.mca.view;

import br.com.br.mca.util.*;
import br.com.br.mca.dao.ClienteDao;
import br.com.br.mca.model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PesquisaView extends javax.swing.JFrame {

    private String nomeCliente;
    private DefaultTableModel model;
    
    public PesquisaView() {
        initComponents();
        carregarDadosDaTabela2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPesquisaNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome: ");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Sexo", "Data de Nascimento", "Fone"
            }
        ));
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Pesquisa Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(248, 248, 248))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        model = (DefaultTableModel) tabelaClientes.getModel();
        TableRowSorter sorter = new TableRowSorter<>(model); // Funcina como LIKE nas pesquisa
        tabelaClientes.setRowSorter(sorter); 
        
        String nome = txtPesquisaNome.getText(); // Pegando o que foi escrito gravando na variavel nome
        if(nome != null){
            sorter.setRowFilter(RowFilter.regexFilter(("(?i)" + nome)));
        } else {
            sorter.setRowFilter(null);
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        ListSelectionModel tableSelectionModel = tabelaClientes.getSelectionModel();
        
        // Limpeza de Cache
        tabelaClientes.setSelectionModel(tableSelectionModel);
        setNomeCliente(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 1).toString());
        txtPesquisaNome.setText(getNomeCliente());
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtPesquisaNome.setText("");
        btnPesquisarActionPerformed(evt); // Executa um Evento
    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(PesquisaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PesquisaView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtPesquisaNome;
    // End of variables declaration//GEN-END:variables

    private void carregarDadosDaTabela() {
        String sql = "Select CLI_COD, CLI_NOME, CLI_CPF, CLI_SEXO, CLI_DT_NASC, CLI_FONE  from cliente order by CLI_COD desc";
        
        try {
            Connection connection = ConnectionFactoty.getConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            // Configurações de tamanho do JTable
            tabelaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);   // Código
            tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(180);  // Nome
            tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(120);  // CPF
            tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(80);   // Sexo
            tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(120);   // Data de Nascimento
            tabelaClientes.getColumnModel().getColumn(5).setPreferredWidth(100);  // Fone
                        
            
            model = (DefaultTableModel) tabelaClientes.getModel();

            while(rs.next()){
                Integer rsCodigo = rs.getInt("CLI_COD");
                String rsNome = rs.getString("CLI_NOME");
                String rsCpf = rs.getString("CLI_CPF");
                String rsSexo = rs.getString("CLI_SEXO");

                if( rsSexo != null ){
                    if("M".equals(rsSexo)){
                        rsSexo = "Masculino";
                    } else {
                        rsSexo = "Feminino";
                    }
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
    
    
    private void carregarDadosDaTabela2() {
        try {
            // Configurações de tamanho das colunas do JTable
            tabelaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);   // Código
            tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(180);  // Nome
            tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(120);  // CPF
            tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(80);   // Sexo
            tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(120);   // Data de Nascimento
            tabelaClientes.getColumnModel().getColumn(5).setPreferredWidth(100);  // Fone
            
            model = (DefaultTableModel) tabelaClientes.getModel();
            
            ClienteDao clienteDao = new ClienteDao();
            for (Cliente cliente : clienteDao.TodosOsClientes() ){
                
                if( cliente.getSexo() != null ){
                    if("M".equals(cliente.getSexo())){
                        cliente.setSexo("Masculino");
                    } else {
                        cliente.setSexo("Feminino");
                    }
                }
                
                model.addRow(new Object[]{cliente.getCodigo(),
                                          cliente.getNome(),
                                          cliente.getCpf(),
                                          cliente.getSexo(),
                                          Util.converterToString(cliente.getNascimento()),
                                          cliente.getFone()});
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
