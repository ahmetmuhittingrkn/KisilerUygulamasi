package com.ahmetmuhittingurkan.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ahmetmuhittingurkan.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    fun kisileriYukle(): List<Kisiler>

    @Insert
    fun kaydet(kisi:Kisiler)

    @Update
    fun guncelle(kisi: Kisiler)

    @Delete
    fun sil(kisi: Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%'")
    fun ara(aramaKelimesi:String) : List<Kisiler>
}