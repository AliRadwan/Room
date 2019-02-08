package com.example.wekaradwan.room2;

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
public interface CardDao {


    @Query("SELECT * FROM cards ")
    List<CardEntity> getAllCard();

    @Query("SELECT * FROM cards WHERE card_id = :id")
    CardEntity getCardById(int id);

    @Query("SELECT * FROM cards WHERE card_parent_id = :id")
    List<CardEntity> getCardsByParentId(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCard(CardEntity cardEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCared(CardEntity cardEntity);

    @Delete
    void deleteCard(CardEntity cardEntity);

    @Query("DELETE FROM cards")
    void deleteAll();



}
