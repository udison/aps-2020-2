package apsagricultura.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Planta {

  private int id;
  private String nome;
  private String nomeCientifico;
  private int dias;
  private String solo;
  private float densidade;
  private float espacFileiras;
  private int tempSolo;
  private int profSolo;

  public Planta() {

  }

  public Planta(int id, String nome, String nomeCientifico, int dias, String solo, float densidade, int espacFileiras, int tempSolo, int profSolo) {
    this.id = id;
    this.nome = nome;
    this.nomeCientifico = nomeCientifico;
    this.dias = dias;
    this.solo = solo;
    this.densidade = densidade;
    this.espacFileiras = espacFileiras;
    this.tempSolo = tempSolo;
    this.profSolo = profSolo;
  }
  
  public static Planta createFromResultSet(ResultSet rs) {
    Planta planta = new Planta();
    
    try {
      
      while(rs.next()) {
        planta.setId(rs.getInt("id"));
        planta.setNome(rs.getString("nome"));
        planta.setNomeCientifico(rs.getString("nome_cientifico"));
        planta.setDias(rs.getInt("dias"));
        planta.setSolo(rs.getString("solo"));
        planta.setDensidade(rs.getFloat("densidade"));
        planta.setEspacFileiras(rs.getInt("espac_fileiras"));
        planta.setTempSolo(rs.getInt("temp_solo"));
        planta.setProfSolo(rs.getInt("prof_solo"));
        break;
      }
    } 
    catch (SQLException e) {
      System.out.println("Erro: " + e.getLocalizedMessage());
      planta = null;
    }
    
    return planta;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNomeCientifico() {
    return nomeCientifico;
  }

  public void setNomeCientifico(String nomeCientifico) {
    this.nomeCientifico = nomeCientifico;
  }

  public int getDias() {
    return dias;
  }

  public void setDias(int dias) {
    this.dias = dias;
  }

  public String getSolo() {
    return solo;
  }

  public void setSolo(String solo) {
    this.solo = solo;
  }

  public float getDensidade() {
    return densidade;
  }

  public void setDensidade(float densidade) {
    this.densidade = densidade;
  }

  public float getEspacFileiras() {
    return espacFileiras;
  }

  public void setEspacFileiras(float espacFileiras) {
    this.espacFileiras = espacFileiras;
  }

  public int getTempSolo() {
    return tempSolo;
  }

  public void setTempSolo(int tempSolo) {
    this.tempSolo = tempSolo;
  }

  public int getProfSolo() {
    return profSolo;
  }

  public void setProfSolo(int profSolo) {
    this.profSolo = profSolo;
  }
}