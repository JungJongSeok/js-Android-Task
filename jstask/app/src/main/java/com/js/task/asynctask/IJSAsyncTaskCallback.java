package com.js.task.asynctask;

public interface IJSAsyncTaskCallback<Params, Result> {
    Result doInBackground(Params[] params);
}