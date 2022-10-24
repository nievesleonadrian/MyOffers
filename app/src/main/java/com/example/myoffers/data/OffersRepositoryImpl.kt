package com.example.myoffers.data

import com.example.myoffers.data.model.DataOfferMapper
import com.example.myoffers.data.remote.RemoteDataSource
import com.example.myoffers.domain.model.Offer

class OffersRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val dataOfferMapper: DataOfferMapper
) : OffersRepository {
    override suspend fun getOffers(): List<Offer> = with(dataOfferMapper) {
        remoteDataSource.getOffers().fromRemoteToDomain()
    }
}