package com.bobby.peng.learning.proxy.anntoation;

import com.bobby.peng.learning.proxy.api.Proxy;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
@ProxyPackage(path = "com.bobby.peng.pepare.proxy.*")
@Component
public class LogProxy implements Proxy{

    @Override
    public void preHandle() {
        System.out.println("do pre handle");
    }
}
