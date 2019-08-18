package com.soham.domain.chronology.DateHandler;

import com.soham.domain.utils.DataUtility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {


    public static void main(String[] args) {

        /*LocalDate todaysDate= LocalDate.now();
        String newDate = DateFormatter.changeFormat(todaysDate, "yyyy-MM-dd");

        ZonedDateTime apollo11launch  = ZonedDateTime.of(1969, 7, 16, 22, 32, 0, 0,
                ZoneId.of("America/New_York"));

        LocalDate date = DateFormatter.getLocalDateFromString("1969, 07 - 22","yyyy, MM - dd");
        System.out.println(DateFormatter.changeFormat(date, "yyyy, MM - dd"));
       // System.out.println(apollo11launch.toInstant().atZone(ZoneId.of("America/New_York")));*/
        // System.out.println(DateFormatter.getLocalDateWithoutTime(LocalDateTime.now()));

        /*System.out.println(LegacyConverter.toLocalDate(new Date()));
        System.out.println(LegacyConverter.toInstant(new Date()));
        //System.out.println(ZoneId.getAvailableZoneIds());

        System.out.println(LegacyConverter.asZonedDateTime(new Date(),ZoneId.of("Asia/Calcutta")));
        System.out.println(new Date());
        System.out.println(LocalDate.now().getEra());
        System.out.println(LegacyConverter.asZonedDateTime(null,ZoneId.of("Asia/Calcutta")));
*/

        DataUtility.requireNonNulls(new Date(),new Date(), null);


    }


}
