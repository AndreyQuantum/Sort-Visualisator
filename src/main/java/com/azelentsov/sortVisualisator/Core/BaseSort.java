package com.azelentsov.sortVisualisator.Core;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import com.azelentsov.sortVisualisator.Core.records.IterationResult;
import com.azelentsov.sortVisualisator.Core.records.SortingResult;

import java.util.*;

public abstract class BaseSort{

    private final String name = this.getClass().getSimpleName();

    private Map<String, String> props =  new PropsUtils().readProperties(name);

    private List<IterationResult> results = new LinkedList<>();

    protected List<ArrayElement> listToSort;

    private List<ArrayElement> listBefore;


    protected abstract void run();

    protected void saveArrayBeforeIteration(){
        listBefore = deepCopyArrayElements(listToSort);
    }

    protected List<ArrayElement> deepCopyArrayElements(List<ArrayElement> list){
        List<ArrayElement> copy = new LinkedList<>();
        for (ArrayElement element : list){
            copy.add(new ArrayElement(element.initIndex(), element.value()));
        }
        return copy;
    }

    protected void saveArrayAfterIteration(int[] indexesToFocusOn){
        List<ArrayElement> arrayAfter = deepCopyArrayElements(listToSort);
        results.add(new IterationResult(indexesToFocusOn, listBefore, arrayAfter));
    }

    protected void swap(int indexA, int indexB){
        Collections.swap(listToSort, indexA, indexB);
    }

    public Map<String,String> getProps(){
        return props;
    }

    public SortingResult getResult(List<ArrayElement> listToSort) {
        this.listToSort = listToSort;
        this.listBefore = listToSort;
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
