package com.mobiquityinc.exception;

public class TestCaseTransformerException extends RuntimeException {
    public TestCaseTransformerException(final String message, final Exception e) {
        super(message, e);
    }
}
