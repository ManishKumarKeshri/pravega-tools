package io.pravega.tools.pravegacli.commands;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    public static void loadProperties(AdminCommandState state) {
        Properties pravegaProperties = new Properties();
        // First, load the properties from file, if any.
        try (InputStream input = new FileInputStream(System.getProperty("pravega.configurationFile"))) {
            pravegaProperties.load(input);
        } catch (Exception e) {
            System.err.println("Exception reading input properties file: " + e.getMessage());
            pravegaProperties.clear();
        }

        // Second, load properties from command line if any.
        for (String propertyName: System.getProperties().stringPropertyNames()) {
            if (propertyName.startsWith("pravegaservice") || propertyName.startsWith("cli") || propertyName.startsWith("bookkeeper")) {
                pravegaProperties.setProperty(propertyName, System.getProperties().getProperty(propertyName));
            }
        }
        state.getConfigBuilder().include(pravegaProperties);
    }
}
