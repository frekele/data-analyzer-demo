package org.frekele.demo.data.analyzer.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerExceptionTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void constructorWithSuccessTest() {
        String msg = "Error test";
        DataAnalyzerException exception = new DataAnalyzerException(msg);
        assertEquals(msg, exception.getMessage());
    }

    @Test
    public void constructorWithSuccessTest2() {
        NullPointerException npe = new NullPointerException();
        DataAnalyzerException exception = new DataAnalyzerException(npe);
        assertEquals(npe, exception.getCause());
    }

    @Test
    public void constructorWithSuccessTest3() {
        String msg = "Error test";
        NullPointerException npe = new NullPointerException();
        DataAnalyzerException exception = new DataAnalyzerException(msg, npe);
        assertEquals(msg, exception.getMessage());
        assertEquals(npe, exception.getCause());
    }

}