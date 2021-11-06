package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JavaHelpers {

    /**
     * Get Property value
     * @param String propertyfile property file name
     * @param String propertyname property name
     * @return String property value
     */
    public static String getPropertyValue(String propertyfile, String propertyname)
    {
        Properties prop = accessPropertiesFile(propertyfile);
        return prop.getProperty(propertyname);
    }

    /**
     * Access property file
     * @param String propertyfile property file name
     * @return Properties object
     */
    public static Properties accessPropertiesFile(String propertyfile)
    {
        Properties prop = new Properties();
        // try retrieve data from file
        try
        {
            prop.load(new FileInputStream(propertyfile));
        }
        // catch exception in case properties file does not exist
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return prop;
    }

}
