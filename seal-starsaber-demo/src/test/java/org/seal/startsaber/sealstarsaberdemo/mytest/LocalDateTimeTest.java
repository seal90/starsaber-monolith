package org.seal.startsaber.sealstarsaberdemo.mytest;

import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.format.datetime.standard.DateTimeContextHolder;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class LocalDateTimeTest {

    public static void main(String[] args) {
//        DateTimeFormatter df = getFormatter(DateTimeFormatterRegistrar.Type.DATE);
        ;
//        DateTimeFormatter df  = new DateTimeFormatter(TextStyle.SHORT);
//        DateTimeFormatter formatterToUse = DateTimeContextHolder.getFormatter(df, Locale.getDefault());
//        LocalDateTime parse = LocalDateTime.parse("2018-12-12 12:12:12", formatterToUse);
//        System.out.println(parse);
        DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        df.withLocale(Locale.getDefault());
        System.out.println(df.format(LocalDateTime.now()));
        LocalDateTime parse = LocalDateTime.parse("18-9-11 上午10:03", df);
        System.out.println(parse);

        System.out.println(LocalDateTime.parse("2007-12-03T10:15:30"));

    }

}
