package it.lisik.usosapi.api.apiserver.models;

import com.google.api.client.util.Key;
import it.lisik.usosapi.api.commons.TranslatedValue;

import java.util.List;

public class InstallationInformation {

    @Key("base_url")
    private String baseUrl;

    @Key
    private String version;

    @Key("usos_schema_version")
    private String usosSchemaVersion;

    @Key("institution_name")
    private TranslatedValue institutionName;
    @Key("contact_emails")
    private List<String> contactEmails;

    public InstallationInformation() {

    }

    public InstallationInformation(String baseUrl, String version, String usosSchemaVersion, TranslatedValue institutionName, List<String> contactEmails) {
        this.baseUrl = baseUrl;
        this.version = version;
        this.usosSchemaVersion = usosSchemaVersion;
        this.institutionName = institutionName;
        this.contactEmails = contactEmails;
    }

    public List<String> getContactEmails() {

        return contactEmails;
    }

    public TranslatedValue getInstitutionName() {
        return institutionName;
    }

    public String getUsosSchemaVersion() {
        return usosSchemaVersion;
    }

    public String getVersion() {
        return version;
    }

    public String getBaseUrl() {
        return baseUrl.replace("http", "https");
    }
}
