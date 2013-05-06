package org.pusher.notification;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Standard notification for the Apple Push Notification Service.
 *
 * @author Brennan Spies
 */
public class APNSNotification {

    @JsonProperty("aps")
    private Payload payload;
    @JsonProperty("mdm")
    @JsonInclude(Include.NON_NULL)
    private String mobileDeviceManagement;
    private Map<String,Object> customFields
            = Maps.newHashMap();

    /**
     * Creates the APNS push notification with the given
     * alert body.
     * @param body The alert body
     */
    public APNSNotification(String body) {
        this.payload = new Payload(body);
    }

    /**
     * A key to an alert-message string in a {@code Localizable.strings} file for the current
     * localization (which is set by the user’s language preference). The key string
     * can be formatted with %@ and %n$@ specifiers, which are substituted with the
     * values of the {@code args}.
     * @param localizedKey The message key
     * @param localizedArguments The arguments to format the %@ and %n$@ specifiers
     */
    public APNSNotification(String localizedKey, Collection<String> localizedArguments) {
        this.payload = new Payload(localizedKey, localizedArguments);
    }

    /**
     * Returns the main payload of the notification.
     * @return The main push payload
     */
    public Payload getPayload() {
        return payload;
    }

    /**
     * Returns the mobile device management key.
     * @return The mobile device managament key
     */
    public String getMobileDeviceManagement() {
        return mobileDeviceManagement;
    }

    /**
     * Sets the mobile device management key.
     * @param mdm The key
     */
    public void setMobileDeviceManagement(String mdm) {
        mobileDeviceManagement = mdm;
    }

    /**
     * Returns the custom fields for the notification.
     * @return The custom fields
     */
    @JsonAnyGetter
    public Map<String,Object> getCustomFields() {
        return customFields;
    }

    /**
     * Sets a custom field on the notification.
     * @param fieldName The field name
     * @param value The field value
     */
    @JsonAnySetter
    public void setCustomField(String fieldName, Object value) {
        customFields.put(fieldName, value);
    }

    /**
     * Sets the sound of the notification alert.
     * @param sound The sound to be played
     */
    public void setSound(String sound) {
        payload.setSound(sound);
    }

    /**
     * The number to display as the badge of the application icon.
     * If this property is absent, the badge is not changed. To remove
     * the badge, set the value of this property to 0.
     * @param badge The number to be displayed in the badge, 0 for no badge
     */
    public void setBadge(int badge) {
        payload.setBadge(badge);
    }

    /**
     * Sets the action key for the notification. This string is used as a key
     * to get a localized string in the current localization to use for the right
     * button’s title instead of “View”. If the value is null, the system displays
     * an alert with a single OK button that simply dismisses the alert when tapped.
     * @param actionKey The key
     */
    public void setActionKey(String actionKey) {
        payload.getAlert().setActionKey(actionKey);
    }

    /**
     * The filename of an image file in the application bundle (it may include the
     * extension or omit it) to display. If this property is not specified, the system either
     * uses the previous snapshot, uses the image identified by the UILaunchImageFile key in
     * the application’s Info.plist file, or falls back to {@code Default.png}.
     * @param imageFile The image file name
     */
    public void setLaunchImage(String imageFile) {
        payload.getAlert().setLaunchImage(imageFile);
    }

    /////////////////////////////////////////////////////////
    // Utility classes to represent JSON structure.
    /////////////////////////////////////////////////////////

    /**
     * The main payload of the notification.
     */
    private static class Payload {
        @JsonProperty
        private Alert alert;
        @JsonProperty
        @JsonInclude(Include.NON_NULL)
        private String sound;
        @JsonProperty
        @JsonInclude(Include.NON_NULL)
        private Integer badge;

        Payload(String body) {
            alert = new Alert(body);
        }

        Payload(String key, Collection<String> arguments) {
            alert = new Alert(key, arguments);
        }

        Alert getAlert() { return alert; }

        //the sound for the notification
        String getSound() { return sound; }
        void setSound(String sound) { this.sound = sound; }

        //the badge number
        int getBadge() { return badge; }
        void setBadge(int badge) { this.badge = badge; }
    }

    /**
     * The notification alert.
     */
    private static class Alert {

        @JsonProperty
        @JsonInclude(Include.NON_NULL)
        private String body;
        @JsonProperty("action-loc-key")
        @JsonInclude(Include.NON_NULL)
        private String actionKey;
        @JsonProperty("loc-key")
        @JsonInclude(Include.NON_NULL)
        private String localizedKey;
        @JsonProperty("loc-args")
        @JsonInclude(Include.NON_EMPTY)
        private Collection<String> localizedArguments
                = Lists.newArrayList();
        @JsonProperty("launch-image")
        @JsonInclude(Include.NON_NULL)
        private String launchImage;

        Alert(String body) {
           this.body = body;
        }

        Alert(String key, Collection<String> arguments) {
           this.localizedKey = key;
           this.localizedArguments = arguments;
        }

        String getBody() { return body; }

        String getActionKey() { return actionKey; }
        void setActionKey(String actionKey) { this.actionKey = actionKey; }

        String getLocalizedKey() { return localizedKey; }

        Collection<String> getLocalizedArguments() { return localizedArguments; }

        String getLaunchImage() { return  launchImage; }
        void setLaunchImage(String launchImage) { this.launchImage = launchImage; }
    }
}
