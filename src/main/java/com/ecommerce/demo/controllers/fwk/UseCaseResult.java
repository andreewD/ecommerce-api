package com.ecommerce.demo.controllers.fwk;

import lombok.Data;

import java.util.List;

@Data
public class UseCaseResult {
    private String message;
    private StatusCode statusCode;
    private List<String> validationsErrors;
    public boolean wasSuccessful() {
        return StatusCode.SUCCESS.equals(statusCode);
    }
    public boolean hasErrors() {
        return validationsErrors != null && !validationsErrors.isEmpty();
    }
}
