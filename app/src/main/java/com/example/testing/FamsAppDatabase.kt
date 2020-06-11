package com.example.testing

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.t3k.mobile.fams.app.roomdatabase.daos.*

@Database(
    entities = [ServerSettingEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FamsAppDatabase : RoomDatabase() {
    abstract fun serverSettingDao(): ServerSettingDao

    companion object {
        @Volatile
        var INSTANCE: FamsAppDatabase? = null
        fun getFAMSDB(context: Context): FamsAppDatabase? {
            if (INSTANCE == null) {
                synchronized(this)
                {
                    INSTANCE =
                        Room.databaseBuilder(context, FamsAppDatabase::class.java, "fams_app.db")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE
        }
    }

    fun destoryFAMSDB() {
        INSTANCE = null
    }

}