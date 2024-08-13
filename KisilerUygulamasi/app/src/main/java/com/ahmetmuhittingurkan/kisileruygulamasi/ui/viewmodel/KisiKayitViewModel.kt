package com.ahmetmuhittingurkan.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ahmetmuhittingurkan.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor(var krepo:KisilerRepository):ViewModel() {

     fun kaydet(kisi_adi:String,kisi_teli:String){
         CoroutineScope(Dispatchers.Main).launch {
             krepo.kaydet(kisi_adi, kisi_teli)
         }
     }
}