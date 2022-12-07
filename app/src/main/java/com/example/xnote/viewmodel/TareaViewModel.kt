package com.example.xnote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.xnote.model.Tarea
import com.example.xnote.repositorio.RepositorioTareas
import kotlinx.coroutines.launch

class TareaViewModel(
    app: Application,
    private val repositorioTareas: RepositorioTareas
) : AndroidViewModel(app) {
    fun agregarTarea(tarea: Tarea) =
        viewModelScope.launch {
            repositorioTareas.insertTarea(tarea)
        }
    fun borrarTarea(tarea: Tarea) =
        viewModelScope.launch {
            repositorioTareas.deleteTarea(tarea)
        }
    fun actualizarTarea(tarea: Tarea) =
        viewModelScope.launch {
            repositorioTareas.updateTarea(tarea)
        }
    fun getAllTarea() = repositorioTareas.getAllTareas()
    fun buscarTarea(query: String?) =
        repositorioTareas.searchTarea(query)
}