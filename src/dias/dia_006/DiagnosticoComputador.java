package dias.dia_006;

import javax.swing.*;

public class DiagnosticoComputador {
    public static void main(String[] args) {
        // Desafio diário: 06/100

        // Desafio do Dia: O Sistema de Diagnóstico Automatizado

        // Sua oficina cresceu e agora você quer
        // criar um sistema que avalia automaticamente a situação de um computador
        // que entrou para conserto e decide se ele precisa de atenção urgente e qual a prioridade do atendimento.

        // Capturando dados para Variáveis
        String stringTempoLigadoH = JOptionPane.showInputDialog("Digite o tempo de teste (Em Horas): \n")
                .trim();

        String stringTemperaturaCPU = JOptionPane.showInputDialog("Digite a temperatura da CPU nos testes (°C): \n")
                .trim().replace(',','.');

        String stringGarantia = JOptionPane.showInputDialog("O cliente tem garantia? (Digite \"sim\" ou \"não\": \n")
                .trim();

        String stringTempoLigadoHFinal = JOptionPane.showInputDialog("Digite o tempo ligado na bancada (Em horas): \n")
                .trim().replace(',','.');

        // Tratando dados Capturados
        int tempoLigadoH = Integer.parseInt(stringTempoLigadoH);
        int tempoLigadoHFinal = Integer.parseInt(stringTempoLigadoHFinal);
        tempoLigadoHFinal += tempoLigadoH;

        Double temperaturaCPU = Double.parseDouble(stringTemperaturaCPU);
        temperaturaCPU++; // Referente a possível variação

        String temGarantia = stringGarantia.equalsIgnoreCase("sim")
                ? "Garantia Existente" : "Garantia fora do prazo.";

        boolean cooler = (temperaturaCPU >= 80.0) && (tempoLigadoHFinal) > 12;
        String newCooler = cooler ? "SIM" : "NÃO";

        boolean urgencia = cooler;
        String urgenciaStatus = urgencia ? "SIM" : "NÃO";

        String statusProntuario = urgencia ? "Mesa 1 - Prioridade Máxima" : "Mesa 2 - Fila Comum";

        // Exibição
        System.out.println("=== DIAGNÓSTICO DO EQUIPAMENTO ===");

        System.out.printf("Tempo de teste total: %dh\n", tempoLigadoHFinal);
        System.out.printf("Pico de temperatura: %.1f°C\n", temperaturaCPU);
        System.out.printf("O cliente tem garantia?: %s\n", temGarantia);
        System.out.println("---------------------------------------------------");
        System.out.printf("Necessita de novo cooler?: %s\n", newCooler);
        System.out.printf("O atendimento é urgente?: %s\n", urgenciaStatus);
        System.out.printf("Destino do aparelho: %s\n", statusProntuario);
        System.out.println("======================================================");
    }
}
