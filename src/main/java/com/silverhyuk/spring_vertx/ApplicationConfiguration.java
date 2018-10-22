package com.silverhyuk.spring_vertx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ApplicationConfiguration {
    @Autowired
    Environment environment;

    public int httpPort() {
        return environment.getProperty("http.port", Integer.class, 8080);
    }
}
