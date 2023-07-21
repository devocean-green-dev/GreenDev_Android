package com.example.greendev.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.greendev.adapter.BadgeData
import com.example.greendev.adapter.BadgeRecyclerViewAdapter
import com.example.greendev.adapter.ItemTouchCallback
import com.example.greendev.R
import com.example.greendev.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val item = ArrayList<BadgeData>()
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))
        item.add(BadgeData(requireActivity().getDrawable(R.drawable.badge_sample)!!))

        val adapter = BadgeRecyclerViewAdapter(item)
        binding.badgeItemRecyclerView.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(ItemTouchCallback(adapter))
        itemTouchHelper.attachToRecyclerView(binding.badgeItemRecyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}