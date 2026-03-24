public interface Pagamento {

    //Regras de negócio.
    static final double Tarifa = 5.00;
    static final int Tolerancia = 15;

    default double calcularValor(Registro registro) {

        // Puxa o tempo total.
        double minutosTotais = registro.calcularHoras();

        // Saída registrada retorna 0.
        if (minutosTotais == 0) {
            System.out.println("Veículo ainda no estacionamento. Saída não registrada.");
            return 0.0;
        }

        // Calcula tolerância.
        if (minutosTotais <= Tolerancia) {
            System.out.println("Dentro do tempo de tolerância (" + minutosTotais + " min). Isento de pagamento.");
            return 0.0;
        }

        //Arredondar horas.
        long horasCobradas = (long) Math.ceil(minutosTotais / 60.0);
        double valorTotal = horasCobradas * Tarifa; //Valor final.

        return valorTotal;
    }
}
