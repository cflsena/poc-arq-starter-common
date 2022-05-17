package br.com.oneos.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Slf4j
@UtilityClass
public class MoneyUtil {

    public static String formatMoneyInReal(final BigDecimal money) {
        final Locale ptBr = new Locale("pt", "BR");
        try {
            return NumberFormat.getCurrencyInstance(ptBr).format(money);
        } catch (Exception e) {
            log.warn("Error formatting money with value {}. The money will be unformatted. Details: ", money, e);
        }
        return money.toString();
    }

}
