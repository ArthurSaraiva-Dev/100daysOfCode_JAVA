package dias.dia_016;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ValidadorCatraca {
    // Formatando saída em real
    private static String formatarMoeda(double valor){
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "br"));
        DecimalFormat formatoReal = new DecimalFormat("R$ #,##0.00", simbolos);
        return formatoReal.format(valor);
    }

    public static String passarNaCatraca(CartaoTransporte cartao){
        double tarifaEstudante = 2.50;
        double tarifaComum = 5.0;

            if (!cartao.status){
                return String.format("[ERRO] Cartão BLOQUEADO!");
            } else if(cartao.tipoCartao.equalsIgnoreCase("COMUM") && cartao.saldo >= tarifaComum){
                cartao.saldo -= tarifaComum;
                return String.format("=== USO DA CATRACA ===\n" +
                        "[CATRACA] Tarifa comum aplicada (%s)\n" +
                        "[CATRACA] Acesso LIBERADO! Saldo Restante: %s\n",
                        formatarMoeda(tarifaComum), cartao.saldo);
            }else if (cartao.tipoCartao.equalsIgnoreCase("ESTUDANTE") && cartao.saldo >= tarifaEstudante){
                cartao.saldo -= tarifaEstudante;
                return String.format("=== SARAIVAMOB - USO DA CATRACA ===\n" +
                                "[CATRACA] Tarifa de estudante aplicada (%s)\n" +
                                "[CATRACA] Acesso LIBERADO! Saldo restante: %s\n",
                        formatarMoeda(tarifaEstudante), cartao.saldo);
            }else{
                return String.format("[ERRO] Saldo insuficiente! (%s)", formatarMoeda(cartao.saldo));
            }

    }

    static String alterarTipoCartao(CartaoTransporte cartao){
        cartao.status = false;
        return cartao.status ? "ATIVO" : String.format("=== TESTANDO PASSAGEM POR REFERÊNCIA ===" +
                                                       "\n[NO MÉTODO] CARTÃO DE %s foi BLOQUEADO por segurança.",
                                                        cartao.nome);
    }

    static String desbloquearCartao(CartaoTransporte cartao){
        cartao.status = true;
        return String.format("Cartão Desbloqueado!");
    }
}
