package org.pusher.apns.notification;

/**
 * Builder for {@link PushNotification} objects.
 *
 * @author Brennan Spies
 */
public class NotificationBuilder {

    PushNotification pushNotification;

    private NotificationBuilder(String body) {
        pushNotification = new PushNotification(body);
    }

    public static NotificationBuilder forMessage(String message) {
        return new NotificationBuilder(message);
    }

    public NotificationBuilder withBadge(int badge) {
        pushNotification.setBadge(badge);
        return this;
    }

    public NotificationBuilder withSound(String sound) {
        pushNotification.setSound(sound);
        return this;
    }

    public NotificationBuilder withLaunchImage(String image) {
        pushNotification.setLaunchImage(image);
        return this;
    }

    /**
     * Returns the final push notification.
     * @return The push notification
     */
    public PushNotification build() {
        return pushNotification;
    }
}
