package com.example.myoffers.ui.mapper

import com.example.myoffers.factory.OffersFactory
import com.example.myoffers.domain.model.Offer
import com.example.myoffers.ui.model.UiOffer
import com.example.myoffers.ui.model.UiOfferMapper
import junit.framework.Assert.assertEquals
import org.junit.Test

class UiOfferMapperTest{
    private val uiOfferMapper = UiOfferMapper()

    @Test
    fun `given DomainOffer list, when fromDomainToUi, then return UiOffer list`() {
        val domainOfferList = OffersFactory.makeDomainOfferList(9)

        val uiOfferList  = with(uiOfferMapper) { domainOfferList.fromDomainToUi() }

        assertMovieEquals(domainOfferList, uiOfferList)
    }

    private fun assertMovieEquals(domainOfferList: List<Offer>, uiOfferList: List<UiOffer>) {
        domainOfferList.zip(uiOfferList).map {
            assertEquals("title", it.first.title, it.second.title)
            assertEquals("image", it.first.image, it.second.image)
            assertEquals("price", it.first.price, it.second.price)
        }
    }
}