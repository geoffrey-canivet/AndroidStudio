package com.example.crud.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.crud.db.DbHelper
import com.example.crud.models.User

class UserDAO(context : Context) {

    // definition de la table
    companion object {
        private const val TABLE_USER = "user"
        private const val COLUMN_ID = "id"
        private const val COLUMN_LASTNAME = "lastname"
        private const val COLUMN_FIRSTNAME = "firstname"
        private const val COLUMN_REG_NAT = "reg_nat"
        // création de la table
        const val CREATE_REQUEST =
            """
            CREATE TABLE $TABLE_USER (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_LASTNAME TEXT NOT NULL,
                $COLUMN_FIRSTNAME TEXT NOT NULL,
                $COLUMN_REG_NAT TEXT UNIQUE NOT NULL
            )"""
        // maj de la db
        const val UPGRADE_REQUEST = "DROP TABLE IF EXISTS $TABLE_USER"
    }

    private var db: SQLiteDatabase? = null // selectionne la db
    private val dbHelper: DbHelper = DbHelper(context) // connection a la db

    // ouvrir la base de données en mode écriture
    fun openWritable(): UserDAO {
        db = dbHelper.writableDatabase
        return this@UserDAO
    }

    // ouvrir la base de données en mode lecture
    fun openReadable(): UserDAO {
        db = dbHelper.readableDatabase
        return this@UserDAO
    }

    // fermer la base de données
    fun close() {
        db?.close()
        dbHelper.close()
    }

    // ajouter un utilisateur à la base de données
    fun insert(user: User): Long {
        val values = ContentValues().apply {
            put(COLUMN_LASTNAME, user.lastname)
            put(COLUMN_FIRSTNAME, user.firstname)
            put(COLUMN_REG_NAT, user.regNat)
        }
        return db!!.insert(TABLE_USER, null, values)
    }

    // supprimer un utilisateur de la base de données
    fun deleteUser(id: Long) {
        db!!.delete(TABLE_USER, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }

    // modifier un utilisateur de la base de données
    fun updateUser(user: User): Long {
        val values = ContentValues().apply {
            put(COLUMN_LASTNAME, user.lastname)
            put(COLUMN_FIRSTNAME, user.firstname)
            put(COLUMN_REG_NAT, user.regNat)
        }
        return db!!.update(TABLE_USER, values, "$COLUMN_ID = ?", arrayOf(user.id.toString())).toLong()
    }

    // recherche un utilisateur par son ID
    fun getById(id: Long): User? {
        val cursor = db?.query(
            TABLE_USER,
            null,
            "$COLUMN_ID = ?",
            arrayOf(id.toString()), null, null, null)
        return if (cursor != null && cursor.moveToFirst()) {
            val user = fromCursor(cursor)
            cursor.close()
            user

        } else {
            cursor?.close()
            null
        }
    }

    // cree un objet User avec les resultats du curseur
    private fun fromCursor(cursor: Cursor): User {
        return User(
            cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
            cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTNAME)),
            cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRSTNAME)),
            cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REG_NAT))
        )
    }

    //    recuperer tous les utilisateurs de la base de données
    fun getAll(): List<User> {
        val userList = mutableListOf<User>()
        val cursor = db?.query(
            TABLE_USER, null, null, null, null, null, null
        )

        if (cursor != null && cursor.moveToFirst()) {
            do {
                userList.add(fromCursor(cursor))
            } while (cursor.moveToNext())
        }

        cursor?.close()
        return userList

    }


}