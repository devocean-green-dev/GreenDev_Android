package com.example.greendev.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.greendev.adapter.CampaignData
import com.example.greendev.R
import com.example.greendev.adapter.RecordData
import com.example.greendev.adapter.RecordRecyclerViewAdapter
import com.example.greendev.adapter.CampaignRecyclerViewAdapter
import com.example.greendev.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view)
        val item = ArrayList<CampaignData>()
        val recordItem = ArrayList<RecordData>()

        //recycerview test
        item.add(CampaignData("다다익선 캠페인", "스타벅스"))
        item.add(CampaignData("다다익선 캠페인", "스타벅스"))
        item.add(CampaignData("다다익선 캠페인", "스타벅스"))
        item.add(CampaignData("다다익선 캠페인", "스타벅스"))
        item.add(CampaignData("다다익선 캠페인", "스타벅스"))
        item.add(CampaignData("다다익선 캠페인", "스타벅스"))

        recordItem.add(RecordData("2023-07-15", "다다익선 캠페인", "스타벅스"))
        recordItem.add(RecordData("2023-07-15", "다다익선 캠페인", "스타벅스"))
        recordItem.add(RecordData("2023-07-15", "다다익선 캠페인", "스타벅스"))
        recordItem.add(RecordData("2023-07-15", "다다익선 캠페인", "스타벅스"))
        recordItem.add(RecordData("2023-07-15", "다다익선 캠페인", "스타벅스"))
        recordItem.add(RecordData("2023-07-15", "다다익선 캠페인", "스타벅스"))
        recordItem.add(RecordData("2023-07-15", "다다익선 캠페인", "스타벅스"))

        val adapter = CampaignRecyclerViewAdapter(item, R.layout.main_campaign_item_layout)
        val recordAdapter = RecordRecyclerViewAdapter(recordItem)

        binding.recyclerView.adapter = adapter
        binding.recordRecyclerView.adapter = recordAdapter

        adapter.setOnItemClickListener(object : CampaignRecyclerViewAdapter.OnItemClickListener {
            @SuppressLint("ResourceType")
            override fun onItemClick(v: View, data: CampaignData, pos: Int) {
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.apply {
                    replace(R.id.frameLayout, RecordFragment())
                    addToBackStack(null)
                    commit()
                }
            }
        })
        binding.recyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}