package com.rsanchez.appareaseys.viewmodels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rsanchez.appareaseys.iterator.FindItemsInteractor
import com.rsanchez.appareaseys.model.Person
import java.lang.Error

class ListaViewModel(private val findItemsInteractor: FindItemsInteractor) : ViewModel(){

    private val listPerson = MutableLiveData<List<Person>>()
    private val errorConect = MutableLiveData<Error>()

   fun setListPerson(lista : List<Person>){
       listPerson.value = lista
   }

   fun getListData(): MutableLiveData<List<Person>>{
       return listPerson
   }

   fun setErrorConnect(error : Error){
       errorConect.value = error
   }

   fun getErrorConect() : MutableLiveData<Error>{
       return errorConect
   }


    fun callListData() {
         findItemsInteractor.findDataPerson(onSuccess = {list ->
          setListPerson(list)
        },onFailure = {
            onErrror -> setErrorConnect(onErrror)
        })
    }
}