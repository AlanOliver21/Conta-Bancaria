package polimorfismo_modulo8_banco;

public class ContaCorrente extends Banco implements Tributavel{
    
    private double chequeEspecial;
    
    public ContaCorrente(String nome, int numero, double saldo, double chequeEspecial){
        super(nome, numero, saldo);
        this.chequeEspecial = chequeEspecial;
        
    }

    @Override
	public String toString() {
		return "ContaCorrente " + 
                super.toString() + 
                " chequeEspecial=" + 
                chequeEspecial + 
                " Tributo=R$" + 
                tributo();
                
	}

    public double getSaldo(){
        return this.saldo + chequeEspecial - tributo();
    }

    @Override
    public boolean sacar(double valorSaque) {
        double saldoDisponivel = getSaldo();
        double saldoAtual;
        if (saldoDisponivel >= Math.abs(valorSaque) ){
            this.saldo = this.saldo - valorSaque;
            saldoAtual = this.saldo;
            if (saldoAtual < 0){
                this.saldo = this.saldo -  valorSaque  - saldoAtual;
                chequeEspecial = chequeEspecial +  saldoAtual;
                return true;
            }else{
                return false;
            }
            
        } else {
            System.out.println("O saque no valor de " + valorSaque + " é inválido");
            return false;   
        }
    }

    //MÉTODO TRIBUTO REFERENTE A INTERFACE TRIBUTAVEL
    public double tributo(){        
        return this.saldo * 0.001;
    }

    //METODO DE TRANSFERENCIA ENTRE CONTAS CONSIDERANDO O ADICIONAL DE CHEQUE ESPECIAL PARA CONTA CORRENTE
    public void transferencia(double valorTransferencia, Banco contaDestino){
        double saldoDisponivel = getSaldo();
        double saldoAtual;
        if(saldoDisponivel >= Math.abs(valorTransferencia)){
            this.saldo = this.saldo - valorTransferencia;
            saldoAtual = this.saldo;
            contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);
            if (saldoAtual < 0){
                this.saldo = this.saldo -  valorTransferencia  - saldoAtual;
                chequeEspecial = chequeEspecial +  saldoAtual;
                contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);     

            } if( saldoDisponivel < valorTransferencia){
                System.out.println("Saldo insuficiente, seu saldo é: " + this.getSaldo() + " valor solicitado de: " + valorTransferencia);
            }
                
        } 

    }
    

}
