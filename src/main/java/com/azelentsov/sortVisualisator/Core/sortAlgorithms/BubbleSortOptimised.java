package com.azelentsov.sortVisualisator.Core.sortAlgorithms;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BubbleSortOptimised extends BaseSort {

    @Override
    protected void run() {
        optimized();
    }

    private void optimized(){
        for (int b = listToSort.size(); b>1; b--){
            boolean isNotSwapped = true;
            for (int i=1; i< b; i++){
                saveArrayBeforeIteration();
                int prev = i-1;
                if (listToSort.get(prev).value() > listToSort.get(i).value()){
                    swap(prev, i);
                    isNotSwapped = false;
                }
                highlightValue(prev,"prev");
                highlightValue(i, "i");
                highlightValue(b, "b");
                saveArrayAfterIteration();
            }
            if (isNotSwapped){
                break;
            }
        }
    }

}
