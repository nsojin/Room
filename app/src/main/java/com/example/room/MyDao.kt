package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Query("SELECT * FROM student_table")
    fun getAllStudents() : LiveData<List<Student>>

    @Query("SELECT * FROM student_table WHERE name = :sname")
    fun getStudentByName(sname : String) : List<Student>

    @Delete
    fun deleteStudent(student : Student);
}