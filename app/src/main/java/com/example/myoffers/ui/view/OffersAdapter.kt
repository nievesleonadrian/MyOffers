package com.example.myoffers.ui.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myoffers.databinding.OfferItemBinding
import com.example.myoffers.ui.model.UiOffer
import javax.inject.Inject

class OffersAdapter @Inject constructor() : RecyclerView.Adapter<OffersAdapter.ViewHolder>() {
    var offers: List<UiOffer> = emptyList()
    private var callback: Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            OfferItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(offers[position])
        holder.addToCar(offers[position])
    }

    override fun getItemCount(): Int = offers.size

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    interface Callback {
        fun onCheckedChanged(item: UiOffer, isChecked: Boolean)
    }

    inner class ViewHolder(private val binding: OfferItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(offer: UiOffer) {
            binding.apply {
                offer.also { (title, image, price) ->
                    nameTextview.text = title
                    priceTextview.text = price(price.toString())
                    Glide.with(offerImageview.rootView.context)
                        .load(image)
                        .into(offerImageview)
                }
            }
        }

        fun addToCar(uiOffer: UiOffer) {
            binding.apply {
                offers.also {
                    offerCheckBox.setOnCheckedChangeListener { _, isChecked ->
                        callback?.onCheckedChanged(uiOffer, isChecked)
                    }
                }
            }
        }
    }

    fun price(price: String): String{
        return "$CLP $price"
    }

    companion object{
        const val CLP = "CLP"
    }
}