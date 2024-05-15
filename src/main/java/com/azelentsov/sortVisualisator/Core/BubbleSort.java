package com.azelentsov.sortVisualisator.Core;


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
                saveArrayAfterIteration(new int[]{currentIndex, currentIndex - 1});
            }
        }
    }

    private void optimized(List<ArrayElement> listToSort){
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


//    public static void main(String[] args) {
////        System.out.println(sort.getProperties());
//        System.out.println("Element count \t elapsed time");
//        for (int N = 10; N<=1_000_000; N*=10){
//            var bubbleTest = new BubbleSort();
//            System.out.println(bubbleTest.getResult(new Random().generateArray(5,10)));
//        }
//    }

}
