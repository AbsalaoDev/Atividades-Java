package GestãoAcadêmica;

public class ProfessorSubstituto extends Professores {

    public ProfessorSubstituto(int horasSemanais, String matricula, String nome, double salarioBase) {
        super(horasSemanais, matricula, nome, salarioBase);
    }

    @Override
    public boolean elegivelAfastamento() {
        return getHorasSemanais() > 35;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase();
    }
}