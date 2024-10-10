package br.dev.joaquim.StudentApp.ihm;

import java.util.Scanner;

import br.dev.joaquim.StudentApp.dao.CursoDAO;
import br.dev.joaquim.StudentApp.entities.Curso;

public class CursoIHM {

    private CursoDAO cursoDAO;

    public CursoIHM(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("=== Curso Management Menu ===");
            System.out.println("1. Adicionar Curso");
            System.out.println("2. Ver todos Cursos");
            System.out.println("3. Atualizar Student");
            System.out.println("4. Deletar Student");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addCurso(scanner);
                    break;
                case 2:
                    viewAllCursos();
                    break;
                case 3:
                    updateCurso(scanner);
                    break;
                case 4:
                    deleteCurso(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        }

        scanner.close();
    }

    private void addCurso(Scanner scanner) {
        System.out.print("Nome do curso: ");
        String nomeCurso = scanner.nextLine();
        System.out.print("digite o id do curso: ");
        int idCurso = scanner.nextInt();

        Curso curso = new Curso();
        curso.setNomeCurso(nomeCurso);
        curso.setIdCurso(idCurso);

        cursoDAO.create(curso);
        System.out.println("Curso adicionado com sucesso");
    }

    private void viewAllCursos() {
        System.out.println("=== Lista de cursos ===");
        for (Curso curso : cursoDAO.findAll()) {
            System.out.println(curso);
        }
    }

    private void updateCurso(Scanner scanner) {
        System.out.print("Digite o id do curso para atualizar ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();

        Curso curso = cursoDAO.findByIdCurso(idCurso);
        if (curso == null) {
            System.out.println("Curso não encontrado");
            return;
        }

        System.out.print("Digite um novo curso: ");
        String nomeCurso = scanner.nextLine();

        curso.setNomeCurso(nomeCurso);

        cursoDAO.update(curso);
        System.out.println("Curso atualizado com sucesso!");
    }

    private void deleteCurso(Scanner scanner) {
        System.out.print("Digite um id de curso para deletar ");
        int idCurso = scanner.nextInt();
        cursoDAO.delete(idCurso);
        System.out.println("Curso deletado com sucesso");
    }
}
