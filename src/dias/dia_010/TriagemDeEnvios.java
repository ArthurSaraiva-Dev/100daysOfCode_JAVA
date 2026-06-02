package dias.dia_010;

import javax.swing.*;

public class TriagemDeEnvios {
    public static void main(String[] args) {
        // Desafio 10 - Sistema de Roteamento de Entregas
        // Taxa Sudeste = 15,00
        // Taxa Nordeste = 30,00
        // Taxa Sul = 20,00


        // Para o while detectar a variável
        int entrada = 0;

        // Lógica
        do{
            // Coletando Dados
            String entradaString = JOptionPane.showInputDialog("Digite a região desejada!\n" +
                    "1 - Região Sudeste\n2 - Região Nordeste\n3 - Região Sul\n4 - Encerrar Expediente")
                    .trim().replace(',','.');

            // Tratando entrada
            entrada = Integer.parseInt(entradaString);

            switch (entrada){
                case 1:
                    System.out.println("=== LOGÍSTICA DE DISTRIBUIÇÃO ROBUST-IN ===");
                    System.out.println("--- Processamento Lote: Região Sudeste ---");
                    for (int pacote = 1; pacote <= 5; pacote++){
                        String valorProdutoString = JOptionPane.showInputDialog("Digite o valor do pacote [" + pacote + "]")
                                .trim().replace(',','.');
                        double valorProduto = Double.parseDouble(valorProdutoString);
                        double taxaSudeste = 15.0;

                        if (valorProduto <= 0){
                            System.out.println(">>> AVISO: Código 0 detectado. " +
                                    "Etiqueta Ilegível. Pulando Pacote...\n");
                            continue;
                        } else if (valorProduto >= 999) {
                            valorProduto += taxaSudeste;
                            System.out.printf("[Pacote %d] PACOTE DE ALTO VALOR!" +
                                            " Valor total (com Frete R$%.2f): R$%.2f\n",
                                    pacote, taxaSudeste,valorProduto);
                            System.out.println(">>> ALARME: PARANDO ESTEIRA PARA VERIFICAÇÃO DE PACOTE COM ALTO VALOR!");
                            break;
                        } else if (valorProduto >= 300) {
                            valorProduto += taxaSudeste;
                            double descontoValorAlto = valorProduto * 0.10;
                            valorProduto -= descontoValorAlto;
                            System.out.printf("[Pacote %d] VALOR ALTO! Cupom 10%% aplicado! Valor total (com Frete R$%.2f): R$%.2f\n",
                                    pacote, taxaSudeste,valorProduto);
                        }else {
                            valorProduto += taxaSudeste;
                            System.out.printf("[Pacote %d] Processado. Valor total (com Frete R$%.2f): R$%.2f\n",
                                    pacote, taxaSudeste, valorProduto);
                        }
                        if (pacote == 5)
                            System.out.println("Lote finalizado com sucesso. Retornando para o painel principal.");
                    }
                break;
                case 2:
                    System.out.println("=== LOGÍSTICA DE DISTRIBUIÇÃO ROBUST-IN ===");
                    System.out.println("--- Processamento Lote: Região Nordeste ---");
                    for (int pacote = 1; pacote <= 5; pacote++){
                        String valorProdutoString = JOptionPane.showInputDialog("Digite o valor do pacote [" + pacote + "]")
                                .trim().replace(',','.');
                        double valorProduto = Double.parseDouble(valorProdutoString);
                        double taxaNordeste = 30.0;

                        if (valorProduto <= 0){
                            System.out.println(">>> AVISO: Código 0 detectado. " +
                                    "Etiqueta Ilegível. Pulando Pacote...\n");
                            continue;
                        } if (valorProduto >= 999) {
                            valorProduto += taxaNordeste;
                            System.out.printf("[Pacote %d] PACOTE DE ALTO VALOR!" +
                                            " Valor total (com Frete R$%.2f): R$%.2f\n",
                                    pacote, taxaNordeste,valorProduto);
                            System.out.println("PARANDO ESTEIRA PARA VERIFICAÇÃO DE PACOTE COM ALTO VALOR!");
                            break;
                        } else if (valorProduto >= 300) {
                            valorProduto += taxaNordeste;
                            double descontoValorAlto = valorProduto * 0.10;
                            valorProduto -= descontoValorAlto;
                            System.out.printf("[Pacote %d] VALOR ALTO! Cupom 10%% aplicado! Valor total (com Frete R$%.2f): R$%.2f\n",
                                    pacote, taxaNordeste,valorProduto);
                        }else {
                            valorProduto += taxaNordeste;
                            System.out.printf("[Pacote %d] Processado. Valor total (com Frete R$%.2f): R$%.2f\n",
                                    pacote, taxaNordeste, valorProduto);
                        }

                        if (pacote == 5)
                            System.out.println("Lote finalizado com sucesso. Retornando para o painel principal.");
                    }
                break;
                case 3:
                    System.out.println("=== LOGÍSTICA DE DISTRIBUIÇÃO ROBUST-IN ===");
                    System.out.println("--- Processamento Lote: Região Sul ---");
                    for (int pacote = 1; pacote <= 5; pacote++){
                        String valorProdutoString = JOptionPane.showInputDialog("Digite o valor do pacote [" + pacote + "]")
                                .trim().replace(',','.');
                        double valorProduto = Double.parseDouble(valorProdutoString);
                        double taxaSul = 20.0;

                        if (valorProduto <= 0){
                            System.out.println(">>> AVISO: Código 0 detectado. " +
                                    "Etiqueta Ilegível. Pulando Pacote...\n");
                            continue;
                        } else if (valorProduto >= 999) {
                            valorProduto += taxaSul;
                            System.out.printf("[Pacote %d] PACOTE DE ALTO VALOR!" +
                                            " Valor total (com Frete R$%.2f): R$%.2f\n",
                                    pacote, taxaSul,valorProduto);
                            System.out.println("PARANDO ESTEIRA PARA VERIFICAÇÃO DE PACOTE COM ALTO VALOR!");
                            break;
                        } else if (valorProduto >= 300) {
                            valorProduto += taxaSul;
                            double descontoValorAlto = valorProduto * 0.10;
                            valorProduto -= descontoValorAlto;
                            System.out.printf("[Pacote %d] VALOR ALTO! Cupom 10%% aplicado! Valor total (com Frete R$%.2f): R$%.2f\n",
                                    pacote, taxaSul,valorProduto);
                        }else{
                            valorProduto += taxaSul;
                            System.out.printf("[Pacote %d] Processado. Valor total (com Frete R$%.2f): R$%.2f\n",
                                pacote, taxaSul,valorProduto);
                        }
                        if (pacote == 5)
                            System.out.println("Lote finalizado com sucesso. Retornando para o painel principal.");
                    }
                break;
                case 4:
                    System.out.println("Saindo...");
                break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }while (entrada != 4);

    }
}
