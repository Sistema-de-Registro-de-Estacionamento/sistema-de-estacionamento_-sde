import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;


public class Main {
    
    public static void main(String[] args){
        Ui_interface.main();
    }
    
}

class Ui_interface {
    
    public static void gerarDadosTeste(Map<String, Registro> estacionamento, int quantidade) {
    
        String[] nomes = {
            "Carlos", "Ana", "Marcos", "Joao", "Pedro",
            "Lucas", "Fernanda", "Julia", "Rafael", "Bruno"
        };
    
        for (int i = 0; i < quantidade; i++) {
    
            String nome = nomes[(int)(Math.random() * nomes.length)];
    
            String placa =
                "" + (char)(65 + Math.random()*26) +
                (char)(65 + Math.random()*26) +
                (char)(65 + Math.random()*26) +
                "-" +
                (int)(1000 + Math.random()*9000);
    
            Cliente cliente = new Cliente(nome, placa);
            Registro registro = new Registro(cliente);
    
            estacionamento.put(placa, registro);
        }
    
        System.out.println(quantidade + " veiculos de teste inseridos.");
    }
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
            System.out.println("4 - Sair");
            System.out.println("5 - Gerar dados de teste");
            System.out.print("Escolha uma opcao: ");

            int opt = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opt) {
                case 1:
                    System.out.print("Nome do motorista: ");
                    String nome = scanner.nextLine();

                    System.out.print("Placa do veiculo: ");
                    String placa = scanner.nextLine().toUpperCase();

                    if (estacionamento.containsKey(placa)) {
                        System.out.println("ERRO: Esse veiculo ja esta no estacionamento!");
                        break;
                    }

                    Cliente cliente = new Cliente(nome, placa);
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
                    cont = false;
                    System.out.println("Encerrando sistema. Ate logo!");
                    break;
                
                case 5:
                    System.out.print("Quantos registros gerar? ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();
                
                    gerarDadosTeste(estacionamento, qtd);
                
                    break;     

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
        scanner.close();
    }
}


// -----------------------------------------------
class Cliente {
    private String nome;
    private String placa;

    public Cliente(String nome, String placa) {
        this.nome = nome;
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public String getPlaca() {
        return placa;
    }

    public String toString() {
        return "{ Nome: " + nome + " | Placa: " + placa + " }";
    }
}

// -----------------------------------------------
class Registro {
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
        if (saida == null) return 0;
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
        if (saida == null) return "ainda no estacionamento";
        return saida.format(formato);
    }

    public String toString() {
        return "{ " + cliente + " | Entrada: " + getHorarioEntrada() + " }";
    }
}


