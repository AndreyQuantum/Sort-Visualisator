package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import org.springframework.stereotype.Component;

@Component
public class HeapSort extends BaseSort{
    @Override
    protected void run() {
        for (int root = listToSort.size()/2;root >= 0; root--){
            heapify(root,listToSort.size());
        }
        for (int index = listToSort.size()-1; index > 0; index--){
            saveArrayBeforeIteration();
            highlightVariable(0, "0");
            highlightVariable(index, "index");
            swap(0, index);
            saveArrayAfterIteration();
            heapify(0, index);
        }
    }


    private void heapify(int root, int end){
        saveArrayBeforeIteration();
        int max = root;
        int L = (2*root)+1;
        int R = (2*root)+2;
        if (L < end && listToSort.get(L).value() > listToSort.get(max).value()){
            max = L;
        }
        if (R < end && listToSort.get(R).value() > listToSort.get(max).value()) {
            max = R;
        }
        if (max == root){
            return;
        }
        displayVariable(root,"root");
        displayVariable(L,"L");
        displayVariable(R,"R");
        highlightVariable(root,"root");
        highlightVariable(L,"L");
        highlightVariable(R,"R");
        swap(root,max);
        saveArrayAfterIteration();
        heapify(max,end);
    }
    @Override
    protected void populateProps() {
        props.put("Time Complexity (Average)", "O(n log n)");
        props.put("Time Complexity (Best)", "O(n log n)");
        props.put("Time Complexity (Worst)", "O(n log n)");
        props.put("Space Complexity", "O(1)");
        props.put("Stable", "No");
        props.put("In-Place", "Yes");
        props.put("Adaptive", "No");
        props.put("First Published", "1964");
        props.put("Swaps", "O(n log n)");
        props.put("Passes", "O(log n)");
    }
}
