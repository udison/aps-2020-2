package apsagricultura.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableUtils {
  
  public static void fillTable(ResultSet result, JTable table) throws SQLException {
    int columns = result.getMetaData().getColumnCount();

    while(result.next()) {
      Object[] row = new Object[columns];

      for(int i = 0; i < columns; i++) {
        row[i] = result.getObject(i + 1);
      }

      ((DefaultTableModel) table.getModel()).addRow(row);
    }
  }
  
}
