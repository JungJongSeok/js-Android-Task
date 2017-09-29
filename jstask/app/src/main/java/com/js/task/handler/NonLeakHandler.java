package com.js.task.handler;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class NonLeakHandler extends Handler {
    private WeakReference<Activity> ref;
    private NonLeakHandlerCallback callback;

    public NonLeakHandler(Activity act, NonLeakHandlerCallback callback) {
        ref = new WeakReference<>(act);
        this.callback = callback;
    }

    @Override
    public void handleMessage(Message msg) {
        Activity act = ref.get();
        if (act != null && callback != null) {
            callback.handleMessage(msg);
        }
    }
}
