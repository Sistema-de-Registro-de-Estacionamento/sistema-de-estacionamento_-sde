public class Cliente {
  private String nome;
  private String placa;
  private long CPF;

  public Cliente(String nome, String placa, long CPF) {
    this.nome = nome;
    this.placa = placa;
    this.CPF = CPF;
  }

  public long getCPF() {
    return CPF;
  }

  public String getNome() {
    return nome;
  }

  public String getPlaca() {
    return placa;
  }

  public String toString() {
    return "{ Nome: " + nome + " | CPF: " + CPF + "| Placa: " + placa + " }";
  }
}
