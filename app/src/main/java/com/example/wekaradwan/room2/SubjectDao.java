package com.example.wekaradwan.room2;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by weka radwan on 2/8/2019.
 */

@Dao
public interface SubjectDao {

    @Query("SELECT * FROM subjects")
    LiveData<List<SubjectEntity>> getAllSubject();

    @Query("SELECT * FROM subjects WHERE subject_id = :id")
    LiveData<SubjectEntity> getSubjectById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSubject(SubjectEntity subjectEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateSubject(SubjectEntity subjectEntity);

    @Delete
    void deleteSubject(SubjectEntity subjectEntity);

    @Query("DELETE FROM subjects")
    void deleteAll();

}
