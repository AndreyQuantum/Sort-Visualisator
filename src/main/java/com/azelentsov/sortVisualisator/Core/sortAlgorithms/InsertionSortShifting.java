package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

@Component
public class InsertionSortShifting extends BaseSort {

    @Override
    protected void run() {
            int i, j;
            ArrayElement newValue;

            for (i = 1; i < listToSort.size(); i++) {
                newValue = listToSort.get(i);
                j = i;

                while (j > 0 && listToSort.get(j - 1).value() > newValue.value()) {
                    saveArrayBeforeIteration();
                    displayVariable(newValue.value(), "newValue");
                    highlightVariable(j, "j");
                    highlightVariable(j - 1, "j - 1");
                    swap(j, j - 1);
                    j--;
                    saveArrayAfterIteration();
                }
                listToSort.set(j, newValue);
            }
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
