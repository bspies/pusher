package org.pusher.io;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.Writer;

/**
 * @author Brennan Spies
 */
public class XmlSerializer implements Serializer {
    /**
     * Serializes the data to XML.
     * @param data   The object to be serialized
     * @param writer The writer for the serialized data
     */
    public void serialize(Object data, Writer writer) {
        try {
            JAXBContext context = JAXBContext.newInstance(data.getClass());
            Marshaller m  = context.createMarshaller();
            m.marshal(data, writer);
        } catch (JAXBException e) {
            e.printStackTrace();  //Todo
        }
    }
}
