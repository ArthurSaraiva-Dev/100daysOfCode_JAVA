package dias.dia_011;

import javax.swing.*;
import java.util.Random;

public class BufferETarifação {
    public static void main(String[] args) {
        // Desafio 11 - O Sistema de Buffer e Tarifação da SaraivaStream

        // Para o while detectar a variável
        int entrada = 0;

        do {
            // Coletando e tratando entrada:
            String entradaString = JOptionPane.showInputDialog("=== SARAIVA STREAM ===\n" +
                    "Digite a opção desejada:\n1 - Perfil do Usuário (Plano & Descontos)\n" +
                    "2 - Maratonar Série (Modo Auto-Play)\n3 - Fechar Aplicativo");

            // Exceção de erro:
            if (entradaString == null){
                entrada = 3;
                continue;
            }

            entrada = Integer.parseInt(entradaString);

            switch (entrada){
                case 1:
                    double mensalidade = 39.90; // Definindo variável para uso posterior
                    double descontoPercentual = 0.0;
                    String nomePlano = "Padrão";

                    String planoString = JOptionPane.showInputDialog("Qual é seu plano?\n" +
                            "1 - Padrão\n2 - Premium");

                    if (planoString == null){
                        entrada = 3;
                        continue;
                    }

                    String tempoString = JOptionPane.showInputDialog("A quanto tempo você utiliza nossos serviços?");

                    if (tempoString == null){
                        entrada = 3;
                        continue;
                    }

                    int plano = Integer.parseInt(planoString);
                    int tempo = Integer.parseInt(tempoString);

                    if (plano == 2){
                        nomePlano = "Premium";
                        mensalidade = 54.90;
                        if (tempo >= 12){
                            descontoPercentual = 0.20; // 20%
                        }
                    } else if (plano == 1 && tempo > 12) {
                        descontoPercentual = 0.10;
                    }

                    // Calculo
                    double mensalidadeFinal = mensalidade - (mensalidade * descontoPercentual);

                    // Exibindo:
                    System.out.println("--- PERFIL DO ASSINANTE ---");
                    System.out.printf("Plano Atual: %s\n", nomePlano);
                    System.out.printf("Valor: R$%.2f\n", mensalidade);
                    System.out.printf("Tempo de plano: %d meses\n", tempo);
                    if (descontoPercentual > 0){
                        System.out.printf("Benefício: Fidelidade ativada!\n" +
                            "Valor da Nova Mensalidade com Desconto: %.2f\n", mensalidadeFinal);
                    }else{
                        System.out.printf("Benefício: Não há desconto\n");
                    }
                    break;
                case 2:
                    // Simulando o Ping do usuário
                    Random ms = new Random();
                        System.out.println("\n--- INICIANDO MARATONA (REPRODUÇÃO AUTOMÁTICA) ---");
                    for (int ep = 1; ep <= 5; ep++) {
                        int latencia = ms.nextInt(300);

                        if (latencia >= 250){
                            System.out.printf("[ERRO CRÍTICO] Limite de espera excedido " +
                                      "no Epsódio %d (Ping: %dms). MARATONA IMTERROMPIDA!\n"
                                    , ep, latencia);
                            break;
                        }

                        if (latencia >= 200){
                            System.out.printf("[Episódio %d] Conexão lenta (Ping: %d). Pulando qualidade baixa\n"
                                    , ep, latencia);
                            continue;
                        }else{
                            System.out.printf("[Episódio %d] Carregado com sucesso em 4K!\n",ep);
                        }
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Saindo!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "OPÇÃO INVÁLIDA!! DIGITE NOVAMENTE AS INFORMAÇÕES.");
                    break;
            }


        }while (entrada != 3);
    }
}
