package ru.otus.dataprocessor;

import ru.otus.model.Measurement;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import lombok.SneakyThrows;

public class FileLoader implements Loader {
    private final ObjectMapper mapper = new ObjectMapper()
    .registerModule(new ParameterNamesModule());
    private String fileName;

    public FileLoader(String fileName) {
        this.fileName = fileName;
    }

    @SneakyThrows
    @Override
    public List<Measurement> load() {
        // читает файл, парсит и возвращает результат

        var file = new File(fileName);
        List<Measurement> loadedMeasures = mapper.readValue(file,
            mapper.getTypeFactory().constructCollectionType(List.class, Measurement.class));

        return loadedMeasures;
    }
}
