package com.qa.automation.helpers;

import javax.validation.constraints.Null;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader(String configFilePath){
        System.out.println("PropertyReader file");
        properties= new Properties();
        try {
            InputStream inputStream= new FileInputStream(configFilePath);
            if(inputStream == null){
                System.out.println("Unable to find the properties file");
                return;
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getProp(String key){
        if((key == null) || key.isEmpty()){
            return "";
        }
        else
            return properties.getProperty(key);
    }
}
