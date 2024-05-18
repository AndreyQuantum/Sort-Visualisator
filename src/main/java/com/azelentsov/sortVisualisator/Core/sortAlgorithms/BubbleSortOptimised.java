package com.azelentsov.sortVisualisator.Core.sortAlgorithms;


import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BubbleSortOptimised extends BaseSort {

    @Override
    protected void run() {
        optimized();
    }

    private void optimized(){
        for (int endPointer = listToSort.size(); endPointer>1; endPointer--){
            boolean isNotSwapped = true;
            for (int currentIndex=1; currentIndex< endPointer; currentIndex++){
                saveArrayBeforeIteration();
                if (listToSort.get(currentIndex-1).value() > listToSort.get(currentIndex).value()){
                    swap(currentIndex-1, currentIndex);
                    isNotSwapped = false;
                }
                saveArrayAfterIteration(new int[]{currentIndex, currentIndex - 1});
            }
            if (isNotSwapped){
                break;
            }
        }
    }

}
