package com.awbeci.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class MyProperties {
    Logger log = LoggerFactory.getLogger(MyProperties.class);

    /**
     * @param name
     * @return
     */
    public Properties getPropertiesByName(String name) {
        try {
            Properties prop = new Properties();
            prop.load(MyProperties.class.getClassLoader().getResourceAsStream(name));
            return prop;
        } catch (Exception e) {
            log.error("出错:" + e.getMessage());
            return null;
        }
    }
}
