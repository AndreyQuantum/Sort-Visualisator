package com.azelentsov.sortVisualisator.Core.sortAlgorithms.iterationResultMaker;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import com.azelentsov.sortVisualisator.Core.records.IterationAction;
import com.azelentsov.sortVisualisator.Core.records.IterationActionResult;
import com.azelentsov.sortVisualisator.Core.records.IterationResult;

import java.util.List;

public class IterationResultMaker {

    private List<ArrayElement> listBefore;
    private List<ArrayElement> listAfter;

    public IterationResultMaker(List<ArrayElement> listBefore, List<ArrayElement> listAfter) {
        this.listBefore = listBefore;
        this.listAfter = listAfter;
    }

    private int[] arrayElementsToIntArray(List<ArrayElement> list){
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            array[i] = list.get(i).value();
        }
        return array;
    }

    private IterationActionResult detectIterationAction(){
        IterationAction action = IterationAction.NO_ACTION;
        int[] involvedIndexes = new int[2];
        int involvedIndexesCounter = 0;
        for (int i = 0; i < listBefore.size(); i++){
            if (listBefore.get(i).value() != listAfter.get(i).value()
                    && listBefore.get(i).initIndex() != listAfter.get(i).initIndex()){
                action = IterationAction.SWAP;
                involvedIndexes[involvedIndexesCounter++] = i;
            }
        }
        return new IterationActionResult(action, involvedIndexes);

    }



    public IterationResult getResult(int[] indexesToFocusOn){
        return new IterationResult(
                indexesToFocusOn,
                arrayElementsToIntArray(listBefore),
                arrayElementsToIntArray(listAfter),
                detectIterationAction());
    }
}
