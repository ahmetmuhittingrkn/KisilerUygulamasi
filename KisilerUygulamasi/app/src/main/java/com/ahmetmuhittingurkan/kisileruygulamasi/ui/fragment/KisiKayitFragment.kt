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
import com.ahmetmuhittingurkan.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.ahmetmuhittingurkan.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_kayit,container,false)
        binding.kisiKayitFragment=this
        binding.kisiKayitToolbarBaslik="Kişi Kayıt"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiKayitViewModel by viewModels()
        viewModel= tempViewModel
    }

    fun buttonKaydet(kisi_adi:String,kisi_teli:String){
        if (kisi_adi.isNotBlank() && kisi_teli.isNotBlank()){
            viewModel.kaydet(kisi_adi, kisi_teli)
            Toast.makeText(requireContext(), "Kişi başarıyla kaydedildi!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(), "Lütfen tüm alanları doldurunuz!", Toast.LENGTH_SHORT).show()
        }
        // requireContext() , fragment içindeki metodlarda kullanılabilen bir context.
    }

}