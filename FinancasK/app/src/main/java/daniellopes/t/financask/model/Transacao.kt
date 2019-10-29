package daniellopes.t.financask.model

import java.math.BigDecimal
import java.util.Calendar

//properties
class Transacao(val valor: BigDecimal,
                val categoria: String = "Indefinida",
                val tipo: Tipo,
                val data: Calendar = Calendar.getInstance()){

//    construtor secundario
//    sobrecarga de construtor no kotlin

//    constructor(valor: BigDecimal, tipo: Tipo) : this(valor, "Indefinida", tipo)
//    constructor(valor: BigDecimal, tipo: Tipo, data: Calendar) : this(valor, "Indefinida", tipo, data)
}