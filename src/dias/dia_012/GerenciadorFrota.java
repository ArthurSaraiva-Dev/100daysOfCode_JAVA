package dias.dia_012;

public class GerenciadorFrota {
    public static void main(String[] args) {
        // Desafio 012: Painel de Controle de Aeronaves (Malha Aérea)
        // Utilizando Classes na prática

        Aviao aviao1 = new Aviao();
        aviao1.modelo = "Boeing 737";
        aviao1.codigoVoo = "B3789";
        aviao1.capacidadePassageiros = 135;
        aviao1.altitudeAtual = 11000.50;
        aviao1.emVoo = true;

        Aviao aviao2 = new Aviao();
        aviao2.modelo = "Embraer E195";
        aviao2.codigoVoo = "A4461";
        aviao2.capacidadePassageiros = 210;
        aviao2.altitudeAtual = 0;
        aviao2.emVoo = false;



        System.out.println("=== SISTEMA DE MONITORAMENTO DE FROTA ===");
        System.out.printf("[AERONAVE 1]\nVoo: %s | Modelo: %s\nCapacidade: %d passageiros" +
                        "\nStatus Atual: %s\nAltitude: %.2f metros\n",
                aviao1.codigoVoo, aviao1.modelo, aviao1.capacidadePassageiros,
                aviao1.emVoo ? "EM VOO" : "EM SOLO", aviao1.altitudeAtual);
        System.out.printf("\n[AERONAVE 2]\nVoo: %s | Modelo: %s\nCapacidade: %d passageiros" +
                        "\nStatus Atual: %s\nAltitude: %.2f metros\n",
                aviao2.codigoVoo, aviao2.modelo, aviao2.capacidadePassageiros,
                aviao2.emVoo ? "EM VOO" : "EM SOLO", aviao2.altitudeAtual);
        System.out.println("=====================================================");
    }
}
