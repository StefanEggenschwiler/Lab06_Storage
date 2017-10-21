package ch.hevs.db.sync;

import android.content.Context;
import android.os.AsyncTask;

import ch.hevs.db.AppDatabase;

public class DeleteFruits extends AsyncTask<Void, Void, Void> {

    private Context mContext;

    public DeleteFruits(Context context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        AppDatabase.getAppDatabase(mContext).fruitDao().deleteAll();
        return null;
    }
}
