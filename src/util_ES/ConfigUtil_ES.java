package util_ES;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil_ES {

    private static final String FILE_NAME = "config.txt";
    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            props.load(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println("Config file not found, using defaults.");
        }
    }

    public static String getOrDefault(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }
}
