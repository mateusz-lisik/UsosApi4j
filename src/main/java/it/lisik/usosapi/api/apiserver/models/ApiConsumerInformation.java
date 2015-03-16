package it.lisik.usosapi.api.apiserver.models;

import com.google.api.client.util.Key;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class ApiConsumerInformation {
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss");

    @Key
    private String name;
    @Key
    private String url;
    @Key
    private String email;
    @Key("date_registered")
    private String dateRegistered;
    @Key("administrative_methods")
    private List<String> administrativeMethods;
    @Key("token_scopes")
    private List<String> tokenScopes;

    public ApiConsumerInformation() {

    }

    public ApiConsumerInformation(List<String> tokenScopes, List<String> administrativeMethods, String dateRegistered, String email, String url, String name) {
        this.tokenScopes = tokenScopes;
        this.administrativeMethods = administrativeMethods;
        this.dateRegistered = dateRegistered;
        this.email = email;
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public DateTime getDateRegistered() {
        return DateTime.parse(dateRegistered, DATE_TIME_FORMATTER);
    }

    public List<String> getAdministrativeMethods() {
        return administrativeMethods;
    }

    public List<String> getTokenScopes() {
        return tokenScopes;
    }
}
