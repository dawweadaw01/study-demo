package com.lhj.designpatterns.prototype;

import com.lhj.designpatterns.prototype.shallowcopy.Product;
import com.lhj.designpatterns.prototype.shallowcopy.PromotionEvent;
import com.lhj.designpatterns.prototype.shallowcopy.PromotionRule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
public class TwoPrototype {
    @Test
    void testPrototype() {
        // 创建原始促销活动
        PromotionEvent originalEvent = createSamplePromotionEvent();
        log.info("originalEvent:{}", originalEvent);
        // 创建新的促销活动
        PromotionEvent newEvent = originalEvent.clone();
        newEvent.setName("新的促销活动");
        // 现在newEvent是originalEvent的一个深拷贝副本，我们可以对它进行修改而不会影响originalEvent
        // 修改新促销活动的日期
        newEvent.setStartDate(addDays(newEvent.getStartDate(), 7));
        newEvent.setEndDate(addDays(newEvent.getEndDate(), 7));
        newEvent.getRules().get(0).getProduct().setPrice(200.0);

        // 修改新促销活动的部分规则
        List<PromotionRule> newRules = newEvent.getRules();
        newRules.get(0).setDiscount(newRules.get(0).getDiscount() * 1.1);

        // 现在，我们已经成功地复制了一个与原始活动相似但具有不同日期和部分规则的新促销活动。
        // 可以将新活动应用于其他商品，而原始活动保持不变。
        log.info("newEvent:{}", newEvent);
        log.info("originalEvent:{}", originalEvent);
    }

    private static PromotionEvent createSamplePromotionEvent() {
        // 创建示例促销活动
        List<PromotionRule> rules = Arrays.asList(
                new PromotionRule("折扣", new Product("A", 100.0, 1)),
                new PromotionRule("满减", new Product("B", 100.0, 2))
        );

        PromotionEvent event = new PromotionEvent(
                "原始促销活动",
                new Date(),
                addDays(new Date(), 7),
                rules
        );

        return event;
    }

    private static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
