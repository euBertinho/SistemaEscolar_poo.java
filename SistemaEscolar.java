import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEscolar {
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<Professor> professores;
    private List<Turma> turmas;

    public SistemaEscolar() {
        alunos = new ArrayList<>();
        disciplinas = new ArrayList<>();
        professores = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    public void cadastrarAluno(String nome, String matricula) {
        Aluno aluno = new Aluno(nome, matricula);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public void cadastrarDisciplina(String nome) {
        Disciplina disciplina = new Disciplina(nome);
        disciplinas.add(disciplina);
        System.out.println("Disciplina cadastrada com sucesso.");
    }

    public void cadastrarProfessor(String nome) {
        Professor professor = new Professor(nome);
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso.");
    }

    public void cadastrarTurma(String nomeDisciplina, String nomeProfessor) {
        Disciplina disciplina = null;
        Professor professor = null;

        for (Disciplina d : disciplinas) {
            if (d.getNome().equalsIgnoreCase(nomeDisciplina)) {
                disciplina = d;
                break;
            }
        }

        for (Professor p : professores) {
            if (p.getNome().equalsIgnoreCase(nomeProfessor)) {
                professor = p;
                break;
            }
        }

        if (disciplina != null && professor != null) {
            Turma turma = new Turma(disciplina, professor);
            turmas.add(turma);
            professor.adicionarTurma(turma);
            System.out.println("Turma cadastrada com sucesso.");
        } else {
            System.out.println("Disciplina ou professor não encontrado.");
        }
    }

    public void cadastrarNota(String matricula, String nomeDisciplina, Double nota1, Double nota2) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                aluno.cadastrarNota(nomeDisciplina, nota1, nota2);
                System.out.println("Notas cadastradas com sucesso.");
                
                
                if (!aluno.isAprovado(nomeDisciplina)) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Aluno não aprovado.");
                    System.out.print("Digite a nota da recuperação: ");
                    Double notaRecuperacao = scanner.nextDouble();
                    aluno.cadastrarRecuperacao(nomeDisciplina, notaRecuperacao);
                    System.out.println("Nota de recuperação cadastrada com sucesso.");
                }
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public void emitirBoletim(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                System.out.println("Boletim de " + aluno.getNome());
                for (String disciplina : aluno.getNotas().keySet()) {
                    Double media = aluno.calcularMedia(disciplina);
                    System.out.println("Disciplina: " + disciplina + " | Média: " + media);
                    System.out.println("Aprovado: " + aluno.isAprovado(disciplina));
                }
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }
}
