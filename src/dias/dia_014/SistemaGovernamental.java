package dias.dia_014;

import javax.swing.*;

public class SistemaGovernamental {
    public static void main(String[] args) {
        // Desafio 14 - Sistema do Cartório Digital Nacional

        // Iniciando Entrada
        int entrada = 0;


        Cidadao cidadao1 = null; // Inicia nulo para próximos tratamentos

        do {
            String entradaString = JOptionPane.showInputDialog("--- DIGITE A OPÇÃO DESEJADA ---\n" +
                    "1 - Cadastrar Cidadão\n2 - Testar Alteração CPF (Passagem por Valor)\n" +
                    "3 - Teste de Suspensão de Cadastro (Passagem por Referência)\n" +
                    "4 - Exibir relatório do Cidadão\n" +
                    "5 - Sair").trim();

            // Tratamento de Entradas vazias
            if (entradaString == null || entradaString.isEmpty()){
                entrada = 5;
                continue;
            }

            // Conversão de Tipos
            entrada = Integer.parseInt(entradaString);

            if (entrada != 1 && cidadao1 == null) {
                JOptionPane.showMessageDialog(null,
                        "[ERRO] Você precisa cadastrar o cidadão (Opção 1) primeiro!");
                continue;
            }

            switch (entrada){
                case 1:
                    String nomeInput = JOptionPane.showInputDialog("Digite o Nome:");
                    String cpfInput = JOptionPane.showInputDialog("Digite o CPF:");

                    // Tratamento de erro: só cria o objeto se o usuário não cancelou e digitou algo
                    if (nomeInput != null && cpfInput != null && !nomeInput.isEmpty() && !cpfInput.isEmpty()) {
                        cidadao1 = new Cidadao(nomeInput.trim(), cpfInput.trim());
                        JOptionPane.showMessageDialog(null, "Cidadão cadastrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "[ERRO] Cadastro cancelado ou dados inválidos.");
                    }
                    break;
                case 2:
                    System.out.println("=== TESTANDO PASSAGEM POR VALOR (CPF) ===");
                    ModificadorCartorio.tentarMudarCPF(cidadao1.cpf);
                    System.out.println("Dentro do Main: " + cidadao1.cpf);
                    break;
                case 3:
                    System.out.println("=== TESTANDO PASSAGEM POR REFERÊNCIA (OBJETO) ===");
                    ModificadorCartorio.suspenderCadastro(cidadao1);
                    System.out.println("Dentro do Main: " + cidadao1.statusCadastro);
                    break;
                case 4:
                    Cidadao.exibirRelatorioCidadao(cidadao1);
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
