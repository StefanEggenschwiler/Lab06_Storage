package ch.hevs.db.sync;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import java.util.List;

import ch.hevs.db.AppDatabase;
import ch.hevs.db.Fruit;

public class InsertFruits extends AsyncTask<String[], Void, Boolean> {

    private Context mContext;

    public InsertFruits(Context context) {
        mContext = context;
    }

    @Override
    protected Boolean doInBackground(String[]... params) {
        Boolean duplicate = false;
        for (String fruit : params[0]) {
            try {
                AppDatabase.getAppDatabase(mContext).fruitDao().insertAll(new Fruit(fruit));
            } catch (SQLiteConstraintException e) {
                duplicate = true;
            }
        }
        return duplicate;
    }
}
