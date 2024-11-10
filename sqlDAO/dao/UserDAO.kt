package com.example.sqldemo.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.sqldemo.db.DbHelper
import com.example.sqldemo.models.User

class UserDAO (context : Context) {
    companion object{
        private const val TABLE_USER = "user"
        private const val COLUMN_ID = "id"
        private const val COLUMN_LASTNAME = "lastname"
        private const val COLUMN_FIRSTNAME = "firstname"
        private const val COLUMN_REG_NAT = "reg_nat"

        const val CREATE_REQUEST =
            """
                CREATE TABLE $TABLE_USER (
                    $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    $COLUMN_LASTNAME TEXT NOT NULL,
                    $COLUMN_FIRSTNAME INTEGER NOT NULL,
                    $COLUMN_REG_NAT TEXT NOT NULL
                )
            """

        const val UPGRADE_REQUEST = "DROP TABLE IF EXISTS $TABLE_USER"

    }


    private var db : SQLiteDatabase? = null
    private val dbHelper : DbHelper = DbHelper(context)

    fun openReadable() : UserDAO {
        db = dbHelper.readableDatabase
        return this@UserDAO
    }

    fun close(){
        db?.close()
        dbHelper.close()
    }

    //region CRUD
    fun insert(user : User) : Long{
        val values = ContentValues().apply{
            put(COLUMN_LASTNAME, user.lastName)
            put(COLUMN_FIRSTNAME, user.firstName)
            put(COLUMN_REG_NAT, user.regNat)
        }
        return db!!.insert(TABLE_USER, null, values)
    }

    fun delete(id : Long){
        db!!.delete(TABLE_USER, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }

    fun updateUser(user : User) : Long{
        val values = ContentValues().apply{
            put(COLUMN_LASTNAME, user.lastName)
            put(COLUMN_FIRSTNAME, user.firstName)
            put(COLUMN_REG_NAT, user.regNat)
        }
        return db!!.update(TABLE_USER, values, "$COLUMN_ID = ?", arrayOf(user.id.toString())).toLong()
    }

    fun getById(id : Long) : User?{
        val cursor = db!!.query(
            TABLE_USER, null, "$COLUMN_ID = ?",
            arrayOf(id.toString()), null, null, null
        )
        return if(cursor != null && cursor.moveToFirst()){
            val user = fromCursor(cursor)
            cursor.close()
            user
        }else{
            cursor?.close()
            null
        }
    }

    fun getALl() : List<User>{
        val userList = mutableListOf<User>()
        val cursor = db?.query(
            TABLE_USER, null, null, null, null, null, null)
        if(cursor != null && cursor.moveToFirst()){
            do{ userList.add(fromCursor(cursor)) } while (cursor.moveToNext())}
        cursor?.close()
        return userList
    }
    //endregion

    //region UTILS
    private fun fromCursor(cursor : Cursor) : User{
        return User(
            cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
            cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTNAME)),
            cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRSTNAME)),
            cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REG_NAT))
        )
    }
    //endregion
}