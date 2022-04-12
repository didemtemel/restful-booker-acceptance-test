package restful.booker.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Config {
    public static final String BOOKING_SERVICE_URL;


    private static final Properties properties;

    static {
        System.getProperties().setProperty("env", "pipeline");
        System.getProperties().setProperty("log4j.configurationFile", "/src/test/resources/log4j2.xml");

        properties = loadProperties();
        BOOKING_SERVICE_URL = readPropertyFromSystemWithPropertiesFallback("booking.service.url");

    }

    private Config() { // default implementation ignored
    }

    private static String readPropertyFromSystemWithPropertiesFallback(String key) {
        return Optional.ofNullable(System.getProperty(key))
                .orElseGet(() -> properties.getProperty(key));
    }

    private static Properties loadProperties() {
        String configFileName = "config.properties";
        InputStream in = ClassLoader.getSystemResourceAsStream(configFileName);
        Properties properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException ioe) {
            throw new IllegalStateException("Exception on loading {" + configFileName + "} conf file from classpath", ioe);
        }
        return properties;
    }
}
