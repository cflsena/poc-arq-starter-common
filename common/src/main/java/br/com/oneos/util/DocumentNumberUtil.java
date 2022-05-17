package br.com.oneos.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.Objects;

@Slf4j
@UtilityClass
public class DocumentNumberUtil {

    private static final String CNPJ_FORMAT = "##.###.###/####-##";
    private static final String CPF_FORMAT = "###.###.###-##";
    private static final int CPF_LENGTH = 11;
    private static final int CNPJ_LENGTH = 14;

    public static String format(final String documentNumber) {
        if (documentNumber.length() == CNPJ_LENGTH) return formatCNPJ(documentNumber);
        if (documentNumber.length() == CPF_LENGTH) return formatCPF(documentNumber);
        log.warn("Invalid document number {}. It will be sent as is", documentNumber);
        return documentNumber;
    }

    public static String removeChars(final String documentNumber) {
        return cleanDocumentNumber(documentNumber);
    }

    private static String formatCPF(final String documentNumber) {
        try {
            return FormatterUtil.formatField(documentNumber, CPF_FORMAT);
        } catch (ParseException e) {
            log.warn("Error to format CPF with value {}. It will be sent without formatting. Details: ", documentNumber, e);
        }
        return documentNumber;
    }

    private static String formatCNPJ(final String documentNumber) {
        try {
            return FormatterUtil.formatField(documentNumber, CNPJ_FORMAT);
        } catch (ParseException e) {
            log.warn("Failed to format CNPJ with value {}. It will be sent without formatting. Details: ", documentNumber, e);
        }
        return documentNumber;
    }

    private static String cleanDocumentNumber(final String documentNumber) {
        if (Objects.nonNull(documentNumber)) {
            return documentNumber.replaceAll("[^\\w\\s]", "");
        }
        log.warn("Failed to remove punctuations from document number with value. It will be sent as is");
        return null;
    }

}
