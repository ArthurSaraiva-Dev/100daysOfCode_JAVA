package dias.dia_015;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class AtivoFinanceiro {
    // Setando Atributos:
    String ticker;
    String nomeEmpresa;
    double precoCompra;
    double precoAtual;
    int quantidadeCotas;

    // Construtor:
    AtivoFinanceiro(String ticker, String nomeEmpresa, double precoCompra, int quantidadeCotas){
        this.ticker = ticker;
        this.nomeEmpresa = nomeEmpresa;
        this.precoCompra = precoCompra;
        this.precoAtual = precoCompra;
        this.quantidadeCotas = quantidadeCotas;
    }

    // Calculador de Investimentos
    double calcularValorInvestido(){
        return this.precoCompra * this.quantidadeCotas;
    }

    // Calculador de Patrimonio:
    double calcularPatrimonioAtual(){
        return this.quantidadeCotas * this.precoAtual;
    }

    // Calculador de Prejuízo
    double calcularLucroPrejuizo(){
        return calcularPatrimonioAtual() - calcularValorInvestido();
    }

    private String formatarMoeda(double valor) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("R$ #,##0.00", simbolos);
        return df.format(valor);
    }

    // Geração de Extrato:

    String gerarExtrato(){
        String fatorLucroPrejuizo = calcularLucroPrejuizo() < 0 ?
                "PREJUÍZO" : "LUCRO";

        return String.format("=== EXTRATO DE ATIVO ===\n" +
                "Ativo: %s - %s\n" +
                "Quantidade: %d cotas\n" +
                "----------------------------------------\n" +
                "Preço de Compra: %s\nValor Investido: %s\n" +
                "-----------------------------------------\n" +
                "Preço de Mercado: %s\nPatrimônio Atual: %s\n" +
                "-----------------------------------------\n" +
                "Resultado do Investimento: %s (%s)",
                this.ticker, this.nomeEmpresa,
                this.quantidadeCotas,
                formatarMoeda(this.precoCompra), formatarMoeda(calcularValorInvestido()),
                formatarMoeda(this.precoAtual), formatarMoeda(calcularPatrimonioAtual()),
                formatarMoeda(calcularLucroPrejuizo()), fatorLucroPrejuizo);
    }
}
