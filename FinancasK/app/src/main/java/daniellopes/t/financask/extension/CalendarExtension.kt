package daniellopes.t.financask.extension

import java.text.SimpleDateFormat
import java.util.*

// extension function
fun Calendar.formataParaBrasileiro(): String {
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}