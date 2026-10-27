class Cajero (){

    private var saldo: Double

    init {
        saldo = 500.0; //pone el saldo a 500 en el constructor
    }

    public fun menu (){
        var salir: Boolean = false; //controla la salida del bucle
        var input: String; //variable que lee los imputs del usuario
        do {
            while (true){
                mostrarMenu()
                input = readln().trim()
                if (!Excepciones.depuracionEnteros(input)){ //comprueva si el dato no es un entero
                    System.err.println("Error: El valor introducido no es válido, tienes que introducir un número entero.\n")
                }else{
                    break //si el dato es un entero sale del bucle
                }
            }
            when(input.toInt()){ //lee la opicion del input como un entero
                1 ->{
                    println("CONSULTAR SALDO: ")
                    println("Saldo total: %.2f€\n" .format(saldo))
                }
                2 ->{
                    println("INGRESAR DINERO: ")
                    while (true) {
                        println("Introduce la cantidad que quieras ingresar o escribe \"cancelar\" para cancelar la operacion: ")
                        input = readln().trim().uppercase()
                        if (input.equals("CANCELAR")) break //si el input es cancelar sale del bucle
                        if (!Excepciones.depuracionDecimales(input)) { //comprueba si el input es un decimal
                            System.err.println("Error: Tienes que introducir una cantidad decimal.\n")
                        } else if (input.toDouble() <= 0) { //comprueba si es menor o igual que 0
                            System.err.println("Error: Tienes que introducir una cantidad mayor a 0€\n")
                        } else {
                            saldo += input.toDouble() //añade la cantidad de saldo
                            println("Se han añadido %.2f€ a la cuenta, tu saldo actual es %.2f€\n".format(input.toDouble(), saldo))
                            break
                        }
                    }
                }
                3 ->{
                    println("RETIRAR DINERO: ")
                    while (true) {
                        println("Introduce la cantidad que quieras retirar o escribe \"cancelar\" para cancelar la operación: ")
                        input = readln().trim().uppercase()
                        if (input.equals("CANCELAR")) break
                        if (!Excepciones.depuracionDecimales(input)) {
                            System.err.println("Error: Tienes que introducir una cantidad decimal.\n")
                        } else if (input.toDouble() <= 0) {
                            System.err.println("Error: Tienes que introducir una cantidad mayor a 0€\n")
                        } else if (input.toDouble() > saldo) { //comprueba si la cantidad introducida es mayor al saldo actual
                            System.err.println("Error: No puedes retirar una cantidad mayor de saldo de la que tienes\n")
                        } else {
                            saldo -= input.toDouble() //resta la cantidad introducida al saldo
                            println("Se han retirado %.2f€ de la cuenta, tu saldo actual es %.2f€\n".format(input.toDouble(), saldo))
                            break
                        }
                    }
                }

                4-> salir = true //ponemos salir en true para salir del bucle

                else -> println("Tienes que introducir una opcion comprendida entre 1 y 4.\n") //suelta un mensaje de error en caso de que no se cumpla ninguna condición
            }
        }while (!salir)
    }

    private fun mostrarMenu (){
        println("===== CAJERO AUTOMÁTICO =====\n" +
                "1. Consultar saldo\n" +
                "2. Ingresar dinero\n" +
                "3. Retirar dinero\n" +
                "4. Salir\n" +
                "Seleccione una opción:")
    }
}