package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class DateFormater {
    private static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HH:mm");

    public static LocalDate formatDate(String value) {
        LocalDate result = null;
            result = LocalDate.parse(value, FORMATTER_DATE);
        return result;
    }

    public static LocalTime formatTime(String value) {
        LocalTime result = null;
        result = LocalTime.parse(value, FORMATTER_TIME);
        return result;
    }

}
