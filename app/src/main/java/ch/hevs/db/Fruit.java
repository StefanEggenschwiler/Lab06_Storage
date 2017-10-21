package ch.hevs.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "fruits", indices = {@Index(value = {"fruit"}, unique = true)})
public class Fruit {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "fruit")
    private String fruitName;

    public Fruit(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
