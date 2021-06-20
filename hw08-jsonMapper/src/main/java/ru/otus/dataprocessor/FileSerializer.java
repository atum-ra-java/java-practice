package ru.otus.dataprocessor;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// import java.io.IOException;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import lombok.SneakyThrows;

public class FileSerializer implements Serializer {

    private String fileName;

    public FileSerializer(String fileName) {
        this.fileName = fileName;
    }
@SneakyThrows
    @Override
    public void serialize(Map<String, Double> data)  {
        var json = new StringBuilder("{");
        data.forEach((key, value) -> {
            json.append("\"" + key + "\":" + value + ",");
        });
        json.deleteCharAt(json.length()-1).append("}");
  
        Files.write(Paths.get(fileName), json.toString().getBytes());
        //формирует результирующий json и сохраняет его в файл
    }
}
