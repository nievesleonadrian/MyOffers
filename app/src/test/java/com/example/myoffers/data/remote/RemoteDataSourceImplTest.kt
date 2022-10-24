package com.example.myoffers.data.remote

import com.example.myoffers.factory.OffersFactory
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RemoteDataSourceImplTest{

    @RelaxedMockK
    private lateinit var offersApiService: OffersApiService

    lateinit var remoteDataSource: RemoteDataSourceImpl

    var remoteOfferResponse = OffersFactory.makeRemoteOfferResponse(3)

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        remoteDataSource = RemoteDataSourceImpl(offersApiService)
    }

    @Test
    fun `given OffersApiService, when getOffers, then return RemoteOfferResponse`() = runBlocking{
        coEvery { offersApiService.getOffers() } returns remoteOfferResponse

        var result = remoteDataSource.getOffers()

        coVerify(exactly = 1) { remoteDataSource.getOffers() }
        assertEquals("response", remoteOfferResponse, result)
    }


}