package polimorfismo_modulo8_banco;

public abstract class Banco {

    private String nome;
    private int numero;
    protected double saldo;

    public Banco(String nome, int numero, double saldo){
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "nome=" + nome + " numero=" + numero + " saldo=" + saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public abstract double getSaldo();

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean sacar(double valorSaque);

    public void depositar(double valorDeposito){
        this.saldo = this.saldo  + valorDeposito;
    }

    //METODO PADRAO DE TRANSFERENCIA ENTRE CONTAS
    public void transferencia(double valorTransferencia, Banco contaDestino){
        if (valorTransferencia <= saldo){
            this.setSaldo(saldo - valorTransferencia);
            contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);
        }else {
            System.out.println("Saldo insuficiente, seu saldo é: " + this.getSaldo() + " valor solicitado de: " + valorTransferencia);
        }
    
    } 
    
}
