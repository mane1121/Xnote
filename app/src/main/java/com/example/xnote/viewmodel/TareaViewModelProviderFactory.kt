package com.example.xnote.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xnote.repositorio.RepositorioTareas

class TareaViewModelProviderFactory(
    val app: Application,
    private val repositorioTareas: RepositorioTareas
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TareaViewModel(app, repositorioTareas) as T
    }
}