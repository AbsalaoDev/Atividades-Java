package AtividadesHeranca;

public class MedicoCirurgiao extends Medico {

    public MedicoCirurgiao(String crm, String nome, int idade, double salario) {
        super(crm, nome, idade, salario);
    }

    @Override
    public boolean medicoAposentado() {
        return idade > 50;
    }

    @Override
    public double valorAposentadoria() {
        return salario * 0.80 + 800;
    }
}