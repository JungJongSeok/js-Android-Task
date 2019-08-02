package com.js.task.asynctask;

import android.content.Context;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

public class NonLeakAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private WeakReference<Context> ref;
    private NonLeakAsyncTaskCallback<Params, Progress, Result> callback;

    public NonLeakAsyncTask(Context context, NonLeakAsyncTaskCallback<Params, Progress, Result> callback) {
        ref = new WeakReference<>(context);
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        Context context = ref.get();
        if (context != null && callback != null) {
            super.onPreExecute();
            callback.onPreExecute();
        }
    }

    @Override
    protected void onPostExecute(Result result) {
        Context context = ref.get();
        if (context != null && callback != null) {
            super.onPostExecute(result);
            callback.onPostExecute(result);
        }
    }

    @Override
    protected void onProgressUpdate(Progress[] progresses) {
        Context context = ref.get();
        if (context != null && callback != null) {
            super.onProgressUpdate(progresses);
            callback.onProgressUpdate(progresses);
        }
    }

    @Override
    protected Result doInBackground(Params[] params) {
        Context context = ref.get();
        if (context != null && callback != null) {
            return callback.doInBackground(params);
        }
        return null;
    }
}
