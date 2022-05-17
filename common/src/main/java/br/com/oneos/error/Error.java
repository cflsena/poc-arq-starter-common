package br.com.oneos.error;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Error {

    private static final int FIRST_ELEMENT_INDEX = 0;

    private final List<ErrorMessageDetail> errors = new ArrayList<>();

    public void add(final String code, final String message) {
        final var errorMessageDetail = new ErrorMessageDetail(code, message);
        this.errors.add(errorMessageDetail);
    }

    public List<ErrorMessageDetail> getErrors() {
        return Collections.unmodifiableList(this.errors);
    }

    public void add(final ErrorMessageDetail errorMessageDetail) {
        this.errors.add(errorMessageDetail);
    }

    public ErrorMessageDetail first() {
        return this.errors.get(FIRST_ELEMENT_INDEX);
    }

    public String allMessagesConcatenated() {
        return this.errors.stream().map(ErrorMessageDetail::getMessage).collect(Collectors.joining());
    }

}
