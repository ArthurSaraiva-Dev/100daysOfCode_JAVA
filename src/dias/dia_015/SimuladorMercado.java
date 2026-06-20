package dias.dia_015;

public class SimuladorMercado {
    public static String tentarModificarTicker(String ticker){
        return ticker = "INVÁLIDO";
    }

    public static double aplicarOscilacao(AtivoFinanceiro ativo, double percentual){
        if (percentual >= 1){
            percentual = percentual / 100;
        }
        return ativo.precoAtual += ativo.precoAtual * percentual;
    }
}
