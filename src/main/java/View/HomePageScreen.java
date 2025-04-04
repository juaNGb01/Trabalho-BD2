/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import dao.FuncionarioDAO;
import View.Funcinarios.GerenciarFuncionarios;
import View.Funcinarios.CadFuncionario;
import View.PainelBackUp.BackUpScreen;
import View.produto.GerenciarProdutos;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.BackUp;


/**
 *
 * @author juanb
 */
public class HomePageScreen extends javax.swing.JFrame {

    /**
     * Creates new form HomePageScreen
     */
    public HomePageScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        HomePageScreen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        homeBtn = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        MenuFunc = new javax.swing.JMenu();
        MenuGerenciarFunc = new javax.swing.JMenuItem();
        MenuCadastrarFunc = new javax.swing.JMenuItem();
        backupBtn = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Sistema de Gerenciamento de Vendas");

        javax.swing.GroupLayout HomePageScreenLayout = new javax.swing.GroupLayout(HomePageScreen);
        HomePageScreen.setLayout(HomePageScreenLayout);
        HomePageScreenLayout.setHorizontalGroup(
            HomePageScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePageScreenLayout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel1)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        HomePageScreenLayout.setVerticalGroup(
            HomePageScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePageScreenLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        jPanel1.add(HomePageScreen, "HomeCard");

        homeBtn.setText("Home");
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBtnMouseClicked(evt);
            }
        });
        jMenuBar1.add(homeBtn);

        jMenu2.setText("Vendas ");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Produtos");

        jMenu5.setText("Gerenciar");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu5);

        jMenuBar1.add(jMenu3);

        MenuFunc.setText("Gerenciamento");

        MenuGerenciarFunc.setText("Gerenciar Funcionarios ");
        MenuGerenciarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGerenciarFuncActionPerformed(evt);
            }
        });
        MenuFunc.add(MenuGerenciarFunc);

        MenuCadastrarFunc.setText("Cadastrar  Funcionarios");
        MenuCadastrarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrarFuncActionPerformed(evt);
            }
        });
        MenuFunc.add(MenuCadastrarFunc);

        backupBtn.setText("Back Up");
        backupBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backupBtnMouseClicked(evt);
            }
        });
        MenuFunc.add(backupBtn);

        jMenuBar1.add(MenuFunc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
        HomePageScreen homePage = new HomePageScreen();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnMouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:

        GerenciarProdutos prodScreen = new GerenciarProdutos();
        prodScreen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    //Botão acessar tela de venda
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        
        VendaScreen telaVenda = new VendaScreen(); 
        telaVenda.setVisible(true); 
        this.dispose(); 
        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void MenuCadastrarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrarFuncActionPerformed
        // TODO add your handling code here:
        CadFuncionario CadFunScreen = new CadFuncionario();
        CadFunScreen.setVisible(true);
        //fecha tela atual
        this.dispose();
    }//GEN-LAST:event_MenuCadastrarFuncActionPerformed

    private void MenuGerenciarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGerenciarFuncActionPerformed
        // TODO add your handling code here:
              
        GerenciarFuncionarios BuscarFunScreen = new GerenciarFuncionarios();
        BuscarFunScreen.setVisible(true);
        this.dispose();
   
    }//GEN-LAST:event_MenuGerenciarFuncActionPerformed

    private void backupBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupBtnMouseClicked
        // TODO add your handling code here:
        
        BackUpScreen backup = new BackUpScreen(); 
        backup.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_backupBtnMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(HomePageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePageScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomePageScreen;
    private javax.swing.JMenuItem MenuCadastrarFunc;
    private javax.swing.JMenu MenuFunc;
    private javax.swing.JMenuItem MenuGerenciarFunc;
    private javax.swing.JMenu backupBtn;
    private javax.swing.JMenu homeBtn;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
