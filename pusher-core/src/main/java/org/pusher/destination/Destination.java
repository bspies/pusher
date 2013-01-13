package org.pusher.destination;

import org.pusher.api.Identifiable;
import org.pusher.api.Recipient;

import javax.activation.MimeType;

/**
 * @author Brennan Spies
 */
public interface Destination extends Identifiable {
    /**
     * Returns the owner of this destination.
     * @return The owning recipient
     */
    public Recipient getOwner();

    /**
     * Returns the default message format for this
     * destination.
     * @return The MIME type of the format
     */
    public MimeType getMessageFormat();

    /**
     * Returns a short description of this destination.
     * @return The description
     */
    public String getDescription();
}
