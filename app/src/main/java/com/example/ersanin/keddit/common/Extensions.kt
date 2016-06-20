package com.example.ersanin.keddit.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Ersanin on 20.06.2016.
 */
class Extensions {
    fun ViewGroup.inflate(layoutId: Int): View {
        return LayoutInflater.from(context).inflate(layoutId, this, false)
    }
}