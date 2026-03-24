import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Ui_interface {
  public static void main() {
    Scanner scanner = new Scanner(System.in);
    Map<String, Registro> estacionamento = new HashMap<>();

    double precoPorHora = 15.0;
    boolean cont = true;

    while (cont) {
      System.out.println("\n====== Sistema de Estacionamento ======");
      System.out.println("1 - Registrar entrada de veiculo");
      System.out.println("2 - Registrar saida de veiculo");
      System.out.println("3 - Listar veiculos no estacionamento");
      System.out.println("4 - Listar veiculos de um usuário ");
      System.out.println("5 - Sair");
      System.out.print("Escolha uma opcao: ");

      int opt = scanner.nextInt();
      scanner.nextLine(); // limpar buffer

      switch (opt) {
        case 1:
          System.out.print("Nome do motorista: ");
          String nome = scanner.nextLine();

          System.out.print("Placa do veiculo: ");
          String placa = scanner.nextLine().toUpperCase();

          System.out.println("CPF do proprietário: ");
          long CPF = scanner.nextLong();

          if (estacionamento.containsKey(placa)) {
            System.out.println("ERRO: Esse veiculo ja esta no estacionamento!");
            break;
          }

          Cliente cliente = new Cliente(nome, placa, CPF);
          Registro registro = new Registro(cliente);

          estacionamento.put(placa, registro);
          System.out.println("Veiculo registrado com sucesso!");
          System.out.println("Entrada: " + registro.getHorarioEntrada());
          break;

        case 2:
          System.out.print("Placa do veiculo para saida: ");
          String placaSaida = scanner.nextLine().toUpperCase();

          if (!estacionamento.containsKey(placaSaida)) {
            System.out.println("ERRO: Veiculo nao encontrado no estacionamento.");
            break;
          }

          Registro reg = estacionamento.get(placaSaida);
          reg.registrarSaida();

          double horas = reg.calcularHoras();
          double valor = horas * precoPorHora;

          System.out.println("\n--- Comprovante de Saida ---");
          System.out.println("Cliente: " + reg.getCliente().getNome());
          System.out.println("Placa:   " + reg.getCliente().getPlaca());
          System.out.println("Entrada: " + reg.getHorarioEntrada());
          System.out.println("Saida:   " + reg.getHorarioSaida());
          System.out.printf("Tempo:   %.0f minuto(s)%n", horas * 60);
          System.out.printf("Valor:   R$ %.2f%n", valor);
          System.out.println("----------------------------");

          estacionamento.remove(placaSaida);
          break;

        case 3:
          if (estacionamento.isEmpty()) {
            System.out.println("Nenhum veiculo no estacionamento.");
          } else {
            System.out.println("\n--- Veiculos no Estacionamento ---");
            for (Registro r : estacionamento.values()) {
              System.out.println(r);
            }
          }
          break;

        case 4:
          System.out.println("Digite o CPF do cliente: ");
          if (estacionamento.isEmpty()) {
            System.out.println("Nenhum veiculo está no estacionamento");
          } else {
            System.out.println("\n--- Veiculos do usuário no estacionamento ---");
            for (Registro rCPF : estacionamento.values(CPF)) {
              System.out.println(rCPF);
            }
          }

        case 5:
          cont = false;
          System.out.println("Encerrando sistema. Ate logo!");
          break;

        default:
          System.out.println("Opcao invalida. Tente novamente.");
      }
    }
    scanner.close();
  }
}
