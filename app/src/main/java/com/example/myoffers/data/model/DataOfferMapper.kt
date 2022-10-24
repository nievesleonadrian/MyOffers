package com.example.myoffers.data.model

import com.example.myoffers.domain.model.Offer

class DataOfferMapper {

    fun RemoteOffer.fromRemoteToDomain() = Offer(
        id = id ?: "",
        title = title ?: "",
        image = image ?: "",
        price = price ?: 0.0
    )

    fun RemoteOfferResponse.fromRemoteToDomain(): List<Offer> {
        return items?.map { remoteOffer -> remoteOffer.fromRemoteToDomain() } ?: emptyList()
    }
}