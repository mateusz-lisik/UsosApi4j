package it.lisik.usosapi.errorhandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import it.lisik.usosapi.errorhandler.exceptions.OAuthUnauthorizedException;

import java.io.IOException;

public class ApiResponseErrorHandler implements HttpUnsuccessfulResponseHandler {
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry) throws IOException {
        switch (response.getStatusCode()) {
            case HttpStatusCodes.STATUS_CODE_UNAUTHORIZED:
                final JsonNode jsonNode = mapper.readTree(response.getContent());
                final String errorMessage = jsonNode.get("message").asText(jsonNode.toString());
                if (errorMessage.equals("Invalid signature.")) {
                    throw new OAuthUnauthorizedException(
                            errorMessage + " This error may occur when access token + secret" +
                                    " and consumer key + secret pair are not valid."
                    );
                }
                throw new OAuthUnauthorizedException(errorMessage);
        }

        return false;
    }
}
