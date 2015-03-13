package it.lisik.usosapi.api.commons;

import com.google.api.client.util.Key;

/**
 * Stores values for multi-language values such as course names
 * Note: There is possibility that one of translation (in most cases english one) will not be available
 * You should be prepared for that.
 */
public class TranslatedValue {
    @Key("en")
    private String english;
    @Key("pl")
    private String polish;

    public String getEnglishVariant() {
        return english;
    }

    public String getPolishVariant() {
        return polish;
    }
}
