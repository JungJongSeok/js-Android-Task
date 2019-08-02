package com.js.task.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class NonLeakHandler extends Handler {
    private WeakReference<Context> ref;
    private NonLeakHandlerCallback callback;

    public NonLeakHandler(Context context, NonLeakHandlerCallback callback) {
        ref = new WeakReference<>(context);
        this.callback = callback;
    }

    @Override
    public void handleMessage(Message msg) {
        Context context = ref.get();
        if (context != null && callback != null) {
            callback.handleMessage(msg);
        }
    }
}
