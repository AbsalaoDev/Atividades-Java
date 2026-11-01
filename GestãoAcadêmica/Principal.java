package GestãoAcadêmica;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Universidade universidade = new Universidade();

        int opcao = 0;

        do {
            System.out.println("\n===== UNIVERSIDADE =====");
            System.out.println("1 - Cadastrar professor");
            System.out.println("2 - Buscar professor");
            System.out.println("3 - Remover professor");
            System.out.println("4 - Listar professores");
            System.out.println("5 - Estatísticas");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:
                        System.out.println("\n1 - Professor Titular");
                        System.out.println("2 - Professor Substituto");
                        System.out.print("Escolha o tipo: ");

                        int tipo = Integer.parseInt(sc.nextLine());

                        if (tipo != 1 && tipo != 2) {
                            System.out.println("Tipo inválido!");
                            break;
                        }

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Matrícula: ");
                        String matricula = sc.nextLine();

                        System.out.print("Horas semanais: ");
                        int horas = Integer.parseInt(sc.nextLine());

                        System.out.print("Salário base: ");
                        double salario = Double.parseDouble(sc.nextLine().replace(",", "."));

                        Professores professor;

                        if (tipo == 1) {
                            professor = new ProfessorTitular(horas, matricula, nome, salario);
                        } else {
                            professor = new ProfessorSubstituto(horas, matricula, nome, salario);
                        }

                        universidade.adicionarProfessor(professor);

                        System.out.println("Professor cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Digite a matrícula: ");
                        String busca = sc.nextLine();

                        Professores encontrado = universidade.buscarProfessor(busca);

                        if (encontrado != null) {
                            System.out.println("\nNome: " + encontrado.getNome());
                            System.out.println("Matrícula: " + encontrado.getMatricula());
                            System.out.println("Horas semanais: " + encontrado.getHorasSemanais());
                            System.out.println("Salário base: R$ " + encontrado.getSalarioBase());
                            System.out.println("Elegível para afastamento: "
                                    + (encontrado.elegivelAfastamento() ? "Sim" : "Não"));
                            System.out.println("Salário final: R$ " + encontrado.calcularSalarioFinal());
                        } else {
                            System.out.println("Professor não encontrado!");
                        }
                        break;

                    case 3:
                        System.out.print("Digite a matrícula do professor: ");
                        String matriculaRemover = sc.nextLine();

                        if (universidade.buscarProfessor(matriculaRemover) != null) {
                            universidade.removerProfessor(matriculaRemover);
                            System.out.println("Professor removido com sucesso!");
                        } else {
                            System.out.println("Professor não encontrado!");
                        }
                        break;

                    case 4:
                        universidade.listarProfessores();
                        break;

                    case 5:
                        System.out.println("Total de professores criados: "
                                + Professores.getTotalProfessores());
                        break;

                    case 6:
                        System.out.println("Encerrando o programa...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido!");
            }

        } while (opcao != 6);

        sc.close();
    }
}