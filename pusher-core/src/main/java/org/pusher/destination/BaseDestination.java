package org.pusher.destination;

import org.pusher.MessageFormat;
import org.pusher.Recipient;

import javax.activation.MimeType;

/**
 * Base implmentation of a destination.
 *
 * @author Brennan Spies
 */
public abstract class BaseDestination implements Destination {

    private Recipient owner;
    private MessageFormat messageFormat;
    private String description;
    private String destinationId;

    /**
     * Returns the owner of this destination.
     * @return The owning recipient
     */
    public Recipient getOwner() {
        return owner;
    }

    /**
     * Returns the default message format for this
     * destination.
     * @return The MIME type of the format
     */
    public MessageFormat getMessageFormat() {
        return messageFormat;
    }

    /**
     * Returns a short description of this destination.
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the identifier.
     *
     * @return The identifier
     */
    public String getId() {
        return destinationId;
    }
}
