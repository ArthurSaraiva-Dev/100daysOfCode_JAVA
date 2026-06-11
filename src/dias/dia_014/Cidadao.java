package dias.dia_014;

public class Cidadao {
    String nome;
    String cpf;
    String statusCadastro = "Ativo";

    Cidadao(String nomeInicial, String cpfInicial){
        nome = nomeInicial;
        cpf = cpfInicial;
    }

    public static void exibirRelatorioCidadao(Cidadao cidadaoObjeto){
        System.out.printf("Nome: %s\n" +
                "CPF: %s\n" +
                "Status de Cadastro: %s\n",
                cidadaoObjeto.nome, cidadaoObjeto.cpf, cidadaoObjeto.statusCadastro);
    }
}
