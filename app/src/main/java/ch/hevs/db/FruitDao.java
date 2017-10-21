package ch.hevs.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.sqlite.SQLiteConstraintException;

import java.util.List;

@Dao
public interface FruitDao {

    @Query("SELECT * FROM fruits")
    List<Fruit> getAll();

    @Query("SELECT * FROM fruits WHERE id IN (:fruitIds)")
    List<Fruit> getAllByIds(int[] fruitIds);

    @Query("SELECT * FROM fruits WHERE id = :id")
    List<Fruit> getById(int id);

    @Query("SELECT * FROM fruits WHERE fruit LIKE :fruitName LIMIT 1")
    Fruit getByName(String fruitName);

    @Insert
    void insertAll(Fruit... fruits) throws SQLiteConstraintException;

    @Update
    void updateFruits(Fruit... fruits);

    @Delete
    void delete(Fruit fruits);

    @Query("DELETE FROM fruits")
    void deleteAll();
}
