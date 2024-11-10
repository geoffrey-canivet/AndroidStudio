package com.example.crud.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.crud.dao.UserDAO

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "pattern_dao.db"
        private const val DATABASE_VERSION = 1
    }
    // Initialisation de la structure de la db
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(UserDAO.CREATE_REQUEST) // verifie si db est null puis execute req de UserDAO
    }
    // Maj de la structure de la db - si newVersion > oldVersion
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(UserDAO.UPGRADE_REQUEST) // modifier supprimer des table
        onCreate(db)
    }


}