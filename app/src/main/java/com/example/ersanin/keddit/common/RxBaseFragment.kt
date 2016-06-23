package com.example.ersanin.keddit.common

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by Ersanin on 23.06.2016.
 */
open class RxBaseFragment() : Fragment() {

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        if (!subscriptions.isUnsubscribed) {
            subscriptions.unsubscribe()
        }
        subscriptions.clear()
    }
}