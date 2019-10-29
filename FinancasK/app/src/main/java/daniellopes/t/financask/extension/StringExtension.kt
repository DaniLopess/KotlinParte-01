package daniellopes.t.financask.extension


//recebendo como parâmetro o
// valor caracteres: Int para indicar a
// quantidade de caracteres que deseja limitar, então,
// retorne uma String que vai ser a String limitada.


//o objeto this, pois agora o próprio objeto da String
// será utilizado como referência para realizar a formatação.
fun String.limitaEmAte(caracteres: Int): String {
    if (this.length > caracteres) {
        val primeiroCaracter = 0
        return "${this.substring(primeiroCaracter, caracteres)}..."
    }
    //retorna a propria string
    return this
}