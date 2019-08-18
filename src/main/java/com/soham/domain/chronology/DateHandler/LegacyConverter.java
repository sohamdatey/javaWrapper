package com.soham.domain.chronology.DateHandler;

import com.soham.domain.utils.DataUtility;
import java.time.*;
import java.util.Date;

public class LegacyConverter {
    /**
     * java.util.Date to Instant
     * @param date
     * @return Instant
     */
    public static Instant toInstant(Date date) {
        DataUtility.requireNonNulls(date);
        return date.toInstant();
    }

    /**
     * java.util.Date to java.time.LocalDate
     * @param date
     * @return LocalDate
     */
    public static LocalDate toLocalDate(Date date) {
        DataUtility.requireNonNulls(date);
        return asLocalDate(date, ZoneId.systemDefault());
    }

    private static LocalDate asLocalDate(Date date, ZoneId zone) {
        return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDate();
    }

    /**
     * java.util.Date to java.time.LocalDateTime
     * @param date
     * @return LocalDate
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        DataUtility.requireNonNulls(date);
        return asLocalDateTime(date, ZoneId.systemDefault());
    }

    private static LocalDateTime asLocalDateTime(Date date, ZoneId zone) {
        return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDateTime();
    }

    /**
     * java.util.Date to system Default ZonedDateTime
     * @param date
     * @return
     */
    public static ZonedDateTime asDefaultZonedDateTime(Date date) {
        DataUtility.requireNonNulls(date);
        return asZonedDateTime(date, ZoneId.systemDefault());
    }

    /**
     * java.util.Date to given ZonedDateTime
     * @param date
     * @return
     */
    public static ZonedDateTime asZonedDateTime(Date date, ZoneId zone) {
        DataUtility.requireNonNulls(date, zone);
        return toInstant(date).atZone(zone);
    }


}
