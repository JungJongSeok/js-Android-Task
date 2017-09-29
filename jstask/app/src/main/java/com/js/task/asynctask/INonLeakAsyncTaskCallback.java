package com.js.task.asynctask;

public interface INonLeakAsyncTaskCallback<Params, Result> {
    Result doInBackground(Params[] params);
}