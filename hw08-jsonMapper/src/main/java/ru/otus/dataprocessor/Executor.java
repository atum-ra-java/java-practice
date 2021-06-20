package ru.otus.dataprocessor;

import java.util.ArrayList;
import java.util.List;

public class Executor {

  private final List<Command> commands = new ArrayList<>();

  void addCommand(Command command) {
      commands.add(command);
  }

  void executeCommands() {
      commands.stream().map(cmd -> cmd.execute())
        .forEach(n -> System.out.println(n + 
        " as a " + n.getClass().getName()));   
  }

}