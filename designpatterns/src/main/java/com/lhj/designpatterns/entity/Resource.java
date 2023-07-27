package com.lhj.designpatterns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author banyanmei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
    private String url;

    @Override
    public String toString() {
        return "Resource{" +
                "url='" + url + '\'' +
                '}';
    }
}

