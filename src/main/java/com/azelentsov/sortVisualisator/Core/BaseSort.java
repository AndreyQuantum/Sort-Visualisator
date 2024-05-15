package com.azelentsov.sortVisualisator.Core;

import com.azelentsov.sortVisualisator.Core.records.*;

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
        List<ArrayElement> listAfter = deepCopyArrayElements(listToSort);
        IterationActionResult iterationActionResult = detectIterationAction(listBefore, listAfter);
        results.add(
                new IterationResult(
                        indexesToFocusOn,
                        arrayElementsToIntArray(listBefore),
                        arrayElementsToIntArray(listAfter),
                        iterationActionResult)
        );
    }

    private int[] arrayElementsToIntArray(List<ArrayElement> list){
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            array[i] = list.get(i).value();
        }
        return array;
    }

    private IterationActionResult detectIterationAction(List<ArrayElement> listBefore, List<ArrayElement> listAfter){
        IterationAction action = IterationAction.NO_ACTION;
        int[] involvedIndexes = new int[2];
        int involvedIndexesCounter = 0;
        for (int i = 0; i < listBefore.size(); i++){
            if (listBefore.get(i).value() != listAfter.get(i).value()
                && listBefore.get(i).initIndex() != listAfter.get(i).initIndex()){
                action = IterationAction.SWAP;
                involvedIndexes[involvedIndexesCounter++] = i;
            }
        }
        return new IterationActionResult(action, involvedIndexes);

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
