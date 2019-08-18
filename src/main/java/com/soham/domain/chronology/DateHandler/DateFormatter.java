package com.soham.domain.chronology.DateHandler;

import com.soham.domain.utils.DataUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateFormatter {

    /**
     * This method will accept a date and the format to which your date is supposed to be returned.
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(LocalDate date, String format) {
        DataUtility.requireNonNulls(date,format);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static LocalDate getLocalDateFromStringOfFormat(String date, String format) {
        DataUtility.requireNonNulls(date,format);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, formatter);
    }

    public static LocalDate getLocalDateWithoutTime(LocalDateTime dateTime) {
        DataUtility.requireNonNulls(dateTime);
        return LocalDate.from(dateTime);
    }



}
