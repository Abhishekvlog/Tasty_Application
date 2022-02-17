//package com.example.tasty.model.local
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.tasty.model.remote.api.response.ItemX
//import com.example.tasty.model.remote.api.response.Result
//
//@Database(entities = [Result::class], version = 1)
//abstract class FoodDatabase() : RoomDatabase() {
//
//    abstract fun getDao(): DAO
//
//    companion object {
//        private var INSTANCE: FoodDatabase? = null
//
//        fun getDatabase(context: Context): FoodDatabase {
//            return if (INSTANCE == null) {
//                val builder = Room.databaseBuilder(context, FoodDatabase::class.java, "foodDb")
//                builder.fallbackToDestructiveMigration()
//                INSTANCE = builder.build()
//                INSTANCE!!
//            } else
//                INSTANCE!!
//        }
//    }
//}