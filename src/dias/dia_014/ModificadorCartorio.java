package dias.dia_014;

public class ModificadorCartorio {

    public static void tentarMudarCPF(String cpfOriginal){
        cpfOriginal = "000.000.000-00";
        System.out.printf("Dentro do método: CPF ALTERADO PARA: %s\n", cpfOriginal);
    }

    public static void suspenderCadastro(Cidadao cidadaoObjeto){
        cidadaoObjeto.statusCadastro = "Suspendido";

        System.out.printf("Dentro do Método: Cadastro de %s alterado para SUSPENDIDO!\n", cidadaoObjeto.nome);
    }

}
