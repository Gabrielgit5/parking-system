public class Veiculo {
    private static int contador = 1;

    private int codigo;
    private String placa;
    private String modelo;
    private Data entrada;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Data getSaida() {
        return saida;
    }

    public void setSaida(Data saida) {
        this.saida = saida;
    }

    public Data getEntrada() {
        return entrada;
    }

    public void setEntrada(Data entrada) {
        this.entrada = entrada;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    private Data saida;
    private double valorPago;
    private Cliente cliente;


    public Veiculo(String placa, String modelo, Data entrada, Cliente cliente) {
        this.codigo = contador;
        contador++;

        this.placa = placa;
        this.modelo = modelo;
        this.entrada = entrada;
        this.cliente = cliente;

        this.saida = null; //o veículo ainda não saiu do estacionamento, null = não exite ainda
        this.valorPago = 0;
    }

    public void registrarSaida(Data saida) {
        this.saida = saida;

        int horas = saida.getHora() - entrada.getHora();
        valorPago = horas * 1;

        if (cliente != null) {
            valorPago = valorPago * 0.9;
        }
    }
}
