object Excepciones {
    fun depuracionEnteros(numero: String): Boolean {
        try {
            numero.toInt()
            return true
        } catch (e: NumberFormatException) {
            return false
        }
    }

    fun depuracionDecimales(numero: String): Boolean {
        try {
            numero.toDouble()
            return true
        } catch (e: NumberFormatException) {
            return false
        }
    }
}