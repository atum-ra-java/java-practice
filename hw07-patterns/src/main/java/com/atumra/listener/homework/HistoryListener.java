package com.atumra.listener.homework;

import com.atumra.listener.Listener;
import com.atumra.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {

    private List<Message> history;

    public HistoryListener() {
        history = new ArrayList<>();
    }

    @Override
    public void onUpdated(Message msg) {
        history.add((Message)msg.clone());
        // throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        Optional<Message>  message = history.stream()
        .filter(msg -> msg.getId() == id)
        .findFirst();

        return message;
        // throw new UnsupportedOperationException();

    }
}
