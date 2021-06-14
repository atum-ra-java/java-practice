package com.atumra.handler;

import com.atumra.model.Message;
import com.atumra.listener.Listener;

public interface Handler {
    Message handle(Message msg);

    void addListener(Listener listener);
    void removeListener(Listener listener);
}
