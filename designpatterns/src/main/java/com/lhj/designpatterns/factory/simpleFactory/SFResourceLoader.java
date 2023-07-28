package com.lhj.designpatterns.factory.simpleFactory;

import com.lhj.designpatterns.entity.Resource;
import com.lhj.designpatterns.exception.ResourceLoadException;
import org.springframework.stereotype.Component;

/**
 * @author banyanmei
 */

@Component
public class SFResourceLoader {
    public Resource load(String url) {
        String prefix = getPrefix(url);
        return ResourceFactory.create(prefix, url);
    }

    public String getPrefix(String url) {
        if (url == null || !url.contains(":")) {
            throw new ResourceLoadException("url不能为空");
        }
        return url.substring(0, url.indexOf(":"));
    }
}
