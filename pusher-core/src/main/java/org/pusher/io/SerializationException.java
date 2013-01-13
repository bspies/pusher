package org.pusher.io;

/**
 * @author Brennan Spies
 */
public class SerializationException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message.
     * @param message The detail message
     */
    public SerializationException(String message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.
     * @param message The detail message
     * @param cause   the cause
     */
    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause.
     * @param cause the cause
     */
    public SerializationException(Throwable cause) {
        super(cause);
    }
}
