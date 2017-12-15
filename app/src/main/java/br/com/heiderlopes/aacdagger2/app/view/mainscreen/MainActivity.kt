package br.com.heiderlopes.aacdagger2.app.view.mainscreen

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.Observer
import android.os.Bundle
import br.com.heiderlopes.aacdagger2.R
import br.com.heiderlopes.aacdagger2.base.BaseActivity
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProviders
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import br.com.heiderlopes.aacdagger2.data.remote.model.Species
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val registry = LifecycleRegistry(this)
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainListAdapter

    @Inject
    lateinit var hello: String

    @Inject
    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        title = "STARWAR SPECIES"
        viewModel = createViewModel()
        adapter = MainListAdapter(viewModel)
        rvSpecies.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        attachObserver()
        viewModel.getSpecies()
    }

    private fun attachObserver() {
        viewModel.isLoading.observe(this, Observer<Boolean> {
            it?.let { showLoadingDialog(it) }
        })
        viewModel.apiError.observe(this, Observer<Throwable> {
            it?.let { Snackbar.make(rvSpecies, it.localizedMessage, Snackbar.LENGTH_LONG).show() }
        })
        viewModel.speciesResponse.observe(this, Observer<List<Species>> {
            it?.let { adapter.notifyDataSetChanged() }
        })

    }
    private fun createViewModel(): MainViewModel =
            ViewModelProviders.of(this).get(MainViewModel::class.java).also {
                //ComponentInjector.appComponent.inject(it)
                /*DaggerMainComponent.builder()
                        .appComponent(getAppcomponent())
                        .mainModule(MainModule())
                        .build().inject(this)*/
            }

    private fun showLoadingDialog(show: Boolean) {
        if (show) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE
    }
}
