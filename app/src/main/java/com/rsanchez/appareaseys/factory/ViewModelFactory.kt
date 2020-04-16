package com.rsanchez.appareaseys.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rsanchez.appareaseys.iterator.FindItemsInteractor
import com.rsanchez.appareaseys.viewmodels.ListaViewModel

class ViewModelFactory(private val findItemsInteractor: FindItemsInteractor) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListaViewModel(findItemsInteractor) as T
    }
}
