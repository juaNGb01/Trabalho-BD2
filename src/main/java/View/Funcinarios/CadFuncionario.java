/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Funcinarios;
import Model.Funcionario;
import View.HomePageScreen;
import View.PainelBackUp.BackUpScreen;
import View.VendaScreen;
import View.produto.GerenciarProdutos;


import dao.FuncionarioDAO;
import java.awt.CardLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author juanb
 */
public class CadFuncionario extends javax.swing.JFrame {

    public CadFuncionario() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CadFunScreen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InputNomeFun = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        InputCpfFun = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CadastroBtn = new javax.swing.JButton();
        InputSenha = new javax.swing.JPasswordField();
        FuncInput = new javax.swing.JComboBox<>();
        closeBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        homeBtn = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        MenuFunc = new javax.swing.JMenu();
        MenuGerenciarFunc = new javax.swing.JMenuItem();
        MenuCadastrarFunc = new javax.swing.JMenuItem();
        backupBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Cadastro de Funcionario: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nome: ");

        jScrollPane2.setViewportView(InputNomeFun);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("CPF");

        jScrollPane3.setViewportView(InputCpfFun);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Senha");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Função: ");

        CadastroBtn.setText("Cadastrar");
        CadastroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroBtnActionPerformed(evt);
            }
        });

        FuncInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gerente", "funcionario", "admin" }));
        FuncInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CadFunScreenLayout = new javax.swing.GroupLayout(CadFunScreen);
        CadFunScreen.setLayout(CadFunScreenLayout);
        CadFunScreenLayout.setHorizontalGroup(
            CadFunScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadFunScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CadFunScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CadFunScreenLayout.createSequentialGroup()
                        .addGroup(CadFunScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(CadFunScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(InputSenha)
                            .addComponent(FuncInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(CadastroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        CadFunScreenLayout.setVerticalGroup(
            CadFunScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadFunScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CadFunScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CadFunScreenLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CadFunScreenLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FuncInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(InputSenha)))
                .addGap(22, 22, 22)
                .addComponent(CadastroBtn)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        closeBtn.setText("X");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CadFunScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeBtn)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CadFunScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //cadastrar o funcionario
    private void CadastroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroBtnActionPerformed
        FuncionarioDAO funDao = new FuncionarioDAO(); 
        funDao.addFuncionario(getInputData());
        resetFields();       
    }//GEN-LAST:event_CadastroBtnActionPerformed

    
    private void FuncInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuncInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FuncInputActionPerformed

    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
        HomePageScreen homePage = new HomePageScreen();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:

        VendaScreen telaVenda = new VendaScreen();
        telaVenda.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:

        GerenciarProdutos prodScreen = new GerenciarProdutos();
        prodScreen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void MenuGerenciarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGerenciarFuncActionPerformed
        // TODO add your handling code here:

        GerenciarFuncionarios BuscarFunScreen = new GerenciarFuncionarios();
        BuscarFunScreen.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_MenuGerenciarFuncActionPerformed

    private void MenuCadastrarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrarFuncActionPerformed
        // TODO add your handling code here:
        CadFuncionario CadFunScreen = new CadFuncionario();
        CadFunScreen.setVisible(true);
        //fecha tela atual
        this.dispose();
    }//GEN-LAST:event_MenuCadastrarFuncActionPerformed

    private void backupBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupBtnMouseClicked
        // TODO add your handling code here:

        BackUpScreen backup = new BackUpScreen();
        backup.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backupBtnMouseClicked
    private Funcionario getInputData(){
        
        
        String nome = InputNomeFun.getText();
        String cpf = InputCpfFun.getText();
        String senha = new String(InputSenha.getPassword());
        String funcao = (String) FuncInput.getSelectedItem();
        
        
        // Verifica se algum campo está vazio
        if( nome.isEmpty() || cpf.isEmpty() || senha.isEmpty() || funcao.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return null; 
        }   

        Funcionario func = new Funcionario(nome,cpf,senha,funcao);
        return func;  
    }
    private void resetFields(){
        InputNomeFun.setText("");
        InputSenha.setText("");
        InputCpfFun.setText("");
    }

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
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadFuncionario().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CadFunScreen;
    private javax.swing.JButton CadastroBtn;
    private javax.swing.JComboBox<String> FuncInput;
    private javax.swing.JTextPane InputCpfFun;
    private javax.swing.JTextPane InputNomeFun;
    private javax.swing.JPasswordField InputSenha;
    private javax.swing.JMenuItem MenuCadastrarFunc;
    private javax.swing.JMenu MenuFunc;
    private javax.swing.JMenuItem MenuGerenciarFunc;
    private javax.swing.JMenu backupBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JMenu homeBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
