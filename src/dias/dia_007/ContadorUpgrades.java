package dias.dia_007;

import javax.swing.*;

public class ContadorUpgrades {
    public static void main(String[] args) {
        // Desafio 7 - Contador Automático de Upgrades

        // Coletando dados:
        String clientName = JOptionPane.showInputDialog("Digite o nome do cliente:").trim();
        String hardwareModel = JOptionPane.showInputDialog("Digite o nome do modelo do Equipamento:").trim();
        String componentName1 = JOptionPane.showInputDialog("Digite o nome do componente 1:").trim();
        String priceComponent1String = JOptionPane.showInputDialog("Digite o valor do (" + componentName1 + ") trocado:")
                .trim().replace(',', '.');
        String componentName2 = JOptionPane.showInputDialog("Digite o nome do componente 2:").trim();
        String priceComponent2String = JOptionPane.showInputDialog("Digite o valor do (" + componentName2 + ") trocado:")
                .trim().replace(',','.');
        String clientVIPString = JOptionPane.showInputDialog("O cliente é VIP?:").trim().toLowerCase();

        // Tratando os Dados Iniciais:
        double priceComponent1 = Double.parseDouble(priceComponent1String);
        double priceComponent2 = Double.parseDouble(priceComponent2String);

        // Tratando calculos:
        int codeProtocol = (int) (priceComponent1 + priceComponent2) / 3; // Protocolo extrairo através dessa conta.
        double grossPrice = priceComponent1 + priceComponent2;
        double installationFee = Math.sqrt(grossPrice) * 5;
        double initialTotalPrice = installationFee + grossPrice;

        // Tratando Lógica de Negócios:
        boolean clientVIP = clientVIPString.equals("sim");
        boolean discount = clientVIP && initialTotalPrice > 400.00 ? true : false;
        double finalPrice = discount ? initialTotalPrice - 50.0 : initialTotalPrice;
        boolean priority = clientVIP && finalPrice > 500.0 ? true : false;
        String statusService = priority ? "Fila Expressa" : "Fila Comum";

        // Exibindo:
        System.out.println("=======================================================");
        System.out.printf("SARAIVA HARDWARE - PROTOCOLO N° %d\n", codeProtocol);
        System.out.println("=======================================================");
        System.out.printf("Cliente: %s\n", clientName);
        System.out.printf("Equipamento: %s\n", hardwareModel);
        System.out.println("--------------------------------------------------------");
        System.out.println("COMPONENTES TROCADOS:");
        System.out.printf("%s: %.2f\n", componentName1, priceComponent1);
        System.out.printf("%s: %.2f\n", componentName2, priceComponent2);
        System.out.println("--------------------------------------------------------");
        System.out.println("VALORES:");
        System.out.printf("Valor dos componentes: %.2f\n", grossPrice);
        System.out.printf("Taxa de instalaçao: %.2f\n", installationFee);
        System.out.printf("Preço Final Calculado: %.2f\n", finalPrice);
        System.out.println("--------------------------------------------------------");
        System.out.printf("Status do Atendimento: %s\n", statusService);
        System.out.println("=======================================================");
    }
}
