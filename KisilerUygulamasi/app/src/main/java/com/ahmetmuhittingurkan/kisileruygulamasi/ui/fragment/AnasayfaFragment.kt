package com.ahmetmuhittingurkan.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmetmuhittingurkan.kisileruygulamasi.R
import com.ahmetmuhittingurkan.kisileruygulamasi.data.entity.Kisiler
import com.ahmetmuhittingurkan.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.ahmetmuhittingurkan.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.ahmetmuhittingurkan.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.ahmetmuhittingurkan.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)

        binding.anasayfaToolbarBaslik="Kişiler"
        binding.anasayfaFragment=this

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter= KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter=kisilerAdapter
        }

        binding.searchView.setOnQueryTextListener(object:OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

        })

        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
            binding.searchView.requestFocus()
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel= tempViewModel
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

}

