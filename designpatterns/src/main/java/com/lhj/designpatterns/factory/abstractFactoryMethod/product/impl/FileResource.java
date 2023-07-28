package com.lhj.designpatterns.factory.abstractFactoryMethod.product.impl;

import com.lhj.designpatterns.factory.abstractFactoryMethod.product.AbstractResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author banyanmei
 */
@Slf4j
@Component
public class FileResource extends AbstractResource {
    public FileResource() {
    }

    public FileResource(String url) {
        super(url);
    }

    @Override
    public void load() {
        log.info("FileResource load");
    }
}
