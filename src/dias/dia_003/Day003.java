package dias.dia_003;

import java.util.Scanner;

public class Day003 {
    public static void main(String[] args) {
        // Desafio diário: 03/100
        // wrappers
        //Conversão de tipos primitivos
        //Conversão de numérico para string
        //Conversão de string para numérico

        //simular o fechamento de um serviço na oficina. O sistema vai receber os valores como texto
        // (simulando uma entrada de sistema web ou banco de dados),
        // converter para números, aplicar uma taxa e exibir o resultado final formatado.

        // Scanner
        Scanner entrada = new Scanner(System.in);

        // Declarando variáveis e iniciando
        System.out.println("=== Calculadora de Serviço Parcelado ===");

        System.out.print("Digite o valor do serviço:");
        String valorServicoString = entrada.nextLine().replace(',','.');

        System.out.print("\nDigite a quantidade de parcelas desejadas:");
        String parcelasString = entrada.nextLine().replace(',','.');

        // Tratando entradas
        double valorServico = Double.parseDouble(valorServicoString);
        int parcelas = Integer.parseInt(parcelasString);

        // Taxa constante
        final double taxa = 15.00;

        // Calculando
        Double valorCTaxa = valorServico + taxa;
        double valorParcela = valorCTaxa / 3;

        // Tratando saídas
        String valorTotal = valorCTaxa.toString();
        int valorParcelaAprox = (int) valorParcela;

        // Exibindo
        System.out.println("=== FECHAMENTO DE ORDEM DE SERVIÇO ===");
        System.out.printf("\nValor total (com taxa de percelamento): R$ %s", valorTotal);
        System.out.printf("\nQuantidade de Parcelas: R$ %d", parcelas);
        System.out.printf("\nValor por parcela (sem centavos): R$ %d", valorParcelaAprox);
        System.out.print("\n=====================================================");
        entrada.close();
    }
}
