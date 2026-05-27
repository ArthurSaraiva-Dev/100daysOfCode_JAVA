package dias.dia_005;

public class OtimizadorServidor {
    public static void main(String[] args) {
        // Desafio 05/100
        // Otimizador de Servidor

        // Operadores Aritméticos
        // Função Math

        // SSD Antigo
        double oldSSDBase = Math.pow(2, 10);
        double oldSSD = Math.floor(240.76);

        // SSD Novo
        double newSSD = Math.floor(512.82);

        // Somando os tamanhos
        double totalStorage = oldSSD + newSSD;

        // Divisão de Backup
        double createBackup = totalStorage / 3;
        double createBackupRest = totalStorage % 3;

        // Exibindo
        System.out.println("====== SISTEMA DE INFRAESTRUTURA ======");
        System.out.printf("Espaço Base Disco Antigo (2^10): %.1f MB \n", oldSSDBase);
        System.out.printf("Espaço Total Disco Antigo: %.1f GB \n", oldSSD);
        System.out.printf("Espaço do Novo SSD (Arredondado) : %.1f GB\n", newSSD);
        System.out.println("------------------------------------------------------");
        System.out.printf("Espaço Total do Sistema: %.1f GB \n", totalStorage);
        System.out.printf("Espaço por Disco de Backup: %.1f GB \n", createBackup);
        System.out.printf("Espaço restante: %.1f GB \n", createBackupRest);
        System.out.println("========================================================");
    }
}
