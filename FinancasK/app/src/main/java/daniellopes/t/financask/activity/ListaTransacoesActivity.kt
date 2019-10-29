package daniellopes.t.financask.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import daniellopes.t.financask.R
import daniellopes.t.financask.adapter.ListaTransacoesAdapter
import daniellopes.t.financask.model.Tipo
import daniellopes.t.financask.model.Transacao
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

//Para herdar uma classe no kotlin usa o :

class ListaTransacoesActivity : AppCompatActivity() {

    //Unit é igual o void no android. já retorna isso por padrão

    //plugin - Kotlin Android Extention
    // não precisa do findViewById
    //atraves do synthetic

    // Variaveis
    // var - variavel pode ser mutavel
    // val - variavel não mua de valor, nao pode reatribuir

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes: List<Transacao> = transacoesDeExemplo()

        configuraLista(transacoes)
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter =
            ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo(): List<Transacao> {
        return listOf(
            //valor = BigDecimal(20.50) - Named Parameter
            // (sobrecarga sem criar construtor)
            Transacao(
                valor = BigDecimal(20.50),
                tipo = Tipo.DESPESA,
                categoria = "Almoço de final de semana",
                data = Calendar.getInstance()
            ),

            Transacao(
                valor = BigDecimal(100.0),
                categoria = "Economia",
                tipo = Tipo.RECEITA
            ),

            Transacao(
                valor = BigDecimal(200.0),
                tipo = Tipo.DESPESA
            ),
            Transacao(
                valor = BigDecimal(500.0),
                categoria = "Premio",
                tipo = Tipo.RECEITA
            )
        )
    }
}