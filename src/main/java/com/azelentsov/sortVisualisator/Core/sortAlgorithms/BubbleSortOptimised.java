package com.azelentsov.sortVisualisator.Core.sortAlgorithms;


import org.springframework.stereotype.Component;

@Component
public class BubbleSortOptimised extends BaseSort {

    @Override
    protected void run() {
        for (int b = listToSort.size(); b>1; b--){
            boolean isNotSwapped = true;
            for (int i=1; i< b; i++){
                saveArrayBeforeIteration();
                int prev = i-1;
                if (listToSort.get(prev).value() > listToSort.get(i).value()){
                    swap(prev, i);
                    isNotSwapped = false;
                }
                highlightVariable(prev,"prev");
                highlightVariable(i, "i");
                highlightVariable(b, "b");
                saveArrayAfterIteration();
            }
            if (isNotSwapped){
                break;
            }
        }
    }

    @Override
    protected void populateProps() {
        props.put("Time Complexity (Average)", "O(n^2)");
        props.put("Time Complexity (Best)", "O(n)");
        props.put("Time Complexity (Worst)", "O(n^2)");
        props.put("Swaps", "O(n^2)");
        props.put("Passes", "O(n)");
        props.put("Space Complexity", "O(1)");
        props.put("Stable", "Yes");
        props.put("In-Place", "Yes");
        props.put("Adaptive", "Yes");
        props.put("First Published", "1956");
        props.put("Suitable For", "Small datasets or nearly sorted datasets");
        props.put("Not Suitable For", "Large datasets");
    }

}
