package com.enterprise.config;

import java.util.Properties;

public final class EnvironmentManger {
	

    private EnvironmentManger() {
    }
    public static String getEnvironment(Properties frameworkProperties) {

        String environment = System.getProperty("environment");

        if (environment != null && !environment.isBlank()) {
            return environment;
        }

        return frameworkProperties.getProperty("environment","qa");

    }
}
