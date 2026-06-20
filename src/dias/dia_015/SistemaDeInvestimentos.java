package dias.dia_015;

import dias.dia_014.Cidadao;

import javax.swing.*;

public class SistemaDeInvestimentos {
    public static void main(String[] args) {
        // Desafio de Ouro (Dia 15): O Motor de Portfólio.

        // Iniciando Variáveis:
        int entrada = 0;
        AtivoFinanceiro ativo1 = null; // Iniciado para próximos tratamentos

        do {
            String entradaString = JOptionPane.showInputDialog("=== MENU DE ATIVOS ===\n" +
                    "1 - Comprar Ativos.\n" + // Instancia a ação
                    "2 - Simular Flutuação de Mercado.\n" + // Passagem por referência
                    "3 - Testar Alteração de Ticker.\n" + // Passagem por valor
                    "4 - Exibir Extrato Consolidado.\n" +
                    "5 - Sair.");

            // Tratamento de Entradas vazias
            if (entradaString == null || entradaString.isEmpty()){
                entrada = 5;
                continue;
            }

            // Conversão de Tipos
            entrada = Integer.parseInt(entradaString);

            if (entrada != 1 && ativo1 == null) {
                JOptionPane.showMessageDialog(null,
                        "[ERRO] VOCÊ PRECISA COMPRAR UM ATIVO (OPÇÃO 1)");
                continue;
            }

            switch (entrada){
                case 1:
                    String ticker = JOptionPane.showInputDialog("DIGITE O TICKER DO INVESTIMENTO:");
                    String nomeEmpresa = JOptionPane.showInputDialog("DIGITE O NOME DA EMPRESA:");
                    String precoCompraString = JOptionPane.showInputDialog("DIGITE O PREÇO DA COTA:");
                    String quantCotasString = JOptionPane.showInputDialog("DIGITE A QUANTIDADE DE COTAS:");

                    // Tratamento de erro: só cria o objeto se o usuário não cancelou e digitou algo
                    if (ticker != null && nomeEmpresa != null
                            && !ticker.isEmpty() && !nomeEmpresa.isEmpty()
                            && precoCompraString != null && quantCotasString != null
                            && !precoCompraString.isEmpty() && !quantCotasString.isEmpty()) {

                        double precoCompra = Double.parseDouble(precoCompraString
                                .trim().replace(',', '.'));

                        int quantCotas = Integer.parseInt(quantCotasString
                                .trim().replace(',', '.'));

                        ativo1 = new AtivoFinanceiro(ticker, nomeEmpresa, precoCompra, quantCotas);

                        JOptionPane.showMessageDialog(null,
                                "Ativo Comprado Com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "[ERRO] Compra cancelada ou dados inválidos.");
                    }
                    break;
                case 2:
                    String percentualString = JOptionPane.showInputDialog("Digite o Percentual desejado:");
                    if (percentualString != null && !percentualString.isEmpty()){
                        double percentual = Double.parseDouble(percentualString);
                        SimuladorMercado.aplicarOscilacao(ativo1,percentual);
                        JOptionPane.showMessageDialog(null,
                                "Oscilação Aplicada Com Sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "[ERRO] Oscilação cancelada ou dados inválidos.");
                    }
                    break;
                case 3:
                    SimuladorMercado.tentarModificarTicker(ativo1.ticker);
                    JOptionPane.showMessageDialog(null, "Ticker: " + ativo1.ticker);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, ativo1.gerarExtrato());
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("[ENTRADA INVÁLIDA] VOLTE AO MENU!");
                    break;
            }
        }while(entrada != 5);
    }
}
