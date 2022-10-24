package com.example.myoffers.data.remote

import com.example.myoffers.data.model.RemoteOfferResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val offersApiService: OffersApiService) :
    RemoteDataSource {
    override suspend fun getOffers(): RemoteOfferResponse = offersApiService.getOffers()
}