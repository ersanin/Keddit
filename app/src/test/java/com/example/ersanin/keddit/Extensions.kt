package com.example.ersanin.keddit

import org.mockito.Mockito

/**
 * Created by Ersanin on 24.06.2016.
 */
inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)