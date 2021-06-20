package ru.otus.dataprocessor;

@FunctionalInterface
public interface Command {
    String execute();
}