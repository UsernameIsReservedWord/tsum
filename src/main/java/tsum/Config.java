package tsum;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String PROP_FILE = "/config.properties";

    public static String get(String name) {
        Properties props = new Properties();
        try {
            props.load(Config.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}
