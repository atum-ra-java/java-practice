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
        
        System.out.println("JSON" + json.toString());

        //var fullOutputFilePath = String.format("%s%s%s",tempDir, File.separator, "outputData.json");
        Files.write(Paths.get(fileName), json.toString().getBytes());
        // var jsonObject = Json.createObjectBuilder();
        // data.forEach(jsonObject::add);
        // jsonObject.build();
        // System.out.println("jsonObject:" + jsonObject.toString() + "\n");

        // try (FileWriter fw = new FileWriter("outputdata.json"); JsonWriter jsonWriter = Json.createWriter(fw);) {
        //     jsonWriter.writeObject(jsonObject);
        //     }
       
        //формирует результирующий json и сохраняет его в файл
    }
}
