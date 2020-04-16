package com.rsanchez.appareaseys.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitConfi {
    lateinit var retrofit: Retrofit

    fun getConfig(): Retrofit {

        retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }


}