package dias.dia_008;

import javax.swing.*;

public class Day008 {
    public static void main(String[] args) {
        // Desafio 8 - Sistema Inteligente de Triagem de Descontos

        // COLETANDO DADOS
        String service = JOptionPane.showInputDialog("Digite o tipo de serviço:\n- Limpeza\n- Formatação\n- Hardware")
                .trim().toLowerCase().replace("formatação","formatacao");
        String servicePriceString = JOptionPane.showInputDialog("Digite o valor do serviço: ")
                .trim().replace(',','.');

        // Tratando dados
        String prioridade;
        double initialServicePrice = Double.parseDouble(servicePriceString);

        if (service.equals("limpeza")){
            prioridade = "Baixa";
        } else if (service.equals("formatacao")) {
            prioridade = "Média";
        } else if (service.equals("hardware")) {
            prioridade = "Alta";
        }else{
            prioridade = "Não identificada";
        }

        // Estrutura de Desconto
        double discount = 0.0;
        String quantDiscount = "0%";

        if (initialServicePrice >= 500.00){
            discount = ((initialServicePrice / 100) * 15); // 15% de desconto
            quantDiscount = "15%";
        }else if (initialServicePrice >= 200.00){
            discount = ((initialServicePrice / 100) * 10); // 10% de desconto
            quantDiscount = "10%";
        }

        double finalServicePrice = initialServicePrice - discount;

        // Exibindo Relatório
        System.out.println("=== SARAIVA HARDWARE - TRIAGEM DE SERVIÇO ===");
        System.out.printf("Tipo de serviço: %s\n", service);
        System.out.printf("Prioridade do Atendimento: %s\n", prioridade);
        System.out.println("---------------------------------------------");
        System.out.printf("Valor Bruto: %.2f\n", initialServicePrice);
        System.out.printf("Desconto Aplicado (%s): %.2f\n", quantDiscount, discount);
        System.out.printf("Valor final com Desconto: %.2f\n", finalServicePrice);
        System.out.println("=================================================");


    }
}
