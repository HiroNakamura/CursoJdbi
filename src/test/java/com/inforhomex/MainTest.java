package com.inforhomex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MainTest{

    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(5, calculator.add(1, 1));
    }

}

class Calculator{
   static int add(int x, int y){
       return x + y;
   }
}