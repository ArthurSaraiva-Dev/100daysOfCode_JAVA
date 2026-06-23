package dias.dia_016;

import javax.swing.*;

public class SistemaSaraivaMob {
    public static void main(String[] args) {
        // Desafio 16/100: O Validador de Catraca da SaraivaMob
        
        int entrada = 0;
        CartaoTransporte cartao1 = null;
        
        do {
            String entradaString = JOptionPane.showInputDialog("=== MENU SARAIVAMOB ===\n" +
                    "1 - Emitir Cartão\n" +
                    "2 - Recarregar\n" +
                    "3 - Passar na Catraca\n" +
                    "4 - Testar Bloqueio (Referência)\n" +
                    "5 - Status do Cartão\n" +
                    "6 - Desbloquear Cartão\n" +
                    "7 - Sair");

            // Tratamento de Entradas vazias
            if (entradaString == null || entradaString.isEmpty()){
                entrada = 7;
                continue;
            }

            // Conversão de Tipos
            entrada = Integer.parseInt(entradaString);

            if (entrada != 1 && cartao1 == null) {
                JOptionPane.showMessageDialog(null,
                        "[ERRO] VOCÊ PRECISA CADASTRAR UM CARTÃO (OPÇÃO 1)");
                continue;
            }
            
            switch (entrada){
                case 1:
                    String nome = JOptionPane.showInputDialog("DIGITE SEU NOME:");
                    String tipoCartao = JOptionPane.showInputDialog("DIGITE O TIPO DO SEU CARTÃO:\n" +
                            "1 - Estudante\n" +
                            "2 - Comum.");
                    if (nome != null && tipoCartao != null && !nome.isEmpty() && !tipoCartao.isEmpty()){
                        int inputTipoCartao = Integer.parseInt(tipoCartao);
                        switch (inputTipoCartao){
                            case 1:
                                cartao1 = new CartaoTransporte(nome, "Estudante");
                            break;
                            case 2:
                                cartao1 = new CartaoTransporte(nome, "Comum");
                                break;
                        }
                        JOptionPane.showMessageDialog(null, "Cartão Cadastrado com Sucesso!");
                    } else{
                        JOptionPane.showMessageDialog(null,
                                "[ERRO] Cadastro cancelado ou dados inválidos.");
                    }
                    break;
                case 2:
                    if (cartao1.status){
                        String valorRecargaString = JOptionPane.showInputDialog("DIGITE O VALOR DA RECARGA");
                        if (valorRecargaString != null && !valorRecargaString.isEmpty()){
                            double valorRecarga = Double.parseDouble(valorRecargaString
                                    .trim().replace(',', '.'));
                            cartao1.recarga(valorRecarga);
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "[ERRO] Compra cancelada ou dados inválidos.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"CARTÃO BLOQUEADO!");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, ValidadorCatraca.passarNaCatraca(cartao1));
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, ValidadorCatraca.alterarTipoCartao(cartao1));
                    JOptionPane.showMessageDialog(null, "No main: O status real na memória: "
                            + (cartao1.status ? "ATIVO" : "BLOQUEADO"));
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, cartao1.exibirRelatorio());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, ValidadorCatraca.desbloquearCartao(cartao1));
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("[ENTRADA INVÁLIDA] VOLTE AO MENU!");
                    break;
            }
        }while (entrada != 7);
    }
}
