package com.example.myoffers.data.remote

import com.example.myoffers.data.model.RemoteOfferResponse
import retrofit2.http.GET

interface OffersApiService {
    @GET("offers")
    suspend fun getOffers(): RemoteOfferResponse
}