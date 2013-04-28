package org.pusher.util;

import javax.annotation.Nonnull;

/**
 * Interface for property converters.
 *
 * @author Brennan Spies
 */
public interface Converter<T> {
    /**
     * Converts the given String value into a value
     * of {@code T}.
     * @param value The String value to be converted
     * @return The value as the type {@code T}
     */
    public T convert(@Nonnull String value);
}
