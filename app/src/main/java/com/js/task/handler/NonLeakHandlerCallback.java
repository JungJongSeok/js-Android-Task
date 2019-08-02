package com.js.task.handler;

import android.os.Message;

public interface NonLeakHandlerCallback {
    void handleMessage(Message message);
}