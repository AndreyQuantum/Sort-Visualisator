package com.azelentsov.sortVisualisator.Core.sortAlgorithms;


import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BubbleSort extends BaseSort {

    @Override
    protected void run() {
        standart();
    }

    private void standart(){
        for (int endPointer = listToSort.size(); endPointer>1; endPointer--){
            for (int currentIndex=1; currentIndex < endPointer; currentIndex++){
                saveArrayBeforeIteration();
                if (listToSort.get(currentIndex-1).value() > listToSort.get(currentIndex).value()){
                    swap(currentIndex-1, currentIndex);
                }
                saveArrayAfterIteration(new int[]{currentIndex-1, currentIndex });
            }
        }
    }
}
