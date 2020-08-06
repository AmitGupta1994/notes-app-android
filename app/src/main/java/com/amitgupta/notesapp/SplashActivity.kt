package com.amitgupta.notesapp

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.amitgupta.notesapp.adapter.NoteRecyclerViewAdapter
import com.amitgupta.notesapp.room.DatabaseService

class SplashActivity : AppCompatActivity() {

    lateinit var databaseService: DatabaseService

    private lateinit var noteRecyclerViewAdapter: NoteRecyclerViewAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            MainActivity.start(this)
        }, 1000)
    }

}

