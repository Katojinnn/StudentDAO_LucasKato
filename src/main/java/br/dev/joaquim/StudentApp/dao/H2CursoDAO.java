package br.dev.joaquim.StudentApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.dev.joaquim.StudentApp.entities.Curso;

public class H2SCursoDAO implements CursoDAO {

  private Connection connection;
  private String url = "jdbc:h2:file:~/data/students;";
  private String user = "root";
  private String password = "root";

  public H2CursoDAO() {
    connect();
    createTableIfNotExists();
  }

  private void connect() {
    try {
      this.connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException ex) {
      this.connection = null;
      System.out.println("Problema ao conectar no banco de dados");
      ex.printStackTrace();
    }
  }

  private void createTableIfNotExists() {
    try {
      String sql = "CREATE TABLE IF NOT EXISTS cursos(" +
          "idCurso INT, nomeCursco VARCHAR(256), PRIMARY KEY (idCurso));";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println("Problema ao criar a tabela");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao criar a tabela (sem conexao)");
    }
  }

  @Override
  public boolean create(Curso curso) {
    try {
      String sql = "INSERT INTO cursos VALUES(?,?)";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1, curso.getIdCurso());
      stmt.setString(2, curso.getNomeCurso());
      stmt.executeUpdate();

      return true;

    } catch (SQLException ex) {
      System.out.println("Problema ao criar curso");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao criar curso (sem conexao)");
    }

    return false;
  }

  @Override
  public List<Curso> findAll() {
    try {
      String sql = "SELECT * FROM cursos";
      PreparedStatement stmt = connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      List<Curso> curso = new ArrayList<>();

      while (rs.next()) {
        int idCurso = rs.getInt("id do curso");
        String nomeCurso = rs.getString("nome do curso");
        Curso curso = new (idCurso, nomeCurso, periodoCurso);
        curso.add(curso);
      }

      return curso;

    } catch (SQLException ex) {
      System.out.println("Problema ao buscar curso");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao buscar curso (sem conexao)");
    }

    return new ArrayList<>();
  }

  @Override
  public Curso findByIdCurso(int idCurso) {
    try {
      String sql = "SELECT * FROM cursos WHERE idCurso = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1, idCurso);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        String nomeCurso = rs.getString("nome do curso");
        return new Curso(idCurso, nomeCurso);
      }
    } catch (SQLException ex) {
      System.out.println("Problema ao buscar Curso pelo id");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao buscar Curso pelo id (sem conexao)");
    }

    return null;
  }

  @Override
  public boolean update(Curso curso) {
    try {
      String sql = "UPDATE cursos SET nomeCurso = ? WHERE idCurso = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, student.getNomeCurso());
      stmt.setInt(2, student.getIdCurso());
      stmt.executeUpdate();

      return true;

    } catch (SQLException ex) {
      System.out.println("Problema ao atualizar curso");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao atualizar curso (sem conexao)");
    }

    return false;
  }

  @Override
  public boolean delete(int idCurso) {
    try {
      String sql = "DELETE FROM cursos WHERE idCurso = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1, idCurso);
      stmt.executeUpdate();

      return true;

    } catch (SQLException ex) {
      System.out.println("Problema ao apagar curso");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao apagar curso (sem conexao)");
    }

    return false;
  }
}
