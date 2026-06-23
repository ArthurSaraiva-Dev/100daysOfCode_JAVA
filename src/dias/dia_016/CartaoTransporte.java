package dias.dia_016;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class CartaoTransporte {
    String id;
    String nome;
    double saldo;
    String tipoCartao;
    boolean status = false;

    // Formatando Real
    private static String formatarMoeda(double valor){
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "br"));
        DecimalFormat formatoReal = new DecimalFormat("R$ #,##0.00", simbolos);
        return formatoReal.format(valor);
    }

    private static String gerarID(){
        int id = ThreadLocalRandom.current().nextInt(1000, 9999);
        return String.valueOf(id);
    }

    CartaoTransporte(String nome, String tipoCartao){
        if (tipoCartao.trim().equalsIgnoreCase("estudante")){
            this.tipoCartao = "Estudante";
        }else if (tipoCartao.trim().equalsIgnoreCase("comum")){
            this.tipoCartao = "Comum";
        }
        this.nome = nome;
        this.saldo = 0;
        this.id = "MOB-" + gerarID(); // IDENTIFICADOR MOB + O ID GERADO
        this.status = true;
    }

     String exibirRelatorio(){
        return String.format("=== RELATÓRIO DO CARTÃO ===\n" +
                "ID: %s | Passageiro: %s\n" +
                "Tipo de Cartão: %s | STATUS: %s\n" +
                "=============================================\n" +
                "Saldo Atual: %s\n" +
                "=============================================",
                this.id, this.nome,
                this.tipoCartao, this.status ? "ATIVO" : "BLOQUEADO",
                formatarMoeda(this.saldo));
    }

     String recarga(double valorRecarga){
        this.saldo += valorRecarga;
        return String.format("Cartão recarregado! \nSaldo atual: %s", formatarMoeda(this.saldo));
    }
}
