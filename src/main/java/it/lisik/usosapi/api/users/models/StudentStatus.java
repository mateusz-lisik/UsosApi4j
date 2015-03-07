package it.lisik.usosapi.api.users.models;

import com.google.api.client.util.NullValue;
import com.google.api.client.util.Value;

public enum StudentStatus {
    @NullValue
    UNKNOWN,
    @Value("0")
    NOT_A_STUDENT,
    @Value("1")
    INACTIVE_STUDENT,
    @Value("2")
    ACTIVE_STUDENT
}
