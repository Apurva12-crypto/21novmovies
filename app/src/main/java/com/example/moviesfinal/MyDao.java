package com.example.moviesfinal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao  {

    @Query("SELECT * FROM Movies_Table ORDER BY id ")
    LiveData<List<TaskEntry>> getAllMovies();


   @Insert
    void insertTask(TaskEntry taskEntry);

   @Update(onConflict = OnConflictStrategy.REPLACE)
   void updateTask(TaskEntry taskEntry);

   @Delete
    void onDeleteTask(TaskEntry taskEntry);

    @Query("SELECT * FROM Movies_Table WHERE id = :id")
    LiveData<TaskEntry> loadTaskById(int id);

    @Query("DELETE FROM Movies_Table")
    void deleteAll();


}
