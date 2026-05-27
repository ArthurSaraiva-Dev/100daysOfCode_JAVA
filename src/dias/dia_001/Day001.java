package dias.dia_001;

public class Day001 {
    public static void main(String[] args) {
        // Desafio diário: 01/100
        // Tipos primitivos

        // Desafio do Dia: O Sistema de uma Oficina de Computadores

        // Computadores para conserto
        int pcs = 5;

        // Preço da mão de obra
        double price = 89.90;

        // Inicial do Cliente
        char inicialCliente = 'F';

        // O cliente já realizou o pagamento?
        boolean checkPayment = false;

        //Saída
        System.out.println("--- DETALHES DA ORDEM DE SERVIÇO ---");

        System.out.println("Quantidade de PCs: " + pcs);
        System.out.println("Valor do orçamento: R$" + price);
        System.out.println("Inicial do cliente: " + inicialCliente);
        System.out.println("Serviço Pago?: " + checkPayment);
    }
}
