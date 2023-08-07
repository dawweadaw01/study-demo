package com.lhj.designpatterns.factory;

import com.lhj.designpatterns.factory.abstractFactoryMethod.AbstractFResourceLoader;
import com.lhj.designpatterns.factory.abstractFactoryMethod.product.AbstractResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


@SpringBootTest
@Slf4j
public class TestAbstractFactory {

    @Autowired
    private AbstractFResourceLoader abstractFResourceLoader;
    @Test
    void testAbstractFactory() {
        String url = "file://www.baidu.com";
        AbstractResource load = abstractFResourceLoader.load(url);
        log.info(load.toString());
        load.load();
    }

    @Test
    void testTime() {
        String string = "Fri Jul 28 18:46:47 CST 2023";
        String string1 = new Date().getTime()+"";
        Date date = new Date(string);

        Instant now = Instant.ofEpochMilli(Long.parseLong(string1));
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(now, ZoneId.of("America/New_York"));
        ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(now, ZoneId.systemDefault());
        //转换格式
        System.out.println(zonedDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssW")));
        System.out.println(zonedDateTime2.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ssE")));
        System.out.println(offsetDateTime);
        System.out.println(zonedDateTime1+" "+ zonedDateTime2);
        //Instant转Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now.toEpochMilli());
        Duration duration = Duration.between(now,now);
        System.out.println(duration.toDays());
        calendar.add(Calendar.DAY_OF_MONTH,1);
        now = Instant.ofEpochMilli(calendar.getTimeInMillis());
        //格式化为yyyy-MM-dd HH:mm:ss
        System.out.println(OffsetDateTime.ofInstant(now, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        LocalDateTime localDateTime = now.atZone(ZoneId.systemDefault()).toLocalDateTime().plusDays(1);
        System.out.println(localDateTime.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    void testLists() {

    }
}
