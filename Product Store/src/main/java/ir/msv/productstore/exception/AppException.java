package ir.msv.productstore.exception;

import lombok.Getter;

/**
 * @author Negin Mousavi 1/23/2025 - Thursday
 */
@Getter
public class AppException extends RuntimeException {
    private final String message;

    public AppException(String message) {
        this.message = message;
    }
}
