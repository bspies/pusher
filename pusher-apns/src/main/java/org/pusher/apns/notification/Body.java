package org.pusher.apns.notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * The main body of the notification.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class Body {
    @JsonProperty
    private Alert alert;
    @JsonProperty
    private String sound;
    @JsonProperty
    private Integer badge;

    Body(String body) {
        alert = new Alert(body);
    }

    Body(String key, Collection<String> arguments) {
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
