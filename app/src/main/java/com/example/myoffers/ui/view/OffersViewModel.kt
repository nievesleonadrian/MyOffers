package com.example.myoffers.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myoffers.domain.GetOffersUseCase
import com.example.myoffers.ui.model.UiOffer
import com.example.myoffers.ui.model.UiOfferMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
    private val loadOffers: GetOffersUseCase,
    private val uiOfferMapper: UiOfferMapper,
    private val messageGenerator: UiHelper
) : ViewModel() {

    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible

    private val _offers = MutableLiveData<List<UiOffer>>()
    val offers: LiveData<List<UiOffer>> get() = _offers

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    fun onCreate() {
        viewModelScope.launch {
            _progressVisible.value = true
            _offers.postValue(with(uiOfferMapper) { loadOffers.invoke().fromDomainToUi() })
            _progressVisible.value = false
        }
    }

    fun onOfferCheckedChange(uiOffer: UiOffer, isChecked: Boolean) {
        _message.value = messageGenerator.updateBasket(uiOffer, isChecked)
    }
}