package polimorfismo_modulo8_banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Tela {

    public static void main (String[] args){

        Scanner input = new Scanner (System.in);

        int opcaoEntrada;
        int tipoOperacao;
        double total = 0;
        Banco contaArmazenada;
        Banco contaRecebedora;     

        //AQUI CONSTA AS CONTAS UTILIZANDO ESTRUTURA DE DADOS COM ARRAYLIST  
        //Sequencia: nome, numero, saldo, variação conforme tipo da conta
        ArrayList<Banco> conta = new ArrayList<>();
        conta.add(new ContaCorrente("Alan", 111, 2000, 2000));
        conta.add(new ContaSalario("Beatriz", 222, 2000, 3));
        conta.add(new ContaPoupanca("Pablo", 333, 3000, 20, 0.05));
        conta.add(new ContaCorrente("Beatriz", 444, 1000, 1000));
        //
        
        do{
            //INICIO DO MENU DOS ACESSOS
            System.out.println("-----------------");
            System.out.println("1.Acessar conta");
            System.out.println("2.Verificar saldo total das contas");
            System.out.println("3.Finalizar");
            System.out.print("Digite a opcao desejada: ");
            opcaoEntrada = input.nextInt();

            switch(opcaoEntrada){
                case 1: 
                    System.out.println("-----------------");
                    System.out.print("Qual o numero da sua conta?: ");
                    int numeroConta = input.nextInt();

                        for (Banco contaProcurada : conta){
                            if (contaProcurada.getNumero() == numeroConta){
                                contaArmazenada = contaProcurada;
                                System.out.println(contaArmazenada);

                                do{
                                    System.out.println("\n1.Sacar\n2.Depositar\n3.Transferir\n4.Ver Saldo\n5.Sair");
                                    System.out.print("Digite a opção desejada: ");
                                    tipoOperacao = input.nextInt();
            
                                    switch(tipoOperacao){
                                        case 1:
                                            System.out.print("Qual valor que deseja sacar?: ");
                                            double valorSaque = input.nextDouble();
                                            contaArmazenada.sacar(valorSaque);
                                            break;
                                        case 2:
                                            System.out.print("Qual o valor do deposito?: ");
                                            double valorDeposito = input.nextDouble();
                                            contaArmazenada.depositar(valorDeposito);
                                            break;
                                        case 3:
                                            System.out.print("Qual o valor da transferencia?: ");
                                            double valorTransferencia = input.nextDouble();
                                            System.out.print("Digite o numero da conta de destino: ");
                                            int contaDestino = input.nextInt();

                                            for (Banco contas : conta){
                                                if (contas.getNumero() == contaDestino){
                                                    contaRecebedora = contas;
                                                    contaArmazenada.transferencia(valorTransferencia, contaRecebedora);
                                                    System.out.println(contaRecebedora); 
                                                }
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Saldo atual da conta e de R$" + contaArmazenada.getSaldo());
                                            System.out.println(contaArmazenada);
                                            break;
                                        case 5:
                                            System.out.println("Saindo...");
                                            break;
                                        default: System.out.println("Opcao invalida");           
                                    }
                                
                                }while(tipoOperacao != 5);
                                                                
                            }
                        }
                    break;

                case 2: 
                // NESTA PARTE CONSTA A SOMATORIA DE VALORES DE TODAS AS CONTAS
                    for (Banco contas : conta){
                         total += contas.getSaldo();
                         System.out.println(contas);
                        }
                        System.out.println("O Saldo total de todas as contas do banco é R$ " + total);
                    break;
                //
                case 3:
                        System.out.println("Finalizando operação...");
                    break;
                default: System.out.println("Opcao invalida");
            }
        }while(opcaoEntrada != 3);

        input.close();      

    }

    
}
