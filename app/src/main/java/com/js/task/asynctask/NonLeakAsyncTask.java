package com.js.task.asynctask;

import android.app.Activity;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

public  class NonLeakAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result>{
    private WeakReference<Activity> ref;
    private NonLeakAsyncTaskCallback<Params, Progress, Result> callback;

    public NonLeakAsyncTask(Activity act, NonLeakAsyncTaskCallback<Params, Progress, Result> callback) {
        ref = new WeakReference<>(act);
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        Activity act = ref.get();
        if (act != null && callback != null) {
            super.onPreExecute();
            callback.onPreExecute();
        }
    }

    @Override
    protected void onPostExecute(Result result) {
        Activity act = ref.get();
        if (act != null && callback != null) {
            super.onPostExecute(result);
            callback.onPostExecute(result);
        }
    }

    @Override
    protected void onProgressUpdate(Progress[] progresses) {
        Activity act = ref.get();
        if (act != null && callback != null) {
            super.onProgressUpdate(progresses);
            callback.onProgressUpdate(progresses);
        }
    }

    @Override
    protected Result doInBackground(Params[] params) {
        Activity act = ref.get();
        if (act != null && callback != null) {
            return callback.doInBackground(params);
        }
        return null;
    }
}
