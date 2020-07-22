package com.amitgupta.notesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amitgupta.notesapp.R
import com.amitgupta.notesapp.entity.Note
import com.amitgupta.notesapp.utils.Utils
import kotlinx.android.synthetic.main.adapter_note_recycler_view_items.view.*

class NoteRecyclerViewAdapter(val context: Context?, var notes: List<Note>?) :
    RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {

    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.adapter_note_recycler_view_items, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return notes!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun setNotifyData(notes: List<Note>?) {
        this.notes = notes

        notifyDataSetChanged()
    }

}