package it.lisik.usosapi.errorhandler.exceptions;

/**
 * Exception that is thrown when API Call is made with invalid token/secret or Consumer Key/Consumer secret
 * was used. See the error message to debug this situation.
 */
public class OAuthUnauthorizedException extends AbstractApiException {
    public OAuthUnauthorizedException(String message) {
        super(message);
    }
}
