package com.atumra.processor.homework;

import com.atumra.model.Message;
import com.atumra.processor.Processor;

public class ProcessorTimer implements Processor {

    private final TimeProvider timeProvider;

    public ProcessorTimer(TimeProvider timeProvider)  {
        this.timeProvider = timeProvider;
    }

    @Override
    public Message process(Message message) {

        var second = timeProvider.getTime().getSecond();

        if (second % 2 == 0) {
            throw new IllegalStateException("Method run at even second: " + second);
        }

        return message;
    }
}

