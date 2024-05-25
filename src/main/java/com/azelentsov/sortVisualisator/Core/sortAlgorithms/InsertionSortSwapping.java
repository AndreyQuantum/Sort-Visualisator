package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import org.springframework.stereotype.Component;

@Component
public class InsertionSortSwapping extends BaseSort {
    private void swapping(){
        for (int currentIndex = 1; currentIndex < listToSort.size(); currentIndex++) {
            saveArrayBeforeIteration();
            highlightVariable(currentIndex, "current");
            boolean hasLoop = false;
            for (int pointer = currentIndex - 1;
                 pointer >= 0 && listToSort.get(pointer).value() > listToSort.get(pointer + 1).value(); pointer--) {
                saveArrayBeforeIteration();
                highlightVariable(pointer, "point");
                highlightVariable(currentIndex, "current");
                highlightVariable(pointer+1, "point+1");
                swap(pointer + 1, pointer);
                saveArrayAfterIteration();
                hasLoop = true;
            }
            saveArrayIfForWasNotCompleted(hasLoop);
        }
    }

    private void saveArrayIfForWasNotCompleted(boolean hasLoop) {
        if (!hasLoop){
            saveArrayAfterIteration();
        }
    }


    @Override
    protected void run() {
        swapping();
    }

    @Override
    protected void populateProps() {
        props.put("Time Complexity (Average)", "O(n^2)");
        props.put("Time Complexity (Best)", "O(n)");
        props.put("Time Complexity (Worst)", "O(n^2)");
        props.put("Space Complexity", "O(1)");
        props.put("Stable", "Yes");
        props.put("In-Place", "Yes");
        props.put("Adaptive", "Yes");
        props.put("First Published", "1946");
        props.put("Swaps", "O(n^2)");
        props.put("Passes", "O(n)");
    }
}
