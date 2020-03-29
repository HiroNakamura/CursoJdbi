package com.inforhomex;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MainTest{

    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(5, calculator.add(4, 1),"Deberia ser 5");
    }

    @DisplayName("Test MainTest.testAdd()")
    @Test
    public void testAdd() {
        assertEquals(48, Integer.sum(4,44),"Deberia ser 48");
    }

}

class Calculator{
   static int add(int x, int y){
       return x + y;
   }
}