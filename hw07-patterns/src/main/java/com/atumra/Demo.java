package com.atumra;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.atumra.handler.ComplexProcessor;
import com.atumra.listener.ListenerPrinterConsole;
import com.atumra.listener.homework.HistoryListener;
import com.atumra.model.Message;
import com.atumra.model.ObjectForMessage;
import com.atumra.processor.LoggerProcessor;
import com.atumra.processor.Processor;
import com.atumra.processor.ProcessorConcatFields;
import com.atumra.processor.ProcessorUpperField10;
import com.atumra.processor.homework.ProcessorTimer;

public class Demo {
    public static void main(String[] args) {

        List<Processor> processors =  List.of(
            new ProcessorConcatFields(),
            new LoggerProcessor(new ProcessorUpperField10()),
            (Processor) new ProcessorTimer(() -> LocalDateTime.of(2020, Month.JUNE, 11, 12, 10, 02))
        );

        var complexProcessor = new ComplexProcessor(processors, ex -> {});
        var listenerPrinter = new ListenerPrinterConsole();
        var historyListener = new HistoryListener();
        var field13 = new ObjectForMessage();
        field13.setData(new ArrayList<>());

        complexProcessor.addListener(listenerPrinter);
        complexProcessor.addListener(historyListener);

        var message = new Message.Builder(1L)
                .field1("field1")
                .field2("field2")
                .field3("field3")
                .field6("field6")
                .field10("field10")
                .field11("field11")
                .field12("field12")
                .field13(field13)
                .build();

        var result = complexProcessor.handle(message);
        System.out.println("result:" + result);

        complexProcessor.removeListener(listenerPrinter);
        complexProcessor.removeListener(historyListener);

    }
}
