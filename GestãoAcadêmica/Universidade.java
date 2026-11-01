package GestãoAcadêmica;

import java.util.ArrayList;

public class Universidade {
    private ArrayList<Professores> professores = new ArrayList<>();

    public void adicionarProfessor(Professores p) {
        professores.add(p);
    }

    public Professores buscarProfessor(String matricula) {
        for (Professores p : professores) {
            if (p.getMatricula().equals(matricula)) {
                return p;
            }
        }

        return null;
    }

    public void removerProfessor(String matricula) {
        Professores p = buscarProfessor(matricula);

        if (p != null) {
            professores.remove(p);
        }
    }

    public void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado!");
            return;
        }

        for (Professores p : professores) {
            System.out.println("\n-------------------------");
            System.out.println("Nome: " + p.getNome());
            System.out.println("Matrícula: " + p.getMatricula());
            System.out.println("Horas semanais: " + p.getHorasSemanais());
            System.out.println("Salário base: R$ " + p.getSalarioBase());
            System.out.println("-------------------------");
        }
    }
}