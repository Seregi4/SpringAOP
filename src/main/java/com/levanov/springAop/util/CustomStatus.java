package com.levanov.springAop.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum CustomStatus {

    SUCCESS(0, "success"),
    NOT_FOUND(1, "not found"),
    EXCEPTION(2, "Exception");

    private int code;
    private String message;



    CustomStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
