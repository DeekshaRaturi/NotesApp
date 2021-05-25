package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INotesAdapter {
    val viewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this,this)
        recycler.adapter = adapter

        viewModel.allNotes.observe(this,{list->
            list?.let {
                adapter.updateList(it)
            }
        })

        addbutton.setOnClickListener {
           insertNote()
        }
    }

    override fun onItemClicked(note: Note) {
      viewModel.deleteNote(note)
        Toast.makeText(this,"Item deleted Successfully",Toast.LENGTH_SHORT).show()
    }

    private fun insertNote(){
        val noteText = editText.text.toString().trim()
        if(noteText.isNotEmpty()){
            viewModel.addNote(Note(noteText))
            Toast.makeText(this,"Item added Successfully",Toast.LENGTH_SHORT).show()


        }

    }
}