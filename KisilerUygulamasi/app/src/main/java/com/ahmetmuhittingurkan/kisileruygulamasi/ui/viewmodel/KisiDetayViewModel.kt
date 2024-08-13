package com.ahmetmuhittingurkan.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ahmetmuhittingurkan.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var krepo:KisilerRepository):ViewModel() {

     fun guncelle(kisi_id:Int,kisi_adi:String,kisi_teli:String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.guncelle(kisi_id, kisi_adi, kisi_teli)
        }
    }
}