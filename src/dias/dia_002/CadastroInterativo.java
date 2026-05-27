package dias.dia_002;

import java.util.Date;
import java.util.Scanner;

public class CadastroInterativo {
    public static void main(String[] args) {
        // Desafio diário: 02/100

        // Desafio do Dia: Cadastro interativo de Cliente

        //Declarando entrada:
        try (Scanner entrada = new Scanner(System.in)){

            // Variável Data
            Date data = new Date();


            System.out.println("=== SARAIVA HARDWARE - CADASTRO ===");

            System.out.println("Digite o nome do cliente: ");
            String nomeCLiente = entrada.nextLine();

            System.out.println("Digite o modelo do equipamento: ");
            String modelo = entrada.nextLine();

            System.out.println("Digite o valor do orçamento: ");
            double orcamento = entrada.nextDouble();

            // Saída
            System.out.println("\n==== COMPROVANTE DE ENTRADA ====");
            System.out.printf("Cliente: %s\nAparelho: %s\nValor Orçado: %.2f\nData: %s\n", nomeCLiente, modelo, orcamento, data);
            System.out.println("====================================");
        }
    }
}
