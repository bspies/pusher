package org.pusher;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

/**
 * Class describing the format of the notification to be sent to the
 * {@link org.pusher.destination.Destination Destination}.
 *
 * @author Brennan Spies
 */
public class MessageFormat {

    private static final String ENCODING_PARAM = "encoding";
    private MimeType mimeType;

    /**
     * Creates a message format with the desired character encoding and
     * MIME type of the notification.
     * @param mimeType The MIME type of the notification
     * @param characterSet The character encoding of the notification
     */
    public MessageFormat(MimeType mimeType, String characterSet) {
        this.mimeType = mimeType;
        mimeType.setParameter(ENCODING_PARAM, characterSet);
    }

    /**
     * Creates a message format with the desired MIME type of the notification.
     * @param mimeType The MIME type
     */
    public MessageFormat(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    public MessageFormat(String stringToParse) {
        try {
            this.mimeType = new MimeType(stringToParse);
        } catch (MimeTypeParseException e) {
            throw new IllegalArgumentException("Invalid MIME type format: " + stringToParse, e);
        }
    }

    /**
     * Returns the character set encoding of the format.
     * @return The character set
     */
    public String getCharacterEncoding() {
        return mimeType.getParameter(ENCODING_PARAM);
    }

    public void setCharacterEncoding(String charset) {
        mimeType.setParameter(ENCODING_PARAM, charset);
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
        return mimeType.toString();
    }

    @Override
    public String toString() {
        return asContentType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageFormat that = (MessageFormat) o;
        return mimeType.equals(that.mimeType);

    }

    @Override
    public int hashCode() {
        return mimeType.hashCode();
    }
}
