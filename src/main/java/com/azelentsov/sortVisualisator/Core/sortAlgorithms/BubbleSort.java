package com.azelentsov.sortVisualisator.Core.sortAlgorithms;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BubbleSort extends BaseSort {

    @Override
    protected void run() {
        standart();
    }

    private void standart(){
        for (int b = listToSort.size(); b>1; b--){
            for (int i=1; i < b; i++){
                saveArrayBeforeIteration();
                int prev = i-1;
                if (listToSort.get(prev).value() > listToSort.get(i).value()){
                    swap(prev, i);
                }
                highlightValue(prev,"prev");
                highlightValue(i, "i");
                highlightValue(b, "b");
                saveArrayAfterIteration();
            }
        }
    }
}
