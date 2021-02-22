package polimorfismo_modulo8_banco;

public class ContaPoupanca extends Banco{

    private double taxaDeJuros;
    private int diaAniversario;

    public ContaPoupanca(String nome, int numero, double saldo, int diaAniversario, double taxaDeJuros){
        super(nome, numero, saldo);
        this.diaAniversario = diaAniversario;
        this.taxaDeJuros = taxaDeJuros;
    }
    @Override
	public String toString() {
		return "ContaPoupanca " + 
                super.toString() + 
                " diaAniversario=" + 
                diaAniversario + 
                " taxaDeJuros=" + 
                taxaDeJuros + 
                " rendimento=R$" + 
                rendimento();
	}

    public double rendimento(){
        if(this.diaAniversario == 20){
            return this.saldo * this.taxaDeJuros;
        }else{
            return 0;
        }
    }

    public double getSaldo(){
        return this.saldo + rendimento();
    }

    public boolean sacar(double valorSaque){
        if(this.saldo >= Math.abs(valorSaque)){
            this.saldo-=valorSaque;
            return true;
        }else{
            System.out.println("O saque no valor de " + valorSaque + " é inválido");
            return false;
        }
    }


}