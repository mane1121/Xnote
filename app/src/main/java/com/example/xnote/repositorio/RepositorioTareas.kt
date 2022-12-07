package com.example.xnote.repositorio

import com.example.xnote.db.NoteDatabase
import com.example.xnote.model.Tarea

class RepositorioTareas(private val db: NoteDatabase) {

    suspend fun insertTarea(tarea: Tarea) = db.getNoteDao().insertarTarea(tarea)
    suspend fun deleteTarea(tarea: Tarea) = db.getNoteDao().borrarTarea(tarea)
    suspend fun updateTarea(tarea: Tarea) = db.getNoteDao().actualizarTarea(tarea)
    fun getAllTareas() = db.getNoteDao().getAllTareas()
    fun searchTarea(query: String?) = db.getNoteDao().searchTarea(query)

}

