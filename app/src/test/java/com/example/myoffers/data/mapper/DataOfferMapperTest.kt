package com.example.myoffers.data.mapper

import com.example.myoffers.data.model.DataOfferMapper
import com.example.myoffers.data.model.RemoteOffer
import com.example.myoffers.domain.model.Offer
import com.example.myoffers.factory.OffersFactory
import junit.framework.Assert.assertEquals
import org.junit.Test

class DataOfferMapperTest {

    private val dataOfferMapper = DataOfferMapper()

    @Test
    fun `given RemoteOfferResponse, when fromRemoteToDomain, then return DomainOffer List`() {
        val remoteOfferResponse = OffersFactory.makeRemoteOfferResponse(5)

        val domainOfferList = with(dataOfferMapper) { remoteOfferResponse.fromRemoteToDomain() }

        assertOffersEquals(remoteOfferResponse.items!!, domainOfferList)
    }

    private fun assertOffersEquals(
        remoteOfferList: List<RemoteOffer>,
        domainOfferList: List<Offer>
    ) {
        remoteOfferList.zip(domainOfferList).map {
            assertEquals("id", it.first.id, it.second.id)
            assertEquals("title", it.first.title, it.second.title)
            assertEquals("image", it.first.image, it.second.image)
            assertEquals("price", it.first.price, it.second.price)
        }
    }
}