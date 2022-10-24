package com.example.myoffers.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myoffers.factory.OffersFactory
import com.example.myoffers.domain.GetOffersUseCase
import com.example.myoffers.ui.view.OffersViewModel
import com.example.myoffers.ui.view.UiHelper
import com.example.myoffers.ui.model.UiOfferMapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class OffersViewModelTest {

    @RelaxedMockK
    private lateinit var loadOffers: GetOffersUseCase

    @RelaxedMockK
    private lateinit var uiOfferMapper: UiOfferMapper

    @RelaxedMockK
    private lateinit var messageGenerator: UiHelper

    lateinit var offersViewModel: OffersViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        offersViewModel = OffersViewModel(loadOffers, uiOfferMapper, messageGenerator)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given DomainOffer list, when onCreate, then update UiOffer list and progress value is false`() =
        runTest {
            val domainOfferList = OffersFactory.makeDomainOfferList(10)
            val uiOfferList = with(uiOfferMapper) { domainOfferList.fromDomainToUi() }

            offersViewModel.onCreate()
            coEvery { loadOffers.invoke() } returns domainOfferList

            assert(offersViewModel.offers.value == uiOfferList)
            assert(offersViewModel.progressVisible.value == false)
        }

}