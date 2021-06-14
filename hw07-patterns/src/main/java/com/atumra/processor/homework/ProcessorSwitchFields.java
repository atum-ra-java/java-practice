package com.atumra.processor.homework;

import com.atumra.model.Message;
import com.atumra.processor.Processor;

//todo: 2. Сделать процессор, который поменяет местами значения field11 и field12
public class ProcessorSwitchFields implements Processor {
  
  @Override
  public Message process(Message message) {
      return message.toBuilder().field11(message.getField12()).field12(message.getField1()).build();
  }

}