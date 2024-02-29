package com.itclimb.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import com.itclimb.notesapp.database.NoteDatabase
import com.itclimb.notesapp.databinding.ActivityMainBinding
import com.itclimb.notesapp.repository.NoteRepository
import com.itclimb.notesapp.viewmodel.NoteViewModel
import com.itclimb.notesapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory)
            .get(NoteViewModel::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}