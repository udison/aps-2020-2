package apsagricultura;

import apsagricultura.database.SQLConnection;
import apsagricultura.models.Planta;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FrmPlantar extends javax.swing.JFrame {
  
  Connection connection;
  
  public FrmPlantar() {
    initComponents();
    this.btn_FinalizarPlantacao.setEnabled(false);
    
    // Inicializa o objeto de conexão com o BD
    try {
      connection = SQLConnection.get();
    }
    catch(ClassNotFoundException e) {
      JOptionPane.showMessageDialog(rootPane, "A classe com.microsoft.sqlserver.jdbc.SQLServerDriver não foi encontrada. Verifique se o driver mssql-jdbc-8.4.1.jre8.jar está instalado.", "Erro", JOptionPane.ERROR_MESSAGE);
      connection = null;
    }
    catch(SQLException e) {
      JOptionPane.showMessageDialog(rootPane, "Erro de conexão com o banco de dados.", "Alerta", JOptionPane.ERROR_MESSAGE);
      connection = null;
    }
    catch(Exception e) {
      JOptionPane.showMessageDialog(rootPane, "Erro: " + e.getLocalizedMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
      connection = null;
    }
    
    try {
      PreparedStatement stmt = connection.prepareStatement("SELECT CONCAT(planta.nome, ' (', planta.nome_cientifico,')') AS planta FROM planta");
      ResultSet rs = stmt.executeQuery();
      
      while(rs.next()) {
        combo_Planta.addItem(rs.getString("planta"));
      }
      
    }
    catch(Exception e) {
      JOptionPane.showMessageDialog(rootPane, "Erro: " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
    }
  }
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    combo_Planta = new javax.swing.JComboBox<>();
    txt_Altura = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    btn_FinalizarPlantacao = new javax.swing.JButton();
    btn_LimparTudo = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    txt_Largura = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setResizable(false);
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });

    combo_Planta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        combo_PlantaActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel1.setText("Nome da Planta");
    jLabel1.setToolTipText("");

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel3.setText("Largura da área");
    jLabel3.setToolTipText("");

    btn_FinalizarPlantacao.setBackground(new java.awt.Color(51, 153, 0));
    btn_FinalizarPlantacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btn_FinalizarPlantacao.setForeground(new java.awt.Color(255, 255, 255));
    btn_FinalizarPlantacao.setText("Finalizar Plantação");
    btn_FinalizarPlantacao.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_FinalizarPlantacaoActionPerformed(evt);
      }
    });

    btn_LimparTudo.setBackground(new java.awt.Color(204, 0, 0));
    btn_LimparTudo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btn_LimparTudo.setForeground(new java.awt.Color(255, 255, 255));
    btn_LimparTudo.setText("Limpar Tudo");
    btn_LimparTudo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_LimparTudoActionPerformed(evt);
      }
    });

    jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel5.setText("Altura da área");
    jLabel5.setToolTipText("");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txt_Largura)
          .addComponent(txt_Altura)
          .addComponent(combo_Planta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel3)
              .addComponent(jLabel5))
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(btn_LimparTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btn_FinalizarPlantacao, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(combo_Planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txt_Altura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txt_Largura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btn_LimparTudo)
          .addComponent(btn_FinalizarPlantacao))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

    private void combo_PlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_PlantaActionPerformed
      
    }//GEN-LAST:event_combo_PlantaActionPerformed
    
    private void btn_LimparTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparTudoActionPerformed
      this.txt_Altura.setText("");
      this.txt_Largura.setText("");
    }//GEN-LAST:event_btn_LimparTudoActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       
      if(txt_Altura.getText().isEmpty() || txt_Altura.getText() == "")
      {
        btn_FinalizarPlantacao.setEnabled(false);
        txt_Altura.setBackground(Color.red);
      }
      else
      {
        btn_FinalizarPlantacao.setEnabled(true);
        txt_Altura.setBackground(Color.white);
      }
       
    }//GEN-LAST:event_formMouseClicked

  private void btn_FinalizarPlantacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FinalizarPlantacaoActionPerformed
    try {
      String nome = combo_Planta.getSelectedItem().toString();
      PreparedStatement stmt = connection.prepareStatement("SELECT * FROM planta WHERE planta.nome = ?");
      stmt.setString(1, nome.substring(0, nome.indexOf(" (")));
      ResultSet rs = stmt.executeQuery();

      Planta planta = Planta.createFromResultSet(rs);
      
      float area = Float.parseFloat(txt_Altura.getText()) * Float.parseFloat(txt_Largura.getText());
      float tamFileira = Float.parseFloat(txt_Largura.getText());
      float quantidade = (float)Math.floor(area / planta.getDensidade());
      
      String mensagem = "Para plantar " + planta.getNome() + " (" + planta.getNomeCientifico() + ") em uma área de " + area + "m², você precisará de " + quantidade + " sementes,\ndistribuidas em fileiras de " + tamFileira + "m com " + planta.getEspacFileiras() + "cm de espaçamento entre as mesmas.\n\nTempo de germinação: " + planta.getDias() + " dias\nDetalhes do solo: " + planta.getSolo();
      
      JOptionPane.showMessageDialog(rootPane, mensagem, "Plantar", JOptionPane.INFORMATION_MESSAGE);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(rootPane, "Erro: " + e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_btn_FinalizarPlantacaoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPlantar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPlantar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPlantar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPlantar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPlantar().setVisible(true);
                
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btn_FinalizarPlantacao;
  private javax.swing.JButton btn_LimparTudo;
  private javax.swing.JComboBox<String> combo_Planta;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JTextField txt_Altura;
  private javax.swing.JTextField txt_Largura;
  // End of variables declaration//GEN-END:variables
}
