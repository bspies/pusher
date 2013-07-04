package org.pusher.apns.notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * The notification alert.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class Alert {

    @JsonProperty
    private String body;
    @JsonProperty("action-loc-key")
    private String actionKey;
    @JsonProperty("loc-key")
    private String localizedKey;
    @JsonProperty("loc-args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<String> localizedArguments
            = Lists.newArrayList();
    @JsonProperty("launch-image")
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
