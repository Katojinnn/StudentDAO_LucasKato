package br.dev.joaquim.StudentApp.entities;

public class Curso {
  private int idCurso;
  private String nomeCurso;

  public Curso() {
  }

  public Curso(int idCurso, String nomeCurso) {
    this.idCurso= idCurso;
    this.nomeCurso = nomeCurso;
  }

  public int getIdCurso() {
    return idCurso;
  }

  public String getNomeCurso() {
    return nomeCurso;
  }

  public void setIdCurso(int idCurso) {
    this.idCurso = idCurso;
  }

  public void setNomeCurso(String nomeCurso) {
    this.nomeCurso = nomeCurso;
  }
  @Override
  public String toString() {
    return "Curso " + getNomeCurso() + " [" + getIdCurso() + "]";
  }
}
