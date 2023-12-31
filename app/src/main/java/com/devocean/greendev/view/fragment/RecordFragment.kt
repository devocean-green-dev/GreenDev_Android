package com.devocean.greendev.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.devocean.greendev.App
import com.devocean.greendev.R
import com.devocean.greendev.adapter.RecordAdapter
import com.devocean.greendev.databinding.FragmentRecordBinding
import com.devocean.greendev.model.CampaignPost
import com.devocean.greendev.model.CampaignPostResponse
import com.devocean.greendev.model.DetailCampaignResponse
import com.devocean.greendev.model.RecordData
import com.devocean.greendev.util.BindingFragment
import com.devocean.greendev.util.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecordFragment(campaignId: Int) : BindingFragment<FragmentRecordBinding>(R.layout.fragment_record, false) {
    private var campaignId: Int? = null

    init {
        this.campaignId = campaignId
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDetail()
        getCampaignPost()

        binding?.backButton?.let { returnToPreviousFragment(it) }
        binding?.applyButton?.setOnClickListener {
            initApplyButton()
        }
    }

    private fun initRecyclerView(data: List<CampaignPost>) {
        val item = ArrayList<RecordData>()
        for (i in data) {
            item.add(RecordData(i.date.split("T")[0], i.content, i.nickname, i.postId))
        }
        val adapter = RecordAdapter(item)
        binding?.campaignRecyclerView?.adapter = adapter
    }

    private fun initApplyButton(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.apply {
            replace(R.id.frameLayout, CertificationFragment(campaignId!!))
            addToBackStack(null)
            commit()
        }
    }

    private fun getCampaignPost() {
        RetrofitBuilder.api.getCampaignPost(campaignId = campaignId!!, token = "Bearer ${App.preferences.token}")
            .enqueue(object: Callback<CampaignPostResponse>{
            override fun onResponse(call: Call<CampaignPostResponse>, response: Response<CampaignPostResponse>) {
                val data = response.body()!!.data.posts
                initRecyclerView(data)
            }

            override fun onFailure(call: Call<CampaignPostResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun getDetail() {
        RetrofitBuilder.api.getDetailCampaign(campaignId = campaignId!!, token = "Bearer ${App.preferences.token}")
            .enqueue(object: Callback<DetailCampaignResponse>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<DetailCampaignResponse>, response: Response<DetailCampaignResponse>) {
                val data = response.body()!!.data
                binding?.campaignTitle?.text = data.title
                binding?.info?.text = "${data.joinMemberCount}명이 ${data.joinCount}번 참여했어요"
            }

            override fun onFailure(call: Call<DetailCampaignResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}