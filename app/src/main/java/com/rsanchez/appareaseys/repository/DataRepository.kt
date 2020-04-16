package com.rsanchez.appareaseys.repository


import com.rsanchez.appareaseys.interfaces.ICallRetrofit
import com.rsanchez.appareaseys.model.Person
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DataRepository {


    fun getDataFromUrl(onSuccess: (List<Person>) -> Unit, onFailure: ((Error) -> Unit)? = null) {
        val retrofit = RetrofitConfi().getConfig()
        retrofit?.let {
            val call = retrofit.create(ICallRetrofit::class.java).getDataPerson()
            call.enqueue(object : Callback<List<Person>> {
                override fun onResponse(
                    call: Call<List<Person>>,
                    response: Response<List<Person>>
                ) {
                    if (response.body() != null) {
                        onSuccess.invoke(response.body()!!)
                    } else {
                        onFailure?.invoke(Error("Datos no disponibles"))
                    }
                }

                override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                    onFailure?.invoke(Error("Datos no disponibles"))
                }
            })
        }
    }
}