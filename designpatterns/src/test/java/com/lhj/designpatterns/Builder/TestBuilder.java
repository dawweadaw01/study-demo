package com.lhj.designpatterns.Builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestBuilder {
    @Test
    public void test() {
        HtmlDocument htmlDocument = new HtmlDocument.Builder()
                .addHeader("header")
                .addBody("body")
                .addFooter("footer")
                .build();
        log.info(htmlDocument.toString());
    }

    @Test
    void testBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("header").append("body").append("footer");
        log.info(stringBuilder.toString());
    }
}
