package AtividadesHeranca;

public class MedicoAuxiliar extends Medico {

    public MedicoAuxiliar(String crm, String nome, int idade, double salario) {
        super(crm, nome, idade, salario);
    }

    @Override
    public boolean medicoAposentado() {
        return idade > 60;
    }

    @Override
    public double valorAposentadoria() {
        return salario * 0.80;
    }
}