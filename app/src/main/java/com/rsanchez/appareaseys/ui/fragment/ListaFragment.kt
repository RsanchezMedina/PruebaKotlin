package com.rsanchez.appareaseys.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rsanchez.appareaseys.R
import com.rsanchez.appareaseys.adapter.ListAdapter
import com.rsanchez.appareaseys.factory.ViewModelFactory
import com.rsanchez.appareaseys.iterator.FindItemsInteractor
import com.rsanchez.appareaseys.model.Person
import com.rsanchez.appareaseys.viewmodels.ListaViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListaFragment : Fragment() {
    lateinit var viewModel: ListaViewModel
    lateinit var mRecyclerView: RecyclerView
    lateinit var textFail: TextView
    lateinit var imgFail: ImageView
    lateinit var progrsss: ProgressBar


    val mAdapter: ListAdapter =
        ListAdapter()

    companion object {
        fun newInstance(): ListaFragment {
            return ListaFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflater = inflater.inflate(R.layout.fragment_list, container, false)
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(FindItemsInteractor())
        )[ListaViewModel::class.java]
        inicializeComponent(inflater)


        viewModel.let {
            viewModel.callListData()
            viewModel.getListData().observe(this, Observer {
                setUpRecyclerView(it)
                progressBar.visibility = View.GONE
            })

            viewModel.getErrorConect().observe(this, Observer {
                mRecyclerView.visibility = View.GONE
                textFail.visibility = View.VISIBLE
                imgFail.visibility = View.VISIBLE
                textFail.text = it.message
                progressBar.visibility = View.GONE
            })
        }
        return inflater
    }

    private fun inicializeComponent(inflater: View) {
        mRecyclerView = inflater.findViewById(R.id.miLista) as RecyclerView
        textFail = inflater.findViewById(R.id.textFail) as TextView
        imgFail = inflater.findViewById(R.id.imageFail) as ImageView
        progrsss = inflater.findViewById(R.id.progressBar) as ProgressBar
    }

    fun setUpRecyclerView(list: List<Person>) {

        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mAdapter.ListAdapter(activity!!, list)
        mRecyclerView.adapter = mAdapter
    }

}
