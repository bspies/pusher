package org.pusher.util;

import com.google.common.collect.Maps;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

/**
 * A set of key=value properties. Unlike {@link java.util.Properties} this
 * implementation is not synchronized.
 *
 * @author Brennan Spies
 */
public class Properties {

    private Map<String,String> propertyMap;

    /**
     * Creates an empty set of properties.
     */
    public Properties() {
        propertyMap = Maps.newHashMap();
    }

    /**
     * Creates a set of properties from the given {@code Map}.
     * @param fromMap The map of key-value properties
     */
    public Properties(Map<String,String> fromMap) {
        propertyMap = Maps.newHashMap(fromMap);
    }

    /**
     * Creates a set of properties from a JDK {@link java.util.Properties}.
     * @param javaProperties The JDK properties instance
     */
    public Properties(java.util.Properties javaProperties) {
        propertyMap = Maps.newHashMap();
        Enumeration<?> names = javaProperties.propertyNames();
        while(names.hasMoreElements()) {
            String key = names.nextElement().toString();
            propertyMap.put(key, javaProperties.getProperty(key));
        }
    }

    /**
     * Creates a set of properties from an input stream which conforms
     * to the standard Java .properties file format.
     * @param inputStream The properties input stream
     * @throws IOException If an error occurs reading the stream
     */
    public Properties(InputStream inputStream) throws IOException {
        this(loadJavaProps(inputStream));
    }

    private static java.util.Properties loadJavaProps(InputStream inputStream) throws IOException {
        java.util.Properties javaProps = new java.util.Properties();
        javaProps.load(inputStream);
        return javaProps;
    }

    /**
     * Returns the raw String property.
     * @param key The property key
     * @return The property as a String (or null if no such key exists)
     */
    public @Nullable String getProperty(String key) {
        return propertyMap.get(key);
    }

    /**
     * Gets the property value, converting it
     * @param key The property key
     * @param converter The value converter
     * @param <T> The converted value type
     * @return The value as type {@code T} (or null if no such key exists)
     */
    public @Nullable <T> T getProperty(String key, Converter<T> converter) {
        String strValue = getProperty(key);
        return strValue!=null ? converter.convert(strValue) : null;
    }

    /**
     * Sets te property key and value.
     * @param key The property key
     * @param value The property value
     */
    public void setProperty(String key, Object value) {
        if(value instanceof Date) {
            propertyMap.put(key, DateFormat.getInstance().format((Date)value));
        } else {
            propertyMap.put(key, value.toString());
        }
    }

    /**
     * Merges the two key-value sets, giving preference to keys in the
     * {@code overlay} properties.
     * @param overlay The properties to be merged with this one
     * @return The merged properties
     */
    public Properties merge(Properties overlay) {
        Properties mergedProperties = new Properties(propertyMap);
        for(Map.Entry<String,String> e : overlay.propertyMap.entrySet()) {
           mergedProperties.propertyMap.put(e.getKey(), e.getValue());
        }
        return mergedProperties;
    }
}
