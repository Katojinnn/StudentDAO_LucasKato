package br.dev.joaquim.StudentApp.entities;

public class Curso {
  private int idCurso;
  private String nomeCurso;
  private String periodoCurso;

  public Curso() {
  }

  public Curso(int idCurso, String nomeCurso, String periodoCurso) {
    this.idCurso= idCurso;
    this.nomeCurso = nomeCurso;
  }

  public int getIdCurso() {
    return idCurso;
  }

  public String getNomeCurso() {
    return nomeCurso;
  }
  public String getPeriodoCurso(){
    return periodoCurso;
  }

  public void setIdCurso(int idCurso) {
    this.idCurso = idCurso;
  }

  public void setNomeCurso(String nomeCurso) {
    this.nomeCurso = nomeCurso;
  }
  public void setPeriodoCurso(String periodoCurso){
    this.periodoCurso = periodoCurso;
  }

  @Override
  public String toString() {
    return "Curso " + getNomeCurso() + " [" + getIdCurso() + "]+[" + getPeriodoCurso() + "]";
  }
}
