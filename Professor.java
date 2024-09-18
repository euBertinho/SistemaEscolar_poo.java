import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private List<Turma> turmas;

    public Professor(String nome) {
        this.nome = nome;
        this.turmas = new ArrayList<>();
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        turmas.remove(turma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public String getNome() {
        return nome;
    }
}
