package dias.dia_013;


import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class LinhaTelefonica {
    // Atributos
    String numeroTelefone;
    String nomeCliente;
    double credito;
    boolean planoAtivo;
    boolean numeroAtivo;

    // Construtor
    public LinhaTelefonica(String nomeCliente){
        this.nomeCliente = nomeCliente;
        this.credito = 0.0;
        this.planoAtivo = false;
        this.numeroAtivo = false;
    }

    String gerarNumero(){
        int ddd = ThreadLocalRandom.current().nextInt(11, 100);
        int bloco1 = ThreadLocalRandom.current().nextInt(6000, 10000);
        int bloco2 = ThreadLocalRandom.current().nextInt(0, 10000);

        numeroTelefone = String.format("(%d) 9%04d-%04d", ddd, bloco1, bloco2);
        numeroAtivo = true;

        return String.format("Olá, %s!\n" +
                "Seu número é: %s", this.nomeCliente, this.numeroTelefone);
    }

    String ativarPlano(){
        if (!this.numeroAtivo){
            return "[FALHA NA ATIVAÇÃO!] VOCÊ AINDA NÃO GEROU O NÚMERO";
        }

        if (this.credito >= 30.0){
            this.credito -= 30.0;
            this.planoAtivo = true;
            return String.format("[SUCESSO NA ATIVAÇÃO] %s, plano ativado! " +
                    "\nSaldo Restante: R$%.2f",this.nomeCliente, this.credito);
        }else {
            return String.format("[FALHA NA ATIVAÇÃO] %s, SALDO INSUFICIENTE! " +
                    "\nSaldo: R$%.2f",this.nomeCliente, this.credito);
        }
    }


    String recarga(double valorRecarga){
        if (!this.numeroAtivo){
            return "[FALHA NA RECARGA] VOCÊ AINDA NÃO CRIOU SEU NÚMERO!";
        }

        this.credito += valorRecarga;
        return String.format("%s, sua recarga de R$%.1f foi realizada com sucesso!", this.nomeCliente, this.credito);
    }

    String exibirRecarga(){
     return String.format("%s, sua recarga de R$%.1f foi realizada com sucesso!", nomeCliente, credito);
    }

    String exibirStatus(){
        return this.planoAtivo ? "ATIVO" : "INATIVO";
    }


    String exibirRelatorio(){
        String retorneRelatorio = String.format("=== STATUS DA LINHA ===\n" +
                "Cliente: %s\n" +
                "Número: %s\n" +
                "Créditos: %.2f\n" +
                "Status do Plano: %s",
                this.nomeCliente, this.numeroTelefone != null ? this.numeroTelefone : "Não Gerado",
                this.credito,
                this.exibirStatus());

        return retorneRelatorio;
    }
}
