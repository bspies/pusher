package org.pusher.apns.notification;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Standard push notification for the Apple Push Notification Service.
 *
 * @author Brennan Spies
 */
@JsonInclude(Include.NON_NULL)
public class PushNotification {

    @JsonProperty("aps")
    private Body body;
    @JsonProperty("mdm")
    private String mobileDeviceManagement;
    private Map<String,Object> customFields
            = Maps.newHashMap();

    /**
     * Creates the APNS push notification with the given
     * alert body.
     * @param body The alert body
     */
    public PushNotification(String body) {
        this.body = new Body(body);
    }

    /**
     * A key to an alert-message string in a {@code Localizable.strings} file for the current
     * localization (which is set by the user’s language preference). The key string
     * can be formatted with %@ and %n$@ specifiers, which are substituted with the
     * values of the {@code args}.
     * @param localizedKey The message key
     * @param localizedArguments The arguments to format the %@ and %n$@ specifiers
     */
    public PushNotification(String localizedKey, Collection<String> localizedArguments) {
        this.body = new Body(localizedKey, localizedArguments);
    }

    /**
     * Returns the main body of the notification.
     * @return The main push body
     */
    public Body getBody() {
        return body;
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
        body.setSound(sound);
    }

    /**
     * The number to display as the badge of the application icon.
     * If this property is absent, the badge is not changed. To remove
     * the badge, set the value of this property to 0.
     * @param badge The number to be displayed in the badge, 0 for no badge
     */
    public void setBadge(int badge) {
        body.setBadge(badge);
    }

    /**
     * Sets the action key for the notification. This string is used as a key
     * to get a localized string in the current localization to use for the right
     * button’s title instead of “View”. If the value is null, the system displays
     * an alert with a single OK button that simply dismisses the alert when tapped.
     * @param actionKey The key
     */
    public void setActionKey(String actionKey) {
        body.getAlert().setActionKey(actionKey);
    }

    /**
     * The filename of an image file in the application bundle (it may include the
     * extension or omit it) to display. If this property is not specified, the system either
     * uses the previous snapshot, uses the image identified by the UILaunchImageFile key in
     * the application’s Info.plist file, or falls back to {@code Default.png}.
     * @param imageFile The image file name
     */
    public void setLaunchImage(String imageFile) {
        body.getAlert().setLaunchImage(imageFile);
    }
}
