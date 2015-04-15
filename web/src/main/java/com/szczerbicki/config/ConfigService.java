package com.szczerbicki.config;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static java.lang.System.getenv;

/**
 * Created by Pawel on 2014-07-23.
 */
@Service
public class ConfigService {

    @Resource(name = "appProperties")
    private Properties appProperties;

    public String property(String key) {
        return getenv(key) == null ? appProperties.getProperty(key) : getenv(key);
    }

    public boolean propertyAsBoolean(String key) {
        return parseBoolean(property(key));
    }
}
