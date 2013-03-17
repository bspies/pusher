package org.pusher;

import javax.activation.MimeType;

/**
 * Class describing the format of the notification to be sent to the
 * {@link org.pusher.destination.Destination Destination}.
 *
 * @author Brennan Spies
 */
public class MessageFormat {

    private String characterSet;
    private MimeType mimeType;

    /**
     * Creates a message format with the desired character encoding and
     * MIME type of the notification.
     * @param characterSet The character encoding of the notification
     * @param mimeType The MIME type of the notification
     */
    public MessageFormat(String characterSet, MimeType mimeType) {
        this.characterSet = characterSet;
        this.mimeType = mimeType;
    }

    /**
     * Creates a message format with the desired MIME type of the notification.
     * @param mimeType The MIME type
     */
    public MessageFormat(MimeType mimeType) {
        this(null, mimeType);  //todo default charset?
    }

    /**
     * Returns the character set encoding of the format.
     * @return The character set
     */
    public String getCharacterSet() {
        return characterSet;
    }

    /**
     * Returns the MIME type of the message format.
     * @return The MIME type
     */
    public MimeType getMimeType() {
        return mimeType;
    }

    /**
     * Returns a representation of this message format as
     * a "Content-Type" HTTP header.
     * @return The message format as "Content-Type" header
     */
    public String asContentType() {
        return String.format("%; charset=%s", mimeType, characterSet); //todo handle charset null/default
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageFormat that = (MessageFormat) o;
        return !(characterSet != null ? !characterSet.equals(that.characterSet) : that.characterSet != null)
                && mimeType.equals(that.mimeType);

    }

    @Override
    public int hashCode() {
        int result = characterSet != null ? characterSet.hashCode() : 0;
        result = 31 * result + mimeType.hashCode();
        return result;
    }
}
