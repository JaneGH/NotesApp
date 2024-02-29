package com.itclimb.notesapp.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.itclimb.notesapp.database.NoteDatabase
import com.itclimb.notesapp.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)

    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    fun getAllNotes(): LiveData<List<Note>> =   db.getNoteDao().getAllNotes()

    fun searchNote(query:String?): LiveData<List<Note>> = db.getNoteDao().searchNote(query)


}