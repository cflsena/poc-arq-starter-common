package br.com.oneos.error;

import lombok.Getter;

@Getter
public class ErrorMessageDetail {

    private final String code;
    private final String message;

    public ErrorMessageDetail(final String code, final String message) {
        this.message = message;
        this.code = code;
    }

}
