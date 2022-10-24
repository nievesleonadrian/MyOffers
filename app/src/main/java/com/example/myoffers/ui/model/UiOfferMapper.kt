package com.example.myoffers.ui.model

import com.example.myoffers.domain.model.Offer

class UiOfferMapper {

    fun Offer.fromDomainToUi() = UiOffer(
        title = title,
        image = image,
        price = price
    )

    fun List<Offer>.fromDomainToUi(): List<UiOffer> {
        return map { domainOffer -> domainOffer.fromDomainToUi() }
    }
}