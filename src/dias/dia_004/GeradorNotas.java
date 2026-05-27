package dias.dia_004;

import java.util.Scanner;

public class GeradorNotas {
    public static void main(String[] args) {
        // Desafio diário: 04/100
        // Wrappers
        // Conversão de tipos primitivos
        // Conversão de numérico para string
        // Conversão de string para numérico
        // Import
        // Console (Scanner)
        // Tipo String


        Scanner entrada = new Scanner(System.in);

        // iniciando software
        System.out.println("=== SARAIVA HARDWARE - GERAÇÃO DE NOTA ===");

        // Coletando dados
        System.out.println("Nome do Cliente: ");
        String nome = entrada.nextLine();

        System.out.println("Serviço realizado: ");
        String servico = entrada.nextLine();

        System.out.println("Valor das peças: ");
        String valorPecas = entrada.nextLine().replace(',','.');

        System.out.println("Valor da mão de obra: ");
        String valorMaoDeObra = entrada.nextLine().replace(',','.');

        System.out.println("Digite a porcentagem de desconto (Ex: 10) : ");
        String porcentagemDesconto = entrada.nextLine().replace(',','.');

        // Tratamento
        double valorPecasT = Double.parseDouble(valorPecas); // Convertendo String to Double
        double valorMaoDeObraT = Double.parseDouble(valorMaoDeObra); // Convertendo String to Double
        double porcentagemDescontoT = Double.parseDouble(porcentagemDesconto); // Convertendo String to Double

        double subtotal = valorPecasT + valorMaoDeObraT; // Valor total
        double desconto = (subtotal / 100)  * porcentagemDescontoT; // Desconto
        double valorCDesconto = subtotal - desconto; // Valor com desconto
        int valorNoCents = (int) valorCDesconto; // CAST

        // Exibindo
        System.out.println("====== NOTA FISCAL DA OFICINA ======");
        System.out.printf("Cliente: %s\n", nome);
        System.out.printf("Serviço: %s\n", servico);
        System.out.println("-------------------------------------");
        System.out.printf("Subtotal: R$ %.2f\n", subtotal);
        System.out.printf("Valor Final (desconto de R$ %.2f): R$ %.2f\n", desconto, valorCDesconto);
        System.out.printf("Para pagamento em cédulas (sem moedas): R$ %d\n", valorNoCents);
        System.out.println("===============================================");

        entrada.close();
    }
}
