package com.amitgupta.notesapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amitgupta.notesapp.entity.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun repoDao(): RepoDao

    companion object {

        private var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "note.db"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return appDatabase!!
        }

    }

}