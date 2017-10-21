package ch.hevs.db.sync;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import ch.hevs.db.AppDatabase;
import ch.hevs.db.Fruit;

public class GetFruits extends AsyncTask<Void, Void, List<Fruit>> {

    private Context mContext;

    public GetFruits(Context context) {
        mContext = context;
    }

    @Override
    protected List<Fruit> doInBackground(Void... params) {
        return AppDatabase.getAppDatabase(mContext).fruitDao().getAll();
    }
}
