package com.azelentsov.sortVisualisator.SortAlgorythms;

import com.azelentsov.sortVisualisator.SortAlgorythms.properties.PropsUtils;

import java.util.*;

public abstract class BaseSort{

    private final String name = this.getClass().getSimpleName();

    private List<ArrayElement> arrayBefore = new LinkedList<>();

    private List<IterationResult> results = new LinkedList<>();

    protected List<ArrayElement> arrayToSort;

    private PropsUtils propsUtils = new PropsUtils();
    private Map<String, String> properties;

    protected abstract void run();

    public BaseSort(int lengthOfArray, int maxNumber) {
        populateArray(lengthOfArray, maxNumber);
        properties = propsUtils.readProperties(name);
    }

    public BaseSort(int lengthOfArray) {
        populateArray(lengthOfArray);
        properties = propsUtils.readProperties(name);
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

    protected void saveArrayBeforeIteration(){
        Collections.copy(arrayBefore, arrayToSort);
    }
    protected void saveArrayAfterIteration(int[] indexesToFocusOn){
        List<ArrayElement> arrayAfter = new LinkedList<>();
        Collections.copy(arrayAfter, arrayToSort);
        results.add(new IterationResult(indexesToFocusOn, arrayBefore, arrayAfter));
    }

    protected void swap(int indexA, int indexB){
        Collections.swap(arrayToSort, indexA, indexB);
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

}
