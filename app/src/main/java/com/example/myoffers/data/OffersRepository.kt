package com.example.myoffers.data

import com.example.myoffers.domain.model.Offer

interface OffersRepository {
    suspend fun getOffers(): List<Offer>
}