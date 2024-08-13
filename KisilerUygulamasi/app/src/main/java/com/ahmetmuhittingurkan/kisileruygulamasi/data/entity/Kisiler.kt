package com.ahmetmuhittingurkan.kisileruygulamasi.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity("kisiler")
data class Kisiler(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="kisi_id") @NotNull var kisi_id:Int,
    @ColumnInfo(name ="kisi_ad") @NotNull var kisi_ad:String,
    @ColumnInfo(name ="kisi_tel") @NotNull var kisi_tel:String ) : Serializable{

}