package com.example.myoffers.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myoffers.databinding.FragmentOfferListBinding
import com.example.myoffers.ui.model.UiOffer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OfferListFragment : Fragment() {

    private var _binding: FragmentOfferListBinding? = null

    private val offersViewModel: OffersViewModel by viewModels()

    private val offerAdapter = OffersAdapter()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOfferListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        setUpObservers()
        offersViewModel.onCreate()
    }

    private fun setUpUI() {
        binding.offersRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            offerAdapter.setCallback(object : OffersAdapter.Callback {
                override fun onCheckedChanged(uiOffer: UiOffer, isChecked: Boolean) {
                    offersViewModel.onOfferCheckedChange(uiOffer, isChecked)
                }
            })
            adapter = offerAdapter
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpObservers() {
        offersViewModel.offers.observe(viewLifecycleOwner) {
            binding.offersRecyclerview.apply {
                offerAdapter.apply {
                    offers = it
                    notifyDataSetChanged()
                }
            }
        }
        offersViewModel.message.observe(viewLifecycleOwner) {
            binding.totalTextView.text = it
        }
        offersViewModel.progressVisible.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}