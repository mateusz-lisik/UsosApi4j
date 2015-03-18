package it.lisik.usosapi.api.users.models;

public enum PhotoSize {
    THUMBNAIL("50x50"),
    SMALL_SQUARE("100x100"),
    SMALL("100x125"),
    MEDIUM_SQUARE("200x200"),
    MEDIUM("200x250"),
    ORIGINAL("original");

    private final String dimensions;

    PhotoSize(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getDimensions() {
        return dimensions;
    }
}
