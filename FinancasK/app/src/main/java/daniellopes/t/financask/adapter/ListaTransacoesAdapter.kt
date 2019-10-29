package daniellopes.t.financask.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import daniellopes.t.financask.R
import daniellopes.t.financask.extension.formataParaBrasileiro
import daniellopes.t.financask.extension.limitaEmAte
import daniellopes.t.financask.model.Tipo
import daniellopes.t.financask.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*


//Quebra de linha quando recebe mais de um valor no contrutor
class ListaTransacoesAdapter(
    private val transacoes: List<Transacao>,
    private val context: Context
) : BaseAdapter() {

//    private val transacoes = transacoes
//    private val context = context

    private val limiteDaCategoria = 14

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        adicionaValor(transacao, viewCriada)
        adicionaIcone(transacao, viewCriada)
        adicionaCategoria(viewCriada, transacao)
        adicionaData(viewCriada, transacao)

        return viewCriada
    }

    private fun adicionaData(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_data.text = transacao.data
            .formataParaBrasileiro()
    }

    private fun adicionaCategoria(viewCriada: View, transacao: Transacao) {
        viewCriada.transacao_categoria.text = transacao.categoria
            .limitaEmAte(limiteDaCategoria)
    }

    private fun adicionaIcone(transacao: Transacao, viewCriada: View) {
        val icone = iconePor(transacao.tipo)
        viewCriada.transacao_icone
            .setBackgroundResource(icone)
    }

    private fun iconePor(tipo: Tipo): Int {
        if (tipo == Tipo.RECEITA) {
            //early return
            return R.drawable.icone_transacao_item_receita
        }
        //early return
        return R.drawable.icone_transacao_item_despesa

    }

    private fun adicionaValor(transacao: Transacao, viewCriada: View) {
        //recurso if expression no kotlin
        val cor: Int = corPor(transacao.tipo)

        viewCriada.transacao_valor
            .setTextColor(cor)

        viewCriada.transacao_valor.text = transacao.valor
            .formataParaBrasileiro()
    }

    private fun corPor(tipo: Tipo): Int {

        // utilizando o when
//        private fun corPor(tipo: Tipo): Int {
//            return when (tipo) {
//                Tipo.RECEITA -> ContextCompat.getColor(context, R.color.receita)
//                Tipo.DESPESA -> ContextCompat.getColor(context, R.color.despesa)
//            }
//        }

        if (tipo == Tipo.RECEITA) {
            return ContextCompat.getColor(context, R.color.receita)
        }
        return ContextCompat.getColor(context, R.color.despesa)

    }

    //Any = Obj do Java - super classe, devolve qualquer coisa.
    override fun getItem(position: Int): Transacao {
        //return transacoes.get(position)
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        //size - atraves de uma properties
        return transacoes.size
    }
}