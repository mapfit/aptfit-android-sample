package com.mapfit.realestate.ui.list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapfit.realestate.R
import com.mapfit.realestate.ui.common.RealEstateAdapter
import com.mapfit.realestate.ui.main.MainViewModel
import com.mapfit.realestate.util.openProjectPage
import kotlinx.android.synthetic.main.fragment_list.*

class RealEstateListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        init()
    }

    private fun init() {
        val realEstateAdapter =
            RealEstateAdapter(
                { realEstate -> viewModel.onRealEstateSelected(realEstate) },
                { openProjectPage(activity!!) },
                RealEstateAdapter.ItemType.VERTICAL
            )

        val realEstates = viewModel.neighborhoodEvent.value?.realEstates ?: listOf()

        realEstateAdapter.addItems(realEstates)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = realEstateAdapter
        }
    }

}