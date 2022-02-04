package com.ervin.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FixtureTest {


        Calculator calculator;

        @BeforeEach
        public void setUp() {
            this.calculator = new Calculator();
        }

        @AfterEach
        public void tearDown() {
            this.calculator = null;
        }

        @Test
        void testAdd() {
            assertEquals(100, this.calculator.add(100));
            assertEquals(150, this.calculator.add(50));
            assertEquals(130, this.calculator.add(-20));
        }

        @Test
        void testSub() {
            assertEquals(-100, this.calculator.sub(100));
            assertEquals(-150, this.calculator.sub(50));
            assertEquals(-130, this.calculator.sub(-20));
        }

}

class Calculator {
    private long n = 0;

    public long add(long x) {
        n = n + x;
        return n;
    }

    public long sub(long x) {
        n = n - x;
        return n;
    }
}