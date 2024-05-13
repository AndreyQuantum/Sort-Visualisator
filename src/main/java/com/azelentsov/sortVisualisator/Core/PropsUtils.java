package com.azelentsov.sortVisualisator.Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropsUtils {
    public Map<String, String> readProperties(String name) {
        String pathToFile = getPathToProperties(name);
        Properties props = readPropsFile(pathToFile, name);
        return propertiesToMap(props);
    }

    private static String getPathToProperties(String name) {
        var path = Paths.get(System.getProperty("user.dir"),  "src", "main", "java", "com", "azelentsov",
                "sortVisualisator","Core","properties", name + ".properties");
        return path.toString();
    }

    private Map<String, String> propertiesToMap(Properties props) {
        Map<String, String> propertiesMap =  new HashMap<>();
        props.forEach((key, value) -> propertiesMap.put((String) key, (String) value));
        return propertiesMap;
    }

    private Properties readPropsFile(String filePath, String name){
        var res = new Properties();
        res.setProperty("name", name);
        try (FileInputStream in = new FileInputStream(filePath)) {
            res.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
