package br.com.br.mca.view;

import javax.swing.JOptionPane;

public class SistemaView extends javax.swing.JFrame {

    public SistemaView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPesqCliente = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadCliente = new javax.swing.JMenuItem();
        menuPesquisar = new javax.swing.JMenu();
        menuPesqCliente = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPesqCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/br/mca/img/clientes.jpg"))); // NOI18N
        btnPesqCliente.setText("Clientes");
        btnPesqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqClienteActionPerformed(evt);
            }
        });

        menuCadastro.setText("Cadastro");
        menuCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCadastroMouseClicked(evt);
            }
        });
        menuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroActionPerformed(evt);
            }
        });

        menuCadCliente.setText("Cliente");
        menuCadCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCadClienteMouseClicked(evt);
            }
        });
        menuCadastro.add(menuCadCliente);

        jMenuBar1.add(menuCadastro);

        menuPesquisar.setText("Pesquisar");
        menuPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarActionPerformed(evt);
            }
        });

        menuPesqCliente.setText("Cliente");
        menuPesqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesqClienteActionPerformed(evt);
            }
        });
        menuPesquisar.add(menuPesqCliente);

        jMenuBar1.add(menuPesquisar);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesqCliente)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesqClienteActionPerformed

    private void menuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroActionPerformed
        
    }//GEN-LAST:event_menuCadastroActionPerformed

    private void menuPesqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesqClienteActionPerformed
        new PesquisaView().show(); // Instancia da Classe View e mandou mostrar
    }//GEN-LAST:event_menuPesqClienteActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        // Sem ação (Não permite apagar)
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        String msg = "Deseja sair do sistema?";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg,"Sistema",JOptionPane.YES_NO_OPTION);
        if(opcaoEscolhida == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_menuSairMouseClicked

    private void menuPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarActionPerformed
        new PesquisaView().show();
    }//GEN-LAST:event_menuPesquisarActionPerformed

    private void menuCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroMouseClicked
        // Sem ação (Não permite apagar)
    }//GEN-LAST:event_menuCadastroMouseClicked

    private void menuCadClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadClienteMouseClicked
        new ClienteView().show(); // Instancia da Classe View e mandou mostrar
    }//GEN-LAST:event_menuCadClienteMouseClicked

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
            java.util.logging.Logger.getLogger(SistemaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesqCliente;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCadCliente;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuPesqCliente;
    private javax.swing.JMenu menuPesquisar;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
