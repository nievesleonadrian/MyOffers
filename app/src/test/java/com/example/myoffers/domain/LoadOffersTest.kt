package com.example.myoffers.domain

import com.example.myoffers.data.OffersRepository
import com.example.myoffers.factory.OffersFactory
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoadOffersTest{

    @RelaxedMockK
    private lateinit var offersRepository: OffersRepository

    lateinit var getOffersUseCase: GetOffersUseCase

    var domainOfferList = OffersFactory.makeDomainOfferList(5)

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getOffersUseCase = GetOffersUseCase(offersRepository)
    }

    @Test
    fun `given OfferRepository, when getOffers, then return DomainOffer list`() = runBlocking{
        coEvery { offersRepository.getOffers() } returns domainOfferList

        var listResult = getOffersUseCase.invoke()

        assert(listResult == domainOfferList)
    }
}