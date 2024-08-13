package com.ahmetmuhittingurkan.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetmuhittingurkan.kisileruygulamasi.R
import com.ahmetmuhittingurkan.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.ahmetmuhittingurkan.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel
import com.ahmetmuhittingurkan.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {

    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)

        binding.kisiDetayToolbarBaslik="Kişi Detay"
        binding.kisiDetayFragment=this

        val bundle:KisiDetayFragmentArgs by navArgs()

        val gelenKisi=bundle.Kisi
        binding.kisiNesnesi=gelenKisi

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDetayViewModel by viewModels()
        viewModel= tempViewModel
    }

    fun buttonGuncelle(kisi_id:Int,kisi_adi:String,kisi_teli:String){
        if (kisi_adi.isNotBlank() && kisi_teli.isNotBlank()){
            viewModel.guncelle(kisi_id,kisi_adi, kisi_teli)
            Toast.makeText(requireContext(), "Kişi başarıyla güncellendi!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(), "Lütfen tüm alanları doldurunuz!", Toast.LENGTH_SHORT).show()
        }
    }
}


