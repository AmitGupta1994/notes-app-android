package com.amitgupta.notesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.amitgupta.notesapp.room.DatabaseService


class NoteActivity : AppCompatActivity() {

    private lateinit var databaseService: DatabaseService
    private var noteId: Int = 0

    private var mYear = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0
    private var mHour: Int = 0
    private var mMinute: Int = 0

    private var mNoteContent: String? = null
    private var mNoteCreatedAt: Long? = null

    companion object {
        var NOTE_ID: String = "noteId"

        fun start(context: Context, noteId: Int?) {
            val intent = Intent(context, NoteActivity::class.java)
            /*intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK*/
            intent.putExtra(NOTE_ID, noteId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_note, menu)

        val saveItem = menu?.findItem(R.id.action_save_note)
        val updateItem = menu?.findItem(R.id.action_update_note)
        val deleteItem = menu?.findItem(R.id.action_delete_note)

        if (noteId == 0) {
            saveItem!!.isVisible = true
            updateItem!!.isVisible = false
            deleteItem!!.isVisible = false
        } else {
            saveItem!!.isVisible = false
            updateItem!!.isVisible = true
            deleteItem!!.isVisible = true
        }

        return true
    }

}
