package apsagricultura.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnection {
  
    private static final String CONNECTION_STRING = 
                        "jdbc:sqlserver://localhost:1433;"
                      + "database=db_aps;"
                      + "user=sa;"
                      + "password=teste123;"
                      + "encrypt=true;"
                      + "trustServerCertificate=true;"
                      + "loginTimeout=10;";
    
  public static Connection get() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
    Connection connection = DriverManager.getConnection(CONNECTION_STRING);
    
    return connection;
  }
    
  public static boolean testConnection() {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
      
      Connection connection = DriverManager.getConnection(CONNECTION_STRING);
      
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM planta");
      ResultSet plantas = statement.executeQuery();
      
      while(plantas.next()) {
        System.out.println(plantas.getString("nome"));
      }
      
      return true;
    }
    catch(SQLException e) {
      System.out.println("Erro de conexão ao banco de dados. Erro: " + e.getMessage());
      return false;
    }
    catch(Exception e) {
      System.out.println("Deu ruim. O ruim: " + e.getMessage());
      return false;
    }
  }
  
}
