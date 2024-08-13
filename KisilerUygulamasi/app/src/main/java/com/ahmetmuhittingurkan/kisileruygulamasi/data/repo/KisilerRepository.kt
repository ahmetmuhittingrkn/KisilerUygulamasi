package com.ahmetmuhittingurkan.kisileruygulamasi.data.repo

import com.ahmetmuhittingurkan.kisileruygulamasi.data.datasource.KisilerDataSource
import com.ahmetmuhittingurkan.kisileruygulamasi.data.entity.Kisiler

class KisilerRepository(var kds:KisilerDataSource) {


    suspend fun kaydet(kisi_adi:String,kisi_teli:String)=kds.kaydet(kisi_adi,kisi_teli)

    suspend fun guncelle(kisi_id:Int,kisi_adi:String,kisi_teli:String)=kds.guncelle(kisi_id, kisi_adi, kisi_teli)

    suspend fun sil(kisi_id:Int)=kds.sil(kisi_id)

    suspend fun kisileriYukle() : List<Kisiler> = kds.kisileriYukle()

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> = kds.ara(aramaKelimesi)

}