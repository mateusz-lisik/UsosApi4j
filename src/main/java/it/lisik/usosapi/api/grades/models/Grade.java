package it.lisik.usosapi.api.grades.models;

import com.google.api.client.util.Key;
import it.lisik.usosapi.api.commons.TranslatedValue;

public class Grade {
    @Key("value_symbol")
    private String valueSymbol;

    @Key("exam_session_number")
    private Integer examSessionNumber;

    @Key("exam_id")
    private Integer examId;

    @Key("value_description")
    private TranslatedValue valueDescription;
}
