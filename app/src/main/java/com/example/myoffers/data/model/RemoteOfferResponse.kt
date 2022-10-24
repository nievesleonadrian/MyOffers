package com.example.myoffers.data.model

import com.example.myoffers.data.model.RemoteConstants.ITEMS
import com.example.myoffers.data.model.RemoteConstants.TOTAL
import com.google.gson.annotations.SerializedName

data class RemoteOfferResponse(
    @SerializedName(TOTAL) val total: Int?,
    @SerializedName(ITEMS) val items: List<RemoteOffer>?
)
