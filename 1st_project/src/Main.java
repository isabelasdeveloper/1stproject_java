import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String nome = "";
        String conta = "";
        int codigoConta = 1; //Código do tipo de conta
        int codigoTransacao = 0; //Código do tipo de transação
        double saldo = 0;

        while (codigoConta != 0) { //Início do While > abertura da conta
            System.out.print("Vamos começar abrindo sua conta, por favor, digite seu nome: ");
            nome = leitor.nextLine(); //Leitura do nome inserido

            System.out.printf("Vamos lá, %s! \n", nome);
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Investimento");
            System.out.println("0. Cancelar");
            System.out.print("Digite um número: ");
            codigoConta = leitor.nextInt(); //Leitor do código da conta

            if (codigoConta == 0) {
                System.out.println("Cancelado!");
                break;
            } else if (codigoConta == 1 ){
                System.out.println("Conta aberta com sucesso!");
                conta = "Corrente";
                break;
            } else if (codigoConta == 2){
                System.out.println("Conta aberta com sucesso!");
                conta = "Investimento";
                break;
            } else {
                System.out.println("Opção Inválida!");
                break;
            }
        } //Fim do While > abertura da conta

        String menu = """ 
                
                ********************
                Nome: %s
                Conta: %s
                Saldo: R$%.2f
                ********************
                """.formatted(nome, conta, saldo);
        System.out.print(menu); //Menu com informações da conta

        while (saldo != -1) { //Início While das transações
            String transacao = """                    
                    
                    Opções:
                    1. Verificar Saldo
                    2. Depósito
                    3. Transferência
                    4. Sair
                    
                    """;

            System.out.print(transacao);
            System.out.println("Digite a opção desejada: ");
            codigoTransacao = leitor.nextInt(); //Leitor do código da transação

            if (codigoTransacao == 1){

                System.out.printf("Saldo: R$%.2f \n", saldo); //Código para verificação do saldo

            } else if (codigoTransacao == 2) { //Código para depósito

                System.out.print("Valor recebido: ");
                double valor = leitor.nextDouble();
                saldo += valor;
                System.out.printf("Saldo: R$%.2f \n", saldo);

            } else if (codigoTransacao == 3) { //Código para transferência

                System.out.print("Valor a ser enviado: ");
                double valor = leitor.nextDouble();

                    if (valor < saldo) { //Tentativa de transferência sem saldo na conta
                        saldo -= valor;
                        System.out.printf("Saldo: R$%.2f \n", saldo);
                    } else {
                        System.out.println("Saldo Insuficiente!");
                    }

            } else if (codigoTransacao == 4) { //Código para sair
                break;
            } else {
                System.out.println("Código Inválido");
            }

        }

    }
}

