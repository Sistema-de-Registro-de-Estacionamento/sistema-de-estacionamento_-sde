import java.util.Scanner; 
import java.util.HashMap;
import java.util.Map;

public class Main
{
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    Map<Cliente, Registro> user = new HashMap<>();
	    
	    boolean cont = true;
	    
	    while(cont) {
	        
	        System.out.println("Bem-vido ao Sistema.. ");
	        System.out.println("Escolha uma opção");
	        
	        System.out.println("1 - Adicionar cliente");
	        System.out.println("2 - Sair");
	        System.out.println("3 - Clientes cadastrado");
	        
	        System.out.print("Digite sua escolha: ");
	        int opt = scanner.nextInt();
	        
	        switch(opt){
	            case 1:
	                scanner.nextLine();
	                
	                System.out.print("Escreva o nome do usario: ");
	                String nome = scanner.nextLine();
	                
	                System.out.print("Escreva a placa: ");
	                String placa = scanner.nextLine();
	                
	                System.out.println(nome);
	                
                    // System.out.println("Escreva o horario: ");
	                String horario = "18/20";
	                
	               // System.out.println("Escreva a data: ");
	                String data = "17/03";
	                
	                Cliente cliente = new Cliente(nome, placa);
	                Registro d_h = new Registro(horario, data);
	                
	                user.put(cliente, d_h);
	                break;
	           case 2:
	               cont  = false;
	               break;
	           case 3:
	               user.forEach((key, value) -> System.out.println(key + " -> " + value));
                    break;
	               
	 
	            
	        }

	    }

	}
}

class Cliente {
    private String nome;
    private String placa;
    
    public Cliente(String nome, String placa){
        this.nome = nome;
        this.placa = placa;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public String getNome(String nome){
        return nome;
    }
    
    public String getPlaca(String placa){
        return placa;
    }
    

    public String toString(){
        return "{ Nome: "+ nome  + " | Placa:  " + placa + " }";
    }
}

class Registro {
    private String data;
    private String horario_entrada;
    private String horario_saida;
    
    public Registro(String horario_entrada, String data) {
        this.data = data;
        this.horario_entrada = horario_entrada;
    }
    
    public void setHorario_saida(String horario) {
        this.horario_saida = horario_saida;
    }
    
    public String toString(){
        return "{ data:"+ data + "| horario: " + horario_entrada + "}"; 
    }
}


