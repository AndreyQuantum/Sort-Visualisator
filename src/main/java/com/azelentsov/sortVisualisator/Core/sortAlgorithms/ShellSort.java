package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import org.springframework.stereotype.Component;

@Component
public class ShellSort extends BaseSort {
    
    private int gapCalculate(int currentGap){
        return calculateHibbardsGap(currentGap);
    }

    private int calculateHibbardsGap(int currentGap){
        return  2^currentGap - 1;
    }

    private int calculateKnuthGap(int currentGap){
        return (3^currentGap-1)/2;
    }

    private int calculateSedgewickGap(int currentGap){
        return 4^currentGap+3*2^(currentGap-1)+1;
    }
    private int calculateStandartGap(int currentGap){
        return currentGap/2;
    }


    @Override
    protected void run() {
        for (int gap = gapCalculate(listToSort.size()); gap>0; gap = gapCalculate(gap)){
            displayVariable(gap, "gap");
            saveArrayBeforeIteration();
            boolean isCompletedAction = false;
            for (int j = gap; j < listToSort.size(); j++){
                displayVariable(listToSort.get(j-gap).value() > listToSort.get(j).value() ? 1: 0, "if j-gap > j");
                for (int i = j; i>=gap && listToSort.get(i-gap).value() > listToSort.get(i).value(); i-=gap){
                    saveArrayBeforeIteration();

                    highlightVariable(i-gap, "i-gap");
                    highlightVariable(i, "i");
                    displayVariable(gap, "gap");

                    swap(i-gap, i);
                    saveArrayAfterIteration();
                    isCompletedAction = true;
                }
            }
            saveArrayIfSwappingWasNotDone(isCompletedAction);
        }
    }

    private void saveArrayIfSwappingWasNotDone(boolean isCompletedAction) {
        if (!isCompletedAction){
            saveArrayAfterIteration();
        }
    }

    @Override
    protected void populateProps() {
        props.put("Time Complexity (Average)", "Depends on gap sequence, commonly O(n^(3/2))");
        props.put("Time Complexity (Best)", "O(n log n)");
        props.put("Time Complexity (Worst)", "O(n^2)");
        props.put("Space Complexity", "O(1)");
        props.put("Stable", "No");
        props.put("In-Place", "Yes");
        props.put("Adaptive", "Yes");
        props.put("First Published", "1959");
        props.put("Swaps", "Varies (dependent on gap sequence)");
        props.put("Passes", "Logarithmic number of passes depending on the gap sequence");
    }
}

