package org.frekele.demo.data.analyzer.exception;

public class DataAnalyzerException extends RuntimeException {

    public DataAnalyzerException(Throwable cause) {
        super(cause);
    }

    public DataAnalyzerException(String message) {
        super(message);
    }

    public DataAnalyzerException(String message, Throwable cause) {
        super(message, cause);
    }
}