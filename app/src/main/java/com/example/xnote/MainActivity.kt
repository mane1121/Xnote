package com.example.xnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.xnote.databinding.ActivityMainBinding
import com.example.xnote.db.NoteDatabase
import com.example.xnote.repositorio.RepositorioNotas
import com.example.xnote.repositorio.RepositorioTareas
import com.example.xnote.viewmodel.NoteViewModel
import com.example.xnote.viewmodel.NoteViewModelProviderFactory
import com.example.xnote.viewmodel.TareaViewModel
import com.example.xnote.viewmodel.TareaViewModelProviderFactory

class MainActivity : AppCompatActivity() {


    lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel
    lateinit var tareaViewModel: TareaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setUpViewModel()
        setUpViewModelTarea()

    }

    /*override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.updateNoteFragment) {
            this.toast("No Updates")
        }
        super.onBackPressed()
    }*/

    private fun setUpViewModel() {
        val noteDataBase = NoteDatabase.getInstance(this)
        val noteRepository = RepositorioNotas(
            noteDataBase
        )

        val viewModelProviderFactory = NoteViewModelProviderFactory(
            application,
            noteRepository
        )

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        )
            .get(NoteViewModel::class.java)
    }

    private fun setUpViewModelTarea() {
        val tareaDataBase = NoteDatabase.getInstance(this)
        val tareaRepository = RepositorioTareas(
            tareaDataBase
        )

        val viewModelProviderFactory = TareaViewModelProviderFactory(
            application,
            tareaRepository
        )

        tareaViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        )
            .get(TareaViewModel::class.java)
    }
}