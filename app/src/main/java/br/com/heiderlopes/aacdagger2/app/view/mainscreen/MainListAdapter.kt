package br.com.heiderlopes.aacdagger2.app.view.mainscreen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.heiderlopes.aacdagger2.R

class MainListAdapter(var speciesListViewModel: MainViewModel) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        speciesListViewModel.getSpeciesAt(position)?.let {
            holder.apply {
                name.text = it.name
                classification.text = it.classification
                language.text = it.language
                lifeSpan.text = it.lifeSpan
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false))
    }

    override fun getItemCount(): Int {
        return speciesListViewModel.getSpeciesSize()
    }
}