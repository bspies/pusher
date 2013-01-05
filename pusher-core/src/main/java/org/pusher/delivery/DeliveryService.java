package org.pusher.delivery;

import org.pusher.api.Destination;

/**
 * @author Brennan Spies
 */
public interface DeliveryService<D extends Destination> {
    /**
     * Sends the notification to the given destinations.
     * @param notification The notification to be sent
     * @param destinations The destinations to which the notification is sent
     */
    public void send(Object notification, Iterable<D> destinations);
}
