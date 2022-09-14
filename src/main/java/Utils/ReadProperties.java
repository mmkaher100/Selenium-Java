package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static Utils.DriverUtils.prop;

public class ReadProperties {

    public static Properties getPropertyObject() throws IOException {

        FileInputStream fis = new FileInputStream("C://Users//Kaher Ahmed//IdeaProjects//DemoQA//demoqa.properties");

        Properties prop = new Properties();

        prop.load(fis);

        return prop;

    }
    public static String getUrl() throws IOException {
        return getPropertyObject().getProperty("LogInURL");

    }

    public static String getUsername() throws IOException {
        return getPropertyObject().getProperty("UserName");

    }

    public static String getPassword() throws IOException {
        return getPropertyObject().getProperty("Password");

    }
}
