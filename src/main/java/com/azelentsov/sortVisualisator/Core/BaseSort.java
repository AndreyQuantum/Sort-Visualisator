package com.azelentsov.sortVisualisator.Core;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import com.azelentsov.sortVisualisator.Core.records.IterationResult;
import com.azelentsov.sortVisualisator.Core.records.SortingResult;
import org.springframework.stereotype.Component;

import java.util.*;

public abstract class BaseSort{

    private final String name = this.getClass().getSimpleName();

    private List<ArrayElement> arrayBefore = new LinkedList<>();

    private List<IterationResult> results = new LinkedList<>();

    protected List<ArrayElement> arrayToSort;

    private PropsUtils propsUtils = new PropsUtils();
    private Map<String, String> props;

    protected abstract void run();

    public BaseSort(List<ArrayElement> arrayToSort) {
        this.arrayToSort = arrayToSort;
        props = propsUtils.readProperties(name);
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

    public Map<String,String> getProps(){
        return props;
    }

    public SortingResult getResult() {
        long start = System.currentTimeMillis();
        run();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        props.put("elapsed time", String.valueOf(elapsed));
        return new SortingResult(results, props.get("elapsed time"));
    }

    public String getName(){
        return props.get("name");
    }

}
