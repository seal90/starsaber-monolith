package org.seal.starsaber.arch.conf.date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Configuration
public class DateFormatterConfig {

    /**
     * 2011-12-03
     * @return
     */
    @Bean
    public Formatter<LocalDate> localDateFormatter(){
        return new Formatter<LocalDate>() {
            @Override
            public LocalDate parse(String text, Locale locale) throws ParseException {
                return LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE);
            }

            @Override
            public String print(LocalDate object, Locale locale) {
                return DateTimeFormatter.ISO_LOCAL_DATE.format(object);
            }
        };
    }

    /**
     * '10:15' or '10:15:30'.
     * @return
     */
    @Bean
    public Formatter<LocalTime> localTimeFormatter(){
        return new Formatter<LocalTime>() {
            @Override
            public LocalTime parse(String text, Locale locale) throws ParseException {
                return LocalTime.parse(text, DateTimeFormatter.ISO_LOCAL_TIME);
            }

            @Override
            public String print(LocalTime object, Locale locale) {
                return DateTimeFormatter.ISO_LOCAL_TIME.format(object);
            }
        };
    }


    /**
     * 2011-12-03T10:15:30
     * @return
     */
    @Bean
    public Formatter<LocalDateTime> localDateTimeFormatter() {
        return new Formatter<LocalDateTime>() {

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(object);
            }

            @Override
            public LocalDateTime parse(String text, Locale locale) throws ParseException {
                return LocalDateTime.parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            }
        };
    }
}
