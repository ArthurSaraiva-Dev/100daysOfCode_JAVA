package dias.dia_017;

import javax.swing.*;

public class SistemaPortuario {
    public static void main(String[] args) {
        // Desafio 17/100: Otimizador de Carga de Porto.

        int input = 0;
        NavioCargueiro navio = new NavioCargueiro();

        do {
            String inputString = JOptionPane.showInputDialog("=== MENU PORTUÁRIO ===\n" +
                    "1 - Alocar Contêiner\n" +
                    "2 - Ver Mapa de Cargas\n" +
                    "3 - Resumo e Peso Total\n" +
                    "4 - Sair");

            // Tratamento de Entradas vazias
            if (inputString == null || inputString.isEmpty()){
                input = 4;
                continue;
            }else{
                input = Integer.parseInt(inputString);
            }

            switch (input){
                case 1:
                    String fileiraString = JOptionPane.showInputDialog
                            ("Digite a Fileira Que Deseja Alocar Seu Contêiner [0 a 2]:");
                    String colunaString = JOptionPane.showInputDialog
                            ("Agora Digite a Coluna Desejada [0 a 3]:");
                    String pesoString = JOptionPane.showInputDialog("Digite o Peso do Seu Contêiner");

                    if ((fileiraString == null || fileiraString.isEmpty()) ||
                            (colunaString == null || colunaString.isEmpty()) ||
                            (pesoString == null || pesoString.isEmpty())){
                        JOptionPane.showMessageDialog(null, "[ERRO] DADOS INVÁLIDOS!");
                    }else{
                        int fileira = Integer.parseInt(fileiraString.trim());
                        int coluna = Integer.parseInt(colunaString.trim());
                        double peso = Double.parseDouble(pesoString.trim().replace(',','.'));
                        JOptionPane.showMessageDialog(null,
                                navio.adicionarContainer(fileira, coluna, peso));
                    }
                    break;
                case 2:
                    System.out.println(navio.exibirMapa());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, navio.calcularPesoTotal());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Entrada Inválida!");
                    break;
            }


        }while (input != 4);
    }
}
