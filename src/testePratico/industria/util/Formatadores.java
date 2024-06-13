package testePratico.industria.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formatadores {
    public static final DateTimeFormatter FORMATTER_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DecimalFormat DECIMAL_FORMAT_SALARIO = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
}
