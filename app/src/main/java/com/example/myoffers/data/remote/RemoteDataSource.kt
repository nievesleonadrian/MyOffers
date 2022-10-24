package com.example.myoffers.data.remote

import com.example.myoffers.data.model.RemoteOfferResponse

interface RemoteDataSource {
    suspend fun getOffers(): RemoteOfferResponse
}