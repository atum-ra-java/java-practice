package ru.otus.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.extern.jackson.Jacksonized;

//Допустим, этот класс библиотечный, его нельзя менять
// @Jacksonized
public class Measurement {

    private final String name;

    private final double value;
    @JsonCreator
    public Measurement( String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
