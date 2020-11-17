package apsagricultura;

import apsagricultura.database.SQLConnection;
import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {
    
    // SQLConnection.testConnection();
    
    // Inicializa o menu principal
    JFrame mainMenu = new FrmMenu();
    mainMenu.setVisible(true);
    
  }
    
}