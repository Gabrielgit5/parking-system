import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Pesquisar Cliente");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Registrar Entrada de Veículo");
            System.out.println("6 - Registrar Saída de Veículo");
            System.out.println("7 - Veículos no Estacionamento");
            System.out.println("8 - Relatório por mês");
            System.out.println("9 - Listar Clientes");
            System.out.println("0 - Sair");

            opcao = teclado.nextInt();

            if (opcao == 1) {

                teclado.nextLine();

                System.out.println("Digite o nome do cliente:");
                String nome = teclado.nextLine();

                System.out.println("Digite o CPF:");
                String cpf = teclado.nextLine();

                System.out.println("Dia do cadastro:");
                int dia = teclado.nextInt();

                System.out.println("Mês do cadastro:");
                int mes = teclado.nextInt();

                System.out.println("Ano do cadastro:");
                int ano = teclado.nextInt();

                System.out.println("Hora do cadastro:");
                int hora = teclado.nextInt();

                System.out.println("Minuto do cadastro:");
                int minuto = teclado.nextInt();

                Data dataCadastro = new Data(dia, mes, ano, hora, minuto);

                Cliente cliente = new Cliente(cpf, nome, dataCadastro);

                clientes.add(cliente);

                System.out.println("Cliente cadastrado com sucesso!");
            }

            if (opcao == 2) {

                teclado.nextLine();

                System.out.println("Digite o CPF do cliente:");
                String cpf = teclado.nextLine();

                Cliente encontrado = null;

                for (Cliente c : clientes) {
                    if (c.getCpf().equals(cpf)) {
                        encontrado = c;
                        break;
                    }
                }

                if (encontrado == null) {
                    System.out.println("Cliente não encontrado.");
                } else {
                    System.out.println("Nome: " + encontrado.getNome());
                    System.out.println("CPF: " + encontrado.getCpf());
                    System.out.println("Cadastro: " + encontrado.getDataCadastro().mostrarData());
                }
            }


            if (opcao == 3) {

                teclado.nextLine();

                System.out.println("Digite o CPF do cliente:");
                String cpf = teclado.nextLine();

                Cliente encontrado = null;

                for (Cliente c : clientes) {
                    if (c.getCpf().equals(cpf)) {
                        encontrado = c;
                        break;
                    }
                }

                if (encontrado == null) {
                    System.out.println("Cliente não encontrado.");
                } else {

                    System.out.println("Digite o novo nome:");
                    String novoNome = teclado.nextLine();

                    encontrado.setNome(novoNome);

                    System.out.println("Cliente atualizado com sucesso!");
                }
            }


            if (opcao == 4) {

                teclado.nextLine();
                System.out.println("Digite o CPF do cliente:");
                String cpf = teclado.nextLine();
                Cliente encontrado = null;
                for (Cliente c : clientes) {
                    if (c.getCpf().equals(cpf)) {
                        encontrado = c;
                        break;
                    }
                }
                if (encontrado == null) {
                    System.out.println("Cliente não encontrado.");
                } else {

                    clientes.remove(encontrado);

                    System.out.println("Cliente removido com sucesso!");
                }
            }


            if (opcao == 5) {

                teclado.nextLine();

                System.out.println("Digite a placa do veículo:");
                String placa = teclado.nextLine();

                System.out.println("Digite o modelo:");
                String modelo = teclado.nextLine();

                System.out.println("Dia da entrada:");
                int dia = teclado.nextInt();
                System.out.println("Mês da entrada:");
                int mes = teclado.nextInt();
                System.out.println("Ano da entrada:");
                int ano = teclado.nextInt();
                System.out.println("Hora da entrada:");
                int hora = teclado.nextInt();
                System.out.println("Minuto da entrada:");
                int minuto = teclado.nextInt();
                Data entrada = new Data(dia, mes, ano, hora, minuto);

                teclado.nextLine();

                System.out.println("Digite o CPF do cliente (ou deixe vazio):");
                String cpf = teclado.nextLine();
                Cliente clienteEncontrado = null;

                for (Cliente c : clientes) {
                    if (c.getCpf().equals(cpf)) {
                        clienteEncontrado = c;
                        break;
                    }
                }
                Veiculo veiculo = new Veiculo(placa, modelo, entrada, clienteEncontrado);
                veiculos.add(veiculo);
                System.out.println("Veículo registrado com sucesso!");
            }


            if (opcao == 6) {
                teclado.nextLine();
                System.out.println("Digite a placa:");
                String placa = teclado.nextLine();
                Veiculo encontrado = null;

                for (Veiculo v : veiculos) {
                    if (v.getPlaca().equals(placa) && v.getSaida() == null) {
                        encontrado = v;
                        break;
                    }
                }
                if (encontrado == null) {
                    System.out.println("Veículo não encontrado.");
                } else {

                    System.out.println("Dia da saída:");
                    int dia = teclado.nextInt();
                    System.out.println("Mês da saída:");
                    int mes = teclado.nextInt();
                    System.out.println("Ano da saída:");
                    int ano = teclado.nextInt();
                    System.out.println("Hora da saída:");
                    int hora = teclado.nextInt();
                    System.out.println("Minuto da saída:");
                    int minuto = teclado.nextInt();
                    Data saida = new Data(dia, mes, ano, hora, minuto);
                    encontrado.registrarSaida(saida);
                    System.out.println("Valor pago: R$ " + encontrado.getValorPago());
                }
            }

            if (opcao == 7) {
                System.out.println("\n--- VEÍCULOS NO ESTACIONAMENTO ---");
                for (Veiculo v : veiculos) {
                    if (v.getSaida() == null) {
                        System.out.println("Placa: " + v.getPlaca());
                        System.out.println("Modelo: " + v.getModelo());
                        System.out.println("Entrada: " + v.getEntrada().mostrarData());
                        if (v.getCliente() != null) {
                            System.out.println("Cliente: " + v.getCliente().getNome());
                        }
                    }
                }
            }


            if (opcao == 8) {
                System.out.println("Digite o mês:");
                int mes = teclado.nextInt();
                double total = 0;
                for (Veiculo v : veiculos) {
                    if (v.getSaida() != null && v.getSaida().getMes() == mes) {
                        total += v.getValorPago();
                    }
                }
                System.out.println("Total arrecadado: R$ " + total);
            }


            if (opcao == 9) {
                System.out.println("\n--- LISTA DE CLIENTES ---");
                for (Cliente c : clientes) {
                    System.out.println("Nome: " + c.getNome());
                    System.out.println("CPF: " + c.getCpf());
                    System.out.println("Cadastro: " + c.getDataCadastro().mostrarData());
                }
            }
        }
        teclado.close();
    }
}