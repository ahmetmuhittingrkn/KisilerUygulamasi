package com.ahmetmuhittingurkan.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.ahmetmuhittingurkan.kisileruygulamasi.data.datasource.KisilerDataSource
import com.ahmetmuhittingurkan.kisileruygulamasi.data.entity.Kisiler
import com.ahmetmuhittingurkan.kisileruygulamasi.data.repo.KisilerRepository
import com.ahmetmuhittingurkan.kisileruygulamasi.room.KisilerDao
import com.ahmetmuhittingurkan.kisileruygulamasi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerDataSource(kdao:KisilerDao): KisilerDataSource{
        return KisilerDataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource): KisilerRepository{
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context): KisilerDao{
        val vt= Room.databaseBuilder(context,Veritabani::class.java,"rehber1.sqlite")
            .createFromAsset("rehber1.sqlite").build()
        return vt.getKisilerDao()
    }

}