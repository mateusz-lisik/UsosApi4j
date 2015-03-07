package it.lisik.usosapi.errorhandler.exceptions;

import java.io.IOException;

public abstract class AbstractApiException extends IOException {
    public AbstractApiException(String message) {
        super(message);
    }
}
