package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import org.springframework.stereotype.Component;

@Component
public class InsertionSort extends BaseSort {
    private void swapping(){
        for (int currentIndex = 1; currentIndex < listToSort.size(); currentIndex++) {
            for (int pointer = currentIndex - 1;
                 pointer >= 0 && listToSort.get(pointer).value() > listToSort.get(pointer + 1).value(); pointer--) {
                saveArrayBeforeIteration();
                highlightVariable(pointer, "point");
                highlightVariable(currentIndex, "current");
                highlightVariable(pointer+1, "point+1");
                swap(pointer + 1, pointer);
                saveArrayAfterIteration();
            }
        }
    }

    private void shifting(){
        int pointer;
        for (int currentIndex = 0; currentIndex < listToSort.size(); currentIndex++){
            int currentElement = listToSort.get(currentIndex).value();
            for (pointer = currentIndex-1; pointer >=0 && listToSort.get(pointer).value() > currentElement; pointer--){
                swap(pointer + 1, pointer);
            }
            swap(pointer + 1, currentIndex);
        }
    }

    private void shiftingBinarySearch(){
        int pointer;
        for (int currentIndex = 0; currentIndex < listToSort.size(); currentIndex++){
            int currentElement = listToSort.get(currentIndex).value();
            int whereToPast = binarySearch(currentElement, 0, currentIndex-1);
            for (pointer = currentIndex-1; pointer >= whereToPast; pointer--){
                swap(pointer + 1, pointer);
            }
            swap(pointer + 1, currentIndex);
        }
    }

    private int binarySearch(int numberToCompare, int startPosition, int endPosition){
        if (endPosition<= startPosition){
            if (numberToCompare <= listToSort.get(startPosition).value()){
                return startPosition +1;
            } else {
                return startPosition;
            }
        }
        int mid = (startPosition + endPosition)/2;
        if (numberToCompare > listToSort.get(mid).value()){
            return binarySearch(numberToCompare, mid+1, endPosition);
        } else {
            return binarySearch(numberToCompare, startPosition, mid -1);
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
        props.put("Suitable For", "Small datasets or nearly sorted datasets");
        props.put("Not Suitable For", "Large datasets");
        props.put("Swaps", "O(n^2)");
        props.put("Passes", "O(n)");
    }
}
