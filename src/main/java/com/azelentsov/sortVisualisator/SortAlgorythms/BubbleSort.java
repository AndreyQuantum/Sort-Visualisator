package com.azelentsov.sortVisualisator.SortAlgorythms;


public class BubbleSort extends BaseSort {


    public BubbleSort(int lengthOfArray) {
        super(lengthOfArray);

    }


    @Override
    public void run() {
        standart();
    }

    private void standart(){
        for (int endPointer = arrayToSort.size(); endPointer>1; endPointer--){
            for (int currentIndex=1; currentIndex < endPointer; currentIndex++){
                saveArrayBeforeIteration();
                if (arrayToSort.get(currentIndex-1).value() > arrayToSort.get(currentIndex).value()){
                    swap(currentIndex-1, currentIndex);
                }
                saveArrayAfterIteration(new int[]{currentIndex, currentIndex - 1});
            }
        }
    }

    private void optimized(){
        for (int endPointer = arrayToSort.size(); endPointer>1; endPointer--){
            boolean isNotSwapped = true;
            for (int currentIndex=1; currentIndex< endPointer; currentIndex++){
                saveArrayBeforeIteration();
                if (arrayToSort.get(currentIndex-1).value() > arrayToSort.get(currentIndex).value()){
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


    public static void main(String[] args) {
        var sort = new BubbleSort(10);
//        System.out.println(sort.getProperties());
        System.out.println("Element count \t elapsed time");
        for (int N = 10; N<=1_000_000; N*=10){
            var bubbleTest = new BubbleSort(N);
            bubbleTest.run();
            System.out.println(bubbleTest.getResults());
        }
    }

}
