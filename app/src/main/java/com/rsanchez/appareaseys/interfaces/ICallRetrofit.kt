package com.rsanchez.appareaseys.interfaces


import com.rsanchez.appareaseys.model.Person
import retrofit2.Call
import retrofit2.http.GET

interface ICallRetrofit {

    @GET("5e972b443000008c00b6dc60")
    fun getDataPerson(): Call<List<Person>>
}