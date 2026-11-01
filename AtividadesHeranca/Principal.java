package AtividadesHeranca;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);

        Hospital hospital = new Hospital();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DO HOSPITAL =====");
            System.out.println("1 - Cadastrar Medico");
            System.out.println("2 - Buscar Medico pelo CRM");
            System.out.println("3 - Remover Medico pelo CRM");
            System.out.println("4 - Listar Todos os Medicos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = tc.nextInt();
            tc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Medico Cirurgiao");
                    System.out.println("2 - Medico Auxiliar");
                    System.out.print("Escolha o tipo: ");

                    int tipo = tc.nextInt();
                    tc.nextLine();

                    System.out.print("Digite o CRM: ");
                    String crm = tc.nextLine();

                    System.out.print("Digite o nome: ");
                    String nome = tc.nextLine();

                    System.out.print("Digite a idade: ");
                    int idade = tc.nextInt();

                    System.out.print("Digite o salario: ");
                    double salario = tc.nextDouble();
                    tc.nextLine();

                    Medico medico;

                    if (tipo == 1) {

                        medico = new MedicoCirurgiao(
                                crm, nome, idade, salario);

                    } else if (tipo == 2) {

                        medico = new MedicoAuxiliar(
                                crm, nome, idade, salario);

                    } else {

                        System.out.println("Tipo invalido.");
                        break;
                    }

                    hospital.adicionarMedico(medico);

                    System.out.println("Medico cadastrado com sucesso!");

                    break;

                case 2:

                    System.out.print("Digite o CRM do medico: ");
                    String crmBusca = tc.nextLine();

                    Medico encontrado = hospital.buscarMedico(crmBusca);

                    if (encontrado != null) {

                        System.out.println("\n===== MEDICO ENCONTRADO =====");
                        System.out.println(encontrado);
                        System.out.println("Aposentado: " +
                                (encontrado.medicoAposentado()
                                        ? "Sim" : "Nao"));
                        System.out.println("Valor da aposentadoria: R$ " +
                                encontrado.valorAposentadoria());

                    } else {

                        System.out.println("Medico nao encontrado.");
                    }

                    break;

                case 3:

                    System.out.print("Digite o CRM do medico que deseja remover: ");
                    String crmRemover = tc.nextLine();

                    if (hospital.removerMedico(crmRemover)) {

                        System.out.println("Medico removido com sucesso!");

                    } else {

                        System.out.println("Medico nao encontrado.");
                    }

                    break;

                case 4:

                    hospital.listarMedicos();

                    break;

                case 5:

                    System.out.println("Saindo do sistema...");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 5);

        tc.close();
    }
}