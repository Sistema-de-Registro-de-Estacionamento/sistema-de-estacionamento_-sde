# sistema-de-estacionamento_-sde
Davi gosta de java

```bash
+------------------+
|      Main        |
+------------------+
| + main(args):void|
+------------------+
         |
         |
+-------------------+
|  Ui_interface     |
+-------------------+
| + gerarDadosTeste |
| + buscarPorCpf    |
| + main() : void   |
+-------------------+
         |
         |
+-------------------+          +-----------------------------------+
|     Cliente       |<---------|     Registro                      |
+-------------------+          +-----------------------------------+
| - nome: String    |          | - cliente: Cliente                |
| - placa: String   |          | - entrada: LocalDateTime          |
| - cpf: String     |          | - saida: LocalDateTime            |
| + getNome():      |          | - formato: DateTimeFormatter      |
| + getPlaca():     |          | + Registro(Cliente) : void        |
| + getCpf():       |          | + registrarSaida() : void         |
| + toString() :    |          | + calcularSegundos() : long       |
+-------------------+          | + getCliente() : Cliente          |  
                                | + getHorarioEntrada() : String   |
                                | + getHorarioSaida() : String     |
                                | + toString() : String            | 
                                +----------------------------------+
```






## Kanban

![Cover](kanban.png)
>>>>>>> 4f725914c6b3c1a76282148bb8b92f3595ad9f2c
