# sistema-de-estacionamento_-sde
Davi gosta de java


```
+------------------+
|       Main       |
+------------------+
|                  |
+------------------+
| + main(args[])   |
+------------------+
         |
         | chama
         v
+------------------------+
|      Ui_interface      |
+------------------------+
| - scanner : Scanner    |
| - estacionamento : Map |
| - precoPorHora : double|
| - cont : boolean       |
+------------------------+
| + main()               |
+------------------------+
            |
            | cria
            v
      +--------------------+
      |      Cliente       |
      +--------------------+
      | - nome  : String   |
      | - placa : String   |
      +--------------------+
      | + getNome()        |
      | + getPlaca()       |
      | + toString()       |
      +--------------------+
                ^
                |
                | possui
                |
      +----------------------------+
      |          Registro          |
      +----------------------------+
      | - cliente : Cliente        |
      | - entrada : LocalDateTime  |
      | - saida   : LocalDateTime  |
      | - formato : DateTimeFormat |
      +----------------------------+
      | + registrarSaida()         |
      | + calcularHoras()          |
      | + getCliente()             |
      | + getHorarioEntrada()      |
      | + getHorarioSaida()        |
      | + toString()               |
      +----------------------------+

```


### Resumido

```bash
           +------+
           | Main |
           +------+
               |
               v
        +-------------+
        | UI Interface|
        +-------------+
          /        \
         v          v
   +--------+   +---------+
   |Cliente |   |Registro |
   +--------+   +---------+
                    |
                    v
                +--------+
                |Cliente |
                +--------+
```
