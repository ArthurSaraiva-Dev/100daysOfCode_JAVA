package dias.dia_013;

import javax.swing.*;

public class GerenciadorTelecom {
    public static void main(String[] args) {
        // Desafio 13 - Sistema de Geração e Gerenciamento de Número

        int entrada = 0;
        LinhaTelefonica linha = null; // Começa nulo até o cadastro do cliente


        do {
            // Coletando Dados
            String opcaoString = JOptionPane.showInputDialog("Digite a opção desejada\n" +
                    "1 - Iniciar Linha Telefonica\n" +
                    "2 - Ativar Plano\n" +
                    "3 - Efetuar Recarga\n" +
                    "4 - Exibir Status da Conta\n" +
                    "5 - Retatório de Conta.\n" +
                    "6 - Sair.");

            // Tratando Erro
            if(opcaoString == null){
                entrada = 6;
                continue;
            }

            entrada = Integer.parseInt(opcaoString);

            if (entrada >= 2 && entrada <= 5 && linha == null) {
                JOptionPane.showMessageDialog(null,
                        "[ERRO] Você precisa registrar o cliente (Opção 1) primeiro!");
                continue;
            }

            switch (entrada){
                case 1:
                    String entradaNomeCliente = JOptionPane.showInputDialog("Digite seu nome: ");
                    if (entradaNomeCliente != null && !entradaNomeCliente.trim().isEmpty()){
                        linha = new LinhaTelefonica(entradaNomeCliente.trim());
                        JOptionPane.showMessageDialog(null, linha.gerarNumero());
                        break;
                    }
                case 2:
                   JOptionPane.showMessageDialog(null, linha.ativarPlano());
                    break;
                case 3:
                    String entradaValorRecarga = JOptionPane.showInputDialog("Digite o valor da recarga:");
                     if (entradaValorRecarga != null) {
                        double valorRecarga = Double.parseDouble(entradaValorRecarga);
                        JOptionPane.showMessageDialog(null, linha.recarga(valorRecarga));
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Status do plano: " + linha.exibirStatus());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, linha.exibirRelatorio());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,"SAINDO...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "[ENTRADA INVÁLIDA] VOLTE AO MENU!");
                    break;
            }

        }while (entrada != 6);
    }
}
