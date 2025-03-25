package com.studantapp.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum StudentStatus {
    @JsonProperty("Active")
    ACTIVE,
    @JsonProperty("Graduated")
    GRADUATED,
    @JsonProperty("Inactive")
    INACTIVE,
    @JsonProperty("On Leave")
    ON_LEAVE
}
