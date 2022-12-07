package com.example.xnote.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xnote.model.Note
import com.example.xnote.model.Tarea
import com.example.xnote.model.Multimedia

@Database(entities = [Note::class, Tarea::class, Multimedia::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
    abstract fun MultimediaDao(): MultimediaDao

    companion object {
        private var INSTANCE: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,NoteDatabase::class.java, "note")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}