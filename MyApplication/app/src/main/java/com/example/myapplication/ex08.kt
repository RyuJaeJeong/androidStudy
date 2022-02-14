package com.example.myapplication


import android.database.sqlite.SQLiteDatabase



fun main() {
    val db: SQLiteDatabase = DBHelper(this).writableDatabase
}