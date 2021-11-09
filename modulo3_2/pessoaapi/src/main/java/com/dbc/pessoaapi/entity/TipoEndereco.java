package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoEndereco {
    RESIDENCIAL,
    COMERCIAL;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
