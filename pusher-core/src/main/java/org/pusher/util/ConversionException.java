package org.pusher.util;

/**
 * @author Brennan Spies
 */
public class ConversionException extends RuntimeException {
    /**
     * Constructs the exception with a message.
     * @param message the detail message
     */
    public ConversionException(String message) {
        super(message);
    }

      /**
     * Constructs the exception with a message and a chained exception.
     *
     * @param message the detail message
     * @param cause   the cause
     */
    public ConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
