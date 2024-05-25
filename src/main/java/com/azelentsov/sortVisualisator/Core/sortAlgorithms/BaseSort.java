package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import com.azelentsov.sortVisualisator.Core.sortAlgorithms.iterationResultMaker.IterationResultMaker;
import com.azelentsov.sortVisualisator.Core.records.*;

import java.util.*;

public abstract class BaseSort{

    protected Map<String, String> props =  new HashMap<>(Map.of("name", this.getClass().getSimpleName()));

    private List<IterationResult> results = new LinkedList<>();

    protected List<ArrayElement> listToSort;

    private List<ArrayElement> listBefore;

    private Map<Integer, List<String>> indexesToFocusOn = new HashMap<>();

    private Map<String, Integer> indexesToDisplay = new HashMap<>();


    protected abstract void run();

    protected abstract void populateProps();

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

    protected void saveArrayAfterIteration(){
        List<ArrayElement> listAfter = deepCopyArrayElements(listToSort);
        IterationResultMaker resultMaker = new IterationResultMaker(listBefore, listAfter);
        results.add(resultMaker.getResult(indexesToFocusOn, indexesToDisplay));
        indexesToFocusOn = new HashMap<>();
        indexesToDisplay = new HashMap<>();
    }

    protected void highlightVariable(int index, String variableName){
        if (indexesToFocusOn.containsKey(index)){
            indexesToFocusOn.get(index).add(variableName);
        } else {
            indexesToFocusOn.put(index, new ArrayList<>(List.of(variableName)));
        }
    }

    protected void displayVariable(int value,String variableName){
        indexesToDisplay.put(variableName,value);
    }

    protected void swap(int indexA, int indexB){
        Collections.swap(listToSort, indexA, indexB);
    }

    public Map<String,String> getProps(){
        populateProps();
        return props;
    }

    public SortingResult getResult(List<ArrayElement> listToSort) {
        results = new LinkedList<>();
        this.listToSort = listToSort;
        this.listBefore = listToSort;
        long start = System.currentTimeMillis();
        run();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        return new SortingResult(results, elapsed);
    }

    public String getName(){
        return props.get("name");
    }

}
