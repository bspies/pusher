package org.pusher.api;

import java.io.Serializable;

/**
 * @author Brennan Spies
 */
public interface Identifiable {
    /**
     * Returns the identifier.
     * @return The identifier
     */
    public String getId();
}