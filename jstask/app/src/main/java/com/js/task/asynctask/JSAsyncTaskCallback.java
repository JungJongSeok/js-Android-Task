package com.js.task.asynctask;

public abstract class JSAsyncTaskCallback<Params, Progress, Result> implements IJSAsyncTaskCallback<Params, Result> {
    public void onPreExecute() {}
    public void onPostExecute(Result result) {}
    public void onProgressUpdate(Progress[] progresses) {}
}