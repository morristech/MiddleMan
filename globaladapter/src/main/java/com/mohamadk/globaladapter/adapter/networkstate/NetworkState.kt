package com.mohamadk.globaladapter.adapter.networkstate

import android.content.Context
import android.view.View
import com.mohamadk.globaladapter.R
import com.mohamadk.globaladapter.adapter.model.BaseModel
import kotlinx.android.parcel.Parcelize

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

@Parcelize
data class NetworkState private constructor(
        val status: Status,
        val msg: String? = null) : BaseModel {

    override fun defaultView(context: Context): View? {
        return null
    }

    override fun defaultResLayout(): Int? {
        return R.layout.network_state_item
    }

    override fun areContentsTheSame(newItem: BaseModel): Boolean {
        return true
    }

    override fun areItemsTheSame(newItem: BaseModel): Boolean {
        return this === newItem
    }

    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.RUNNING)
        fun error(msg: String?) = NetworkState(Status.FAILED, msg)
    }
}