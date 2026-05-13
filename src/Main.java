import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>(); //lista dinâmica
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
                cadastrarCliente(clientes, teclado);
            }

            if (opcao == 2) {
                pesquisarCliente(clientes, teclado);
            }


            if (opcao == 3) {
                atualizarCliente(clientes, teclado);
            }

            if (opcao == 4) {
                excluirCliente(clientes, teclado);
            }


            if (opcao == 5) {
                registrarEntradaVeiculo(veiculos, clientes, teclado);
            }


            if (opcao == 6) {
                registrarSaidaVeiculo(veiculos, teclado);
            }

            if (opcao == 7) {
                veiculosNoEstacionamento(veiculos);
            }


            if (opcao == 8) {
                relatorioMensal(veiculos, teclado);
            }


            if (opcao == 9) {
                listarClientes(clientes);
            }
        }
        teclado.close();
    }
    public static void cadastrarCliente(ArrayList<Cliente> clientes, Scanner teclado) {

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

    public static void pesquisarCliente(ArrayList<Cliente> clientes, Scanner teclado) {

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
            System.out.println("Cadastro: "
                    + encontrado.getDataCadastro().mostrarData());
        }
    }
    public static void atualizarCliente(ArrayList<Cliente> clientes, Scanner teclado) {

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
    public static void excluirCliente(ArrayList<Cliente> clientes, Scanner teclado) {

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
    public static void registrarEntradaVeiculo(
            ArrayList<Veiculo> veiculos,
            ArrayList<Cliente> clientes,
            Scanner teclado) {

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

        Veiculo veiculo = new Veiculo(
                placa,
                modelo,
                entrada,
                clienteEncontrado
        );

        veiculos.add(veiculo);

        System.out.println("Veículo registrado com sucesso!");
    }
    public static void registrarSaidaVeiculo(
            ArrayList<Veiculo> veiculos,
            Scanner teclado) {

        teclado.nextLine();

        System.out.println("Digite a placa:");
        String placa = teclado.nextLine();

        Veiculo encontrado = null;

        for (Veiculo v : veiculos) {

            if (v.getPlaca().equals(placa)
                    && v.getSaida() == null) {

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

            Data saida = new Data(
                    dia,
                    mes,
                    ano,
                    hora,
                    minuto
            );

            encontrado.registrarSaida(saida);

            System.out.println(
                    "Valor pago: R$ "
                            + encontrado.getValorPago()
            );
        }
    }
    public static void veiculosNoEstacionamento(
            ArrayList<Veiculo> veiculos) {

        System.out.println("\n--- VEÍCULOS NO ESTACIONAMENTO ---");

        for (Veiculo v : veiculos) {

            if (v.getSaida() == null) {

                System.out.println("Placa: " + v.getPlaca());

                System.out.println("Modelo: " + v.getModelo());

                System.out.println("Entrada: "
                        + v.getEntrada().mostrarData());

                if (v.getCliente() != null) {

                    System.out.println("Cliente: "
                            + v.getCliente().getNome());
                }

                System.out.println("----------------------");
            }
        }
    }
    public static void relatorioMensal(
            ArrayList<Veiculo> veiculos,
            Scanner teclado) {

        System.out.println("Digite o mês:");
        int mes = teclado.nextInt();

        double total = 0;

        for (Veiculo v : veiculos) {

            if (v.getSaida() != null
                    && v.getSaida().getMes() == mes) {

                total += v.getValorPago();
            }
        }

        System.out.println("Total arrecadado: R$ " + total);
    }
    public static void listarClientes(
            ArrayList<Cliente> clientes) {

        System.out.println("\n--- LISTA DE CLIENTES ---");

        for (Cliente c : clientes) {

            System.out.println("Nome: " + c.getNome());

            System.out.println("CPF: " + c.getCpf());

            System.out.println("Cadastro: "
                    + c.getDataCadastro().mostrarData());

            System.out.println("----------------------");
        }
    }


}