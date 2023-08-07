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
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable, Cloneable {
    private String name;
    private double price;
    private int stock;

    /**
     *
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            log.error("Product clone error", e);
            return null;
        }
    }
}
