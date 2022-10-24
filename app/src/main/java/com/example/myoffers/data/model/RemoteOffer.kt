package com.example.myoffers.data.model

import com.example.myoffers.data.model.RemoteConstants.OFFER_ID
import com.example.myoffers.data.model.RemoteConstants.OFFER_IMAGE
import com.example.myoffers.data.model.RemoteConstants.OFFER_PRICE
import com.example.myoffers.data.model.RemoteConstants.OFFER_TITLE
import com.google.gson.annotations.SerializedName

data class RemoteOffer(
    @SerializedName(OFFER_ID) val id: String?,
    @SerializedName(OFFER_TITLE)val title: String?,
    @SerializedName(OFFER_IMAGE) val image: String?,
    @SerializedName(OFFER_PRICE) val price: Double?
)
