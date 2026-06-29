package dias.dia_017;

import javax.swing.*;
import java.util.Arrays;

public class NavioCargueiro {
    double[][] storageNavio = new double[3][4];
    String[] historicoOperaoes = new String[5];

    String adicionarContainer(int fileira, int coluna, double peso) {
        if (fileira < 0 || fileira > 2 || coluna < 0 || coluna > 3) {
            return "[ERRO!] COORDENADAS INVÁLIDOS! Operação Cancelada.";
        }
        if (storageNavio[fileira][coluna] != 0) {
            return "[ERRO!] Vaga de Contêiner Ocupada.";
        }
        if (peso > 25) {
            return "[ERRO] PESO EM EXCESSO! Carga Cancelada.";
        }

        storageNavio[fileira][coluna] = peso;
        String msgSucesso = "Contêiner Adicionado com Sucesso!";
        String registro = String.format("[SLOT %d,%d] %s (%.1ft)", fileira, coluna, msgSucesso, peso);

        boolean inserido = false;
        for (int i = 0; i < historicoOperaoes.length; i++) {
            if (historicoOperaoes[i] == null) {
                historicoOperaoes[i] = registro;
                inserido = true;
                break;
            }
        }

        if (!inserido) {
            for (int i = 1; i < historicoOperaoes.length; i++) {
                historicoOperaoes[i - 1] = historicoOperaoes[i]; // Copia o 1 pro 0, o 2 pro 1...
            }
            historicoOperaoes[historicoOperaoes.length - 1] = registro; // Coloca o novo no final
        }

        return msgSucesso;
    }

    String calcularPesoTotal(){
        double pesoTotal = 0;
        for (int i = 0; i < storageNavio.length; i++) {
            for (int j = 0; j < storageNavio[i].length; j++) {
                double peso = storageNavio[i][j];
                pesoTotal += peso;
            }
        }
        String historico = null;
        if (historicoOperaoes == null){
            historico = "Sem Atualizações";
        }else {
            historico = String.join("\n", historicoOperaoes);
        }

        return String.format("""
                === RESUMO ===
                Peso Total: %.1ft
                Histórico das Últimas Operações:
                %s""", pesoTotal, historico);
    }

    String exibirMapa(){
            String saida = "";
        for (int i = 0; i < storageNavio.length; i++) {
            for (int j = 0; j < storageNavio[i].length; j++) {
                saida += String.format("[SLOT %d,%d] %.1ft ", i,j,storageNavio[i][j]);
            }
                saida += "\n";
        }
        return saida;
    }

}

