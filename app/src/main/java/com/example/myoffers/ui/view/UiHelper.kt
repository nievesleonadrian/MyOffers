package com.example.myoffers.ui.view

import com.example.myoffers.ui.model.UiOffer

class UiHelper {

    private var totalProducts = 0
    private var totalPrice = 0.0

    fun updateBasket(uiOffer: UiOffer, isChecked: Boolean): String {

        if (isChecked) {
            totalProducts += 1
            totalPrice += uiOffer.price
        } else {
            totalProducts -= 1
            totalPrice -= uiOffer.price
        }

        return when (totalProducts) {
            0 -> ""
            1 -> "$totalProducts selected product x CLP $totalPrice"
            else -> "$totalProducts selected products x CLP $totalPrice"
        }
    }
}
