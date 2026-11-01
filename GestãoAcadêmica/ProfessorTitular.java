package GestãoAcadêmica;

public class ProfessorTitular extends Professores {

    public ProfessorTitular(int horasSemanais, String matricula, String nome, double salarioBase) {
        super(horasSemanais, matricula, nome, salarioBase);
    }

    @Override
    public boolean elegivelAfastamento() {
        return getHorasSemanais() >= 20;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + 1200.00;
    }
}