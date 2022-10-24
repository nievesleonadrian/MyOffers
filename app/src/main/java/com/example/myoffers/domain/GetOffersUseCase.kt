package com.example.myoffers.domain

import com.example.myoffers.data.OffersRepository
import com.example.myoffers.domain.model.Offer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetOffersUseCase @Inject constructor(private val offersRepository: OffersRepository) {
    suspend fun invoke(): List<Offer> = withContext(Dispatchers.IO) {
        offersRepository.getOffers()
    }
}