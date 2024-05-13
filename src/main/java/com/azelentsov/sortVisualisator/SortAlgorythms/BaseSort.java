package com.azelentsov.sortVisualisator.SortAlgorythms;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public abstract class BaseSort{

    protected List<ArrayElement> arrayToSort;

    private List<ArrayElement> arrayBefore = new LinkedList<>();


    private List<IterationResult> results = new LinkedList<>();

    private Map<String, String> properties;

    protected abstract void run();

    public BaseSort(int lengthOfArray, int maxNumber) {
        populateArray(lengthOfArray, maxNumber);
        readProperties();
    }

    public BaseSort(int lengthOfArray) {
        populateArray(lengthOfArray);
        readProperties();
    }
    protected void populateArray(int length){
        arrayToSort = new ArrayList<>();
        Random random = new Random(12345);
        for (int i = 0; i<= length-1; i++){
            arrayToSort.add(new ArrayElement(i, random.nextInt()));
        }
    }

    protected void populateArray(int length, int maxNumber){
        arrayToSort = new ArrayList<>();
        Random random = new Random(12345);
        for (int i = 0; i<= length-1; i++){
            arrayToSort.add(new ArrayElement(i, random.nextInt(0,maxNumber)));
        }
    }

    private void readProperties() {
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

    protected void saveArrayBeforeIteration(){
        Collections.copy(arrayBefore, arrayToSort);
    }
    protected void saveArrayAfterIteration(int[] indexesToFocusOn){
        List<ArrayElement> arrayAfter = new LinkedList<>();
        Collections.copy(arrayAfter, arrayToSort);
        results.add(new IterationResult(indexesToFocusOn, arrayBefore, arrayAfter));
    }

    protected Map<String,String> getProperties(){
        return properties;
    }

    public SortingResult getResult() {
        long start = System.currentTimeMillis();
        run();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        properties.put("elapsed time", String.valueOf(elapsed));
        return new SortingResult(results, properties.get("elapsed time"));
    }

    protected String getName(){
        return properties.get("name");
    }


    protected void swap(int indexA, int indexB){
        Collections.swap(arrayToSort, indexA, indexB);
    }
}
