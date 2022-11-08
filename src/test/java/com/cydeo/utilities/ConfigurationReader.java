package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1. Create object of properties
    private static Properties properties = new Properties();

    static{

        try {
            //2. we need to open the file in java memort; FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");



            properties.load(file);
        }catch (IOException e){

            System.out.println("File not found configurationReader class.");
            e.printStackTrace();



        }


    }

    public static String getProperties(String keyword){
        return properties.getProperty(keyword);

    }
}
