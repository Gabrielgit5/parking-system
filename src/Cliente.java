public class Cliente {
    private String cpf;
    private String nome;
    private Data dataCadastro; //isso se chama composição (uma classe usando a outra)

    public Data getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Data dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String cpf, String nome, Data dataCadastro){
        this.cpf = cpf;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }
}
