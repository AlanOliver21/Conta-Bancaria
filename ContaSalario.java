package polimorfismo_modulo8_banco;

public class ContaSalario extends Banco implements Tributavel {

    private int limiteSaque;

    public ContaSalario(String nome, int numero, double saldo, int limiteSaque){
        super(nome, numero, saldo);
        this.limiteSaque = limiteSaque;
    }

    @Override
	public String toString() {
		return "ContaSalario " + 
                super.toString() + 
                " limiteSaque=" + 
                limiteSaque + 
                " Tributo=R$" + 
                tributo();
	}
    
    public double getSaldo(){
        return this.saldo - tributo();
    }

    public boolean sacar(double valorSaque){
        if(this.limiteSaque > 0 && Math.abs(valorSaque) < this.saldo){
            this.limiteSaque --;
            this.saldo -= valorSaque;
            return true;
        }else{
            System.out.println("Limite de saques excedido");
            return false;
        }
    }

    //MÉTODO TRIBUTO REFERENTE A INTERFACE TRIBUTAVEL
    public double tributo(){
        return this.saldo * 0.001;
    }
    //


}
