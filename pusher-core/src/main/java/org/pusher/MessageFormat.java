package org.pusher;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import java.nio.charset.Charset;

/**
 * Class describing the format of the notification to be sent to the
 * {@link org.pusher.destination.Destination Destination}.
 *
 * @author Brennan Spies
 */
public class MessageFormat {

    private static final String ENCODING_PARAM = "charset";
    private MimeType mimeType;

    /**
     * Creates a message format with the desired character encoding and
     * MIME type of the notification.
     * @param baseType The base type (MIME type), e.g. "text/plain"
     * @param characterSet The character encoding of the notification
     */
    public MessageFormat(String baseType, Charset characterSet) {
        this(baseType);
        setCharacterEncoding(characterSet);
    }

    /**
     * Creates a message format with the desired MIME type of the notification.
     * @param mimeType The MIME type
     */
    public MessageFormat(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * Creates a message format with the desired raw string. The string must be in
     * a format consistent with a MIME type as specified in RFC 2046 and RFC 2046.
     * @param stringToParse The raw format string
     */
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

    /**
     * Sets the character encoding of the message.
     * @param charset The character set
     */
    public void setCharacterEncoding(String charset) {
        mimeType.setParameter(ENCODING_PARAM, charset);
    }

    /**
     * Sets the character encoding of the message using
     * the given {@link Charset}.
     * @param charset The character set
     */
    public void setCharacterEncoding(Charset charset) {
        setCharacterEncoding(charset.name());
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
