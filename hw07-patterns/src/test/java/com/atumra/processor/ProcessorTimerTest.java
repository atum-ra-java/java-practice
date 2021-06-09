package com.atumra.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import com.atumra.processor.homework.ProcessorTimer;
import com.atumra.processor.homework.Processor;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessorTimerTest {

  @Test
  @DisplayName("EvenSecond")
  void processEvenSecond() {
      Processor processor = new ProcessorTimer(
              () -> LocalDateTime.of(2020, Month.JUNE, 11, 12, 10, 02)
      );
      assertThrows(IllegalStateException.class, () -> processor.process(null));
  }

  @Test
  @DisplayName("OddSecond")
  void processOddSecond() {
      Processor processor = new ProcessorTimer(
              () -> LocalDateTime.of(2021, Month.MAY, 30, 12, 10, 01)
      );
      assertDoesNotThrow(() -> processor.process(null));
  }



}