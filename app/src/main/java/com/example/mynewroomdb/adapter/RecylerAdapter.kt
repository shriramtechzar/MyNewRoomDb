package com.example.mynewroomdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewroomdb.R
import com.example.mynewroomdb.database.DatabaseEntityModel
import kotlinx.android.synthetic.main.note_layout.view.*

class RecylerAdapter(private val notesArrayList:List<DatabaseEntityModel>) : RecyclerView.Adapter<RecylerAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_layout, parent, false)
        )
    }

    override fun getItemCount() = notesArrayList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.text_view_title.text = notesArrayList[position].title
        holder.view.text_view_note.text = notesArrayList[position].note


    }

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}