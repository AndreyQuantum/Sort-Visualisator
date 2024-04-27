package com.azelentsov.sortVisualisator.SortAlgorythms;

public class BubbleSort extends BaseSort {


    public BubbleSort(int lengthOfArray) {
        super(lengthOfArray);

    }



    @Override
    protected void doOneIteration() {
        optimized();
    }

    private void standart(){
        for (int endPointer = arrayToSort.length; endPointer>1; endPointer--){
            for (int currentIndex=1; currentIndex< endPointer; currentIndex++){
                if (arrayToSort[currentIndex-1] > arrayToSort[currentIndex]){
                    swap(currentIndex-1, currentIndex);
                }
            }
        }
    }
    private void optimized(){
        for (int endPointer = arrayToSort.length; endPointer>1; endPointer--){
            boolean isNotSwapped = true;
            for (int currentIndex=1; currentIndex< endPointer; currentIndex++){
                if (arrayToSort[currentIndex-1] > arrayToSort[currentIndex]){
                    swap(currentIndex-1, currentIndex);
                    isNotSwapped = false;
                }
            }
            if (isNotSwapped){
                break;
            }
        }
    }


    public static void main(String[] args) {
        var sort = new BubbleSort(3);
        System.out.println(sort.getProperties());
//        System.out.println("Element count \t elapsed time");
//        for (int N = 10; N<=1_000_000; N*=10){
//            var bubbleTest = new BubbleSort(N);
//            bubbleTest.run();
//        }
    }

}
