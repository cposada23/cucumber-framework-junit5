package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private  Properties properties;

    public  Properties init(String source) throws IOException {
        try (
                InputStream input = new FileInputStream(source)
        ) {
            properties = new Properties();
            properties.load(input);
            return properties;
        }
    }
}
