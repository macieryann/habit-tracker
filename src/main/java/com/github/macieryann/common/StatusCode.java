package com.github.macieryann.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum StatusCode {
    SUCCESS("SUCCESS"),
    DATABASE_ERROR("DATABASE_ERROR"),
    INSERT_ERROR("INSERT_ERROR"),
    DELETE_ERROR("DELETE ERROR");

    private final String code;

    StatusCode(String code) {
        this.code = code;
    }
}
