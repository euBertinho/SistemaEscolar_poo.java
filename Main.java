import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaEscolar sistema = new SistemaEscolar();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1) Cadastrar Aluno");
            System.out.println("2) Cadastrar Disciplina");
            System.out.println("3) Cadastrar Professor");
            System.out.println("4) Cadastrar Turma");
            System.out.println("5) Cadastrar Nota");
            System.out.println("6) Emitir Boletim");
            System.out.println("0) Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    sistema.cadastrarAluno(nomeAluno, matricula);
                    break;

                case 2:
                    System.out.print("Nome da Disciplina: ");
                    String nomeDisciplina = scanner.nextLine();
                    sistema.cadastrarDisciplina(nomeDisciplina);
                    break;

                case 3:
                    System.out.print("Nome do Professor: ");
                    String nomeProfessor = scanner.nextLine();
                    sistema.cadastrarProfessor(nomeProfessor);
                    break;

                case 4:
                    System.out.print("Nome da Disciplina: ");
                    String nomeDisciplinaTurma = scanner.nextLine();
                    System.out.print("Nome do Professor: ");
                    String nomeProfessorTurma = scanner.nextLine();
                    sistema.cadastrarTurma(nomeDisciplinaTurma, nomeProfessorTurma);
                    break;

                case 5:
                    System.out.print("Matrícula do Aluno: ");
                    String matriculaNota = scanner.nextLine();
                    System.out.print("Nome da Disciplina: ");
                    String nomeDisciplinaNota = scanner.nextLine();
                    System.out.print("Nota 1: ");
                    Double nota1 = scanner.nextDouble();
                    System.out.print("Nota 2: ");
                    Double nota2 = scanner.nextDouble();
                    scanner.nextLine(); 
                    sistema.cadastrarNota(matriculaNota, nomeDisciplinaNota, nota1, nota2);
                    break;

                case 6:
                    System.out.print("Matrícula do Aluno: ");
                    String matriculaBoletim = scanner.nextLine();
                    sistema.emitirBoletim(matriculaBoletim);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
