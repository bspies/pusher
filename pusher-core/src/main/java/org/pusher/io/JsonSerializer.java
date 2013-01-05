package org.pusher.io;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Brennan Spies
 */
public class JsonSerializer implements Serializer {

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Serializes the data to JSON.
     * @param data The object to be serialized
     * @param writer The writer for the serialized data
     */
    public void serialize(Object data, Writer writer) {
        try {
            mapper.writeValue(writer, data);
        } catch (IOException e) {
            e.printStackTrace();  //Todo
        }
    }
}
