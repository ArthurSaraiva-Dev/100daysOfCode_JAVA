package dias.dia_009;

import javax.swing.*;

public class SimuladorDeInvestimentos {
    public static void main(String[] args) {
        // Desafio 8 - O Caixa Eletrônico do SaraivaBank


        // COLETANDO DADOS
        String opcaoString = ""; // Variável iniciada para poder ser tratada

        // Iniciando Loop
        do {
            opcaoString = JOptionPane.showInputDialog("=== SaraivaBank ===" +
                    "\n1- Simular Investimento (Poupança)" +
                    "\n2- Extrato de Tarifas" +
                    "\n3- Sair ");
            int opcao = Integer.parseInt(opcaoString);

            if (opcao > 3 || opcao < 1){
                opcaoString = JOptionPane.showInputDialog("*** OPÇÃO INVÁLIDA! ESCOLHA NOVAMENTE ***" +
                        "\n1- Simular Investimento (Poupança)" +
                        "\n2- Extrato de Tarifas" +
                        "\n3- Sair ");
            }

            // Tratando e Calculando Entrada inicial
            if (opcao == 1){
                String valorInicialString = JOptionPane
                        .showInputDialog("Digite o valor Inicial que deseja investir:").trim().replace(',','.');
                String quantMesesString = JOptionPane
                        .showInputDialog("Digite a quantidade de meses que deseja deixar render (1% ano mês):").trim();
                int quantMeses = Integer.parseInt(quantMesesString);
                double valorInicial = Double.parseDouble(valorInicialString);

                    System.out.println("--- SIMULAÇÃO DE RENDIMENTO ---");
                for (int meses = 1; meses <= quantMeses; meses++){
                    double montanteFinal = valorInicial * Math.pow(1 + 0.01, meses);
                    System.out.printf("MÊS %d: R$ %.2f\n",meses,montanteFinal);
                }
            }
            if (opcao == 2) {
                double divida = 60.0;
                double saldo = 150;

                System.out.println("--- COBRANÇA DE TARIFAS ---");
                while (divida > 0){
                    double desconto = 20.0;
                    divida -= desconto;

                    System.out.printf("Desconto de R$%.2f aplicado. Saldo atual: R$ %.2f | Divida Restante: R$ %.2f\n"
                            , desconto, saldo, divida);
                }
            }

        }while(!opcaoString.equals("3"));
        System.out.println("Sessão encerrada pelo usuário. Obrigado por utilizar o SaraivaBank!");
    }
}
