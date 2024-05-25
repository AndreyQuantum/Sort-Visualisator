package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import org.springframework.stereotype.Component;

@Component
public class SelectionSort extends BaseSort {


    @Override
    protected void run() {
        for (int indexToPaste = 0; indexToPaste< listToSort.size(); indexToPaste++){
            saveArrayBeforeIteration();
            int minIndex = indexToPaste;
            boolean isCompared = false;
            for (int findMinElementIndex = minIndex; findMinElementIndex < listToSort.size(); findMinElementIndex++){
                if (listToSort.get(findMinElementIndex).value() < listToSort.get(minIndex).value()){
                    minIndex=findMinElementIndex;
                    isCompared = true;
                }
            }
            displayVariable(isCompared ? 1 : 0, "isCompared");
            if (!isCompared){
                saveArrayAfterIteration();
                break;
            }
            highlightVariable(minIndex, "min");
            highlightVariable(indexToPaste, "toPaste");

            swap(indexToPaste, minIndex);

            saveArrayAfterIteration();
        }
    }

    @Override
    protected void populateProps() {
        props.put("Time Complexity (Average)", "O(n^2)");
        props.put("Time Complexity (Best)", "O(n^2)");
        props.put("Time Complexity (Worst)", "O(n^2)");
        props.put("Space Complexity", "O(1)");
        props.put("Stable", "No");
        props.put("In-Place", "Yes");
        props.put("Adaptive", "No");
        props.put("First Published", "1956");
        props.put("Swaps", "O(n)");
        props.put("Passes", "O(n)");

    }
}
