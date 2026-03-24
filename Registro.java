import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Registro {
  private Cliente cliente;
  private LocalDateTime entrada;
  private LocalDateTime saida;

  DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  public Registro(Cliente cliente) {
    this.cliente = cliente;
    this.entrada = LocalDateTime.now();
  }

  public void registrarSaida() {
    this.saida = LocalDateTime.now();
  }

  public double calcularHoras() {
    if (saida == null)
      return 0;
    Duration duracao = Duration.between(entrada, saida);
    return duracao.toMinutes();
  }

  public Cliente getCliente() {
    return cliente;
  }

  public String getHorarioEntrada() {
    return entrada.format(formato);
  }

  public String getHorarioSaida() {
    if (saida == null)
      return "ainda no estacionamento";
    return saida.format(formato);
  }

  public String toString() {
    return "{ " + cliente + " | Entrada: " + getHorarioEntrada() + " }";
  }
}
