package com.rsanchez.appareaseys.iterator


import com.rsanchez.appareaseys.model.Person
import com.rsanchez.appareaseys.repository.DataRepository
import java.lang.Error


class FindItemsInteractor {

    fun findDataPerson(onSuccess: (List<Person>) -> Unit, onFailure: ((Error) -> Unit)? = null) {
        DataRepository().getDataFromUrl(
            onSuccess = { list ->
                onSuccess.invoke(list)
            },
            onFailure = { onError ->
                onFailure?.invoke(onError)
            })
    }
}