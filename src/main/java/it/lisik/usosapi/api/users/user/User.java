package it.lisik.usosapi.api.users.user;

import com.google.api.client.util.Key;

public class User {
    @Key
    private String id;
    @Key("first_name")
    private String firstName;
    @Key("last_name")
    private String lastName;
    @Key("middle_names")
    private String middleNames;
    @Key("sex")
    private Gender gender;

    public User() {

    }

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns Middle Names separated by space or null if user doesn't have second name
     * @return Middle Names
     */
    public String getMiddleNames() {
        return middleNames;
    }

    public Gender getGender() {
        return gender;
    }

    public String getLastName() {

        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }
}
