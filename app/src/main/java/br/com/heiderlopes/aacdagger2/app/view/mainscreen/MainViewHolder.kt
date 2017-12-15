package br.com.heiderlopes.aacdagger2.app.view.mainscreen

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import br.com.heiderlopes.aacdagger2.R

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name by lazy { view.findViewById(R.id.name) as TextView }
    val classification by lazy { view.findViewById(R.id.classification) as TextView }
    val language by lazy { view.findViewById(R.id.language) as TextView }
    val lifeSpan by lazy { view.findViewById(R.id.lifeSpan) as TextView }
}