package GestãoAcadêmica;

public abstract class Professores {
    private String matricula;
    private String nome;
    private int horasSemanais;
    private double salarioBase;
    private static int totalProfessores = 0;

    public Professores(int horasSemanais, String matricula, String nome, double salarioBase) {
        this.horasSemanais = horasSemanais;
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = salarioBase;
        totalProfessores++;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(int horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public static int getTotalProfessores() {
        return totalProfessores;
    }

    public abstract boolean elegivelAfastamento();

    public abstract double calcularSalarioFinal();
}