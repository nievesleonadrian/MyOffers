package com.example.myoffers.ui.di

import com.example.myoffers.data.OffersRepository
import com.example.myoffers.domain.GetOffersUseCase
import com.example.myoffers.ui.view.UiHelper
import com.example.myoffers.ui.model.UiOfferMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class UiModule {

    @Singleton
    fun loadOffersProvider(offersRepository: OffersRepository): GetOffersUseCase =
        GetOffersUseCase(offersRepository)

    @Provides
    fun providesUiOfferMapper(): UiOfferMapper = UiOfferMapper()

    @Provides
    fun provideMessageGenerator(): UiHelper = UiHelper()
}