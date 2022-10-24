package com.example.myoffers.data.di

import com.example.myoffers.data.*
import com.example.myoffers.data.model.DataOfferMapper
import com.example.myoffers.data.remote.OffersApiService
import com.example.myoffers.data.remote.RemoteDataSource
import com.example.myoffers.data.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideDataOfferMapper(): DataOfferMapper = DataOfferMapper()

    @Provides
    fun provideRemoteDataSource(offersApiService: OffersApiService): RemoteDataSource =
        RemoteDataSourceImpl(offersApiService)

    @Singleton
    @Provides
    fun providesRepository(
        remoteDataSource: RemoteDataSource,
        dataOfferMapper: DataOfferMapper
    ): OffersRepository =
        OffersRepositoryImpl(remoteDataSource, dataOfferMapper)
}