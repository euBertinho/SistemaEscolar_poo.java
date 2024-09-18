import java.util.HashMap;
import java.util.Map;

public class Aluno {
    private String nome;
    private String matricula;
    private Map<String, Double[]> notas;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void cadastrarNota(String disciplina, Double nota1, Double nota2) {
        this.notas.put(disciplina, new Double[]{nota1, nota2, null});
    }

    public void cadastrarProvaFinal(String disciplina, Double notaFinal) {
        if (notas.containsKey(disciplina)) {
            notas.get(disciplina)[2] = notaFinal;
        }
    }

    public Double calcularMedia(String disciplina) {
        if (notas.containsKey(disciplina)) {
            Double[] notasDisciplina = notas.get(disciplina);
            double media = (notasDisciplina[0] + notasDisciplina[1]) / 2;
            if (notasDisciplina[2] != null) {
                media = (media + notasDisciplina[2]) / 2; 
            }
            return media;
        }
        return null;
    }

    public boolean isAprovado(String disciplina) {
        Double media = calcularMedia(disciplina);
        return media != null && media >= 60;
    }

    public Map<String, Double[]> getNotas() {
        return notas;
    }
}
