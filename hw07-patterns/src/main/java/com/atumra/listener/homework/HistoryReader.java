package com.atumra.listener.homework;

import com.atumra.model.Message;

import java.util.Optional;

public interface HistoryReader {

    Optional<Message> findMessageById(long id);
}
