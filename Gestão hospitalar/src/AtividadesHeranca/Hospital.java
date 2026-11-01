package AtividadesHeranca;

import java.util.ArrayList;

public class Hospital {

    private ArrayList<Medico> medicos;

    public Hospital() {
        medicos = new ArrayList<>();
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public Medico buscarMedico(String crm) {

        for (Medico medico : medicos) {

            if (medico.getCrm().equals(crm)) {
                return medico;
            }
        }

        return null;
    }

    public boolean removerMedico(String crm) {

        Medico medico = buscarMedico(crm);

        if (medico != null) {
            medicos.remove(medico);
            return true;
        }

        return false;
    }

    public void listarMedicos() {

        if (medicos.isEmpty()) {
            System.out.println("Nenhum medico cadastrado.");
            return;
        }

        for (Medico medico : medicos) {

            System.out.println("----------------------------");
            System.out.println(medico);
            System.out.println("Aposentado: " +
                    (medico.medicoAposentado() ? "Sim" : "Nao"));
            System.out.println("Valor da aposentadoria: R$ " +
                    medico.valorAposentadoria());
        }
    }
}