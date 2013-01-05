package org.pusher.io;

import java.io.Writer;

/**
 * @author Brennan Spies
 */
public interface Serializer {
    /**
     * Serializes the data to the given output.
     * @param data The object to be serialized
     * @param writer The writer for the serialized data
     */
    public void serialize(Object data, Writer writer);
}
