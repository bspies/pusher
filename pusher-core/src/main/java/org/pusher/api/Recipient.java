package org.pusher.api;

import org.pusher.destination.Destination;

import java.util.Collection;

/**
 * @author Brennan Spies
 */
public interface Recipient extends Identifiable {
    /**
     * Returns all destinations associated with this
     * recipient.
     * @return All recipient destinations
     */
    public Collection<Destination> getDestinations();
}
