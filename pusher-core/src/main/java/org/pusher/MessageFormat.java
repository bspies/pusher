package org.pusher;

import javax.activation.MimeType;

/**
 * @author Brennan Spies
 */
public class MessageFormat {

    private String characterSet;
    private MimeType mimeType;

    public MessageFormat(String characterSet, MimeType mimeType) {
        this.characterSet = characterSet;
        this.mimeType = mimeType;
    }

    public MessageFormat(MimeType mimeType) {
        this(null, mimeType);
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public MimeType getMimeType() {
        return mimeType;
    }
}
