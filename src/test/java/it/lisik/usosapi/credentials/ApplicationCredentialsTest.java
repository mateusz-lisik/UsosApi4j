package it.lisik.usosapi.credentials;

import junit.framework.TestCase;

public class ApplicationCredentialsTest extends TestCase {

    public void testGetApplicationUrl() throws Exception {
        ApplicationCredentials credentials = new ApplicationCredentials("http://url.without.tailing.slash", null, null);
        assertEquals(
                "Checking if tailing slash will be automatically added",
                "http://url.without.tailing.slash/",
                credentials.getApplicationUrl()
        );
    }
}