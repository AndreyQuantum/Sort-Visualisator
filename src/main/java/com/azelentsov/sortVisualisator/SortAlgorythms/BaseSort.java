package com.azelentsov.sortVisualisator.SortAlgorythms;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public abstract class BaseSort{

    protected int[] arrayToSort;


    private Map<String, String> properties;

    protected abstract void doOneIteration();

    public BaseSort(int lengthOfArray) {
        populateArray(lengthOfArray);
        String name = this.getClass().getSimpleName();
        String pathToFile = getPathToProperties(name);
        Properties props = readPropsFile(pathToFile, name);
        properties = propertiesToMap(props);
    }

    private static String getPathToProperties(String name) {
        var path = Paths.get(System.getProperty("user.dir"),  "src", "main", "java", "com", "azelentsov",
                "sortVisualisator", "SortAlgorythms","properties", name + ".properties");
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

    protected Map<String,String> getProperties(){
        return properties;
    }

    protected String getName(){
        return properties.get("name");
    }

    protected void populateArray(int length){
        arrayToSort = new int[length];
        Random random = new Random(12345);
        for (int i = 0; i<= length-1; i++){
            arrayToSort[i] = random.nextInt(0,100);
        }
    }
    protected void populateArray(int length, int maxNumber){
        arrayToSort = new int[length];
        Random random = new Random(12345);
        for (int i = 0; i<= length-1; i++){
            arrayToSort[i] = random.nextInt(0,maxNumber);
        }
    }

    protected void swap(int indexA, int indexB){
        int temp = arrayToSort[indexA];
        arrayToSort[indexA] = arrayToSort[indexB];
        arrayToSort[indexB] = temp;
    }
}
