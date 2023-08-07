package com.lhj.designpatterns.prototype.shallowcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author banyanmei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class PromotionRule implements Serializable, Cloneable {
    private String type;
    private double discount;
    private Product product;

    public PromotionRule(String type, Product product) {
        this.type = type;
        this.product = product;
    }

    @Override
    public PromotionRule clone() {
        try {
            PromotionRule promotionRule = (PromotionRule) super.clone();
            Product product = (Product) this.product.clone();
            promotionRule.setProduct(product);
            return promotionRule;
        } catch (CloneNotSupportedException e) {
            log.error("PromotionRule clone error", e);
            return null;
        }
    }
}
