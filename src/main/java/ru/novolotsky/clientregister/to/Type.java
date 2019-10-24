package ru.novolotsky.clientregister.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Type {
    @JsonProperty("create")
    CREATE,
    @JsonProperty("get-balance")
    GET_BALANCE;
}
