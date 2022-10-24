package com.example.myoffers.factory

import com.example.myoffers.data.model.RemoteOffer
import com.example.myoffers.data.model.RemoteOfferResponse
import com.example.myoffers.domain.model.Offer
import com.example.myoffers.ui.model.UiOffer

object OffersFactory {

    fun makeRemoteOffer() = RemoteOffer(
        id = RandomFactory.generateString(),
        title = RandomFactory.generateString(),
        image = RandomFactory.generateString(),
        price = RandomFactory.generateDouble()
    )

    fun makeRemoteOfferList(count: Int) = (0..count).map { makeRemoteOffer() }

    fun makeRemoteOfferResponse(count: Int) = RemoteOfferResponse(
        total = count,
        items = makeRemoteOfferList(count)
    )

    fun makeDomainOffer() = Offer(
        id = RandomFactory.generateString(),
        title = RandomFactory.generateString(),
        image = RandomFactory.generateString(),
        price = RandomFactory.generateDouble()
    )

    fun makeDomainOfferList(count: Int) = (0..count).map { makeDomainOffer() }

    fun makeUiOffer() = UiOffer(
        title = RandomFactory.generateString(),
        image = RandomFactory.generateString(),
        price = RandomFactory.generateDouble()
    )

    fun makeUiOfferList(count: Int) = (0..count).map { makeUiOffer() }
}