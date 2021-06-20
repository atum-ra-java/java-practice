package ru.otus.dataprocessor;

import ru.otus.model.Measurement;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.stream.Collectors;

public class ProcessorAggregator implements Processor {

    @Override
    public Map<String, Double> process(List<Measurement> data) {

        return new TreeMap<>(data.stream().collect(Collectors.groupingBy(
            Measurement::getName, Collectors.summingDouble(Measurement::getValue)
            )));
        

        
    //     map((Measurement measure) -> {
    //         measure.getName().equals("val1")
    //     })
    //     //группирует выходящий список по name, при этом суммирует поля value
    //     return null;
    }
}
