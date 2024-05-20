package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuickSort extends BaseSort{
    @Override
    protected void run() {
        quickSort(0, listToSort.size() - 1);
    }

    private void quickSort(int l, int r) {
//        условие выхода из рекурсии - чтобы левая граница не зашла на правую
        if (l >= r) return;
//        выполняем основную суть алгоритма - переносим левую часть влево, правую вправо от pivot
        int middleElementIndex = split(l, r);
//        отсортировываем так же левую и правую часть
        quickSort(l, middleElementIndex - 1);
        quickSort(middleElementIndex, r);
    }

    private int split(int l, int r) {
/*     Идея - делим алгоритм на 3 части:
        1) Часть, меньшая опорного эл-та
        2) Часть больше опорного эл-та
        3) Неотсортированная часть массива
        Увеличиваем постоянно неотсортированную часть, если первый эл-т неотсортированной
        части меньше опорного эл-та, тогда свапаем последний элемент меньшей части и увеличиваем
        границу меньшей части на 1
        */
        int pivot = r;
        int low = l-1;
        for (int unsort = l; unsort <= r; unsort++){
            saveArrayBeforeIteration();
            if (listToSort.get(unsort).value() <= listToSort.get(pivot).value()){
                swap(++low, unsort);
            }
            HashMap<Integer, String> vars = new HashMap<>();
            Map<Integer,String> res = new HashMap<>();
            res.put(low, "low");
            res.put(l,"l");
            res.put(unsort, "unsort");
            res.put(pivot, "pivot");
            res.put(r,"r" );
            saveArrayAfterIteration(res);
        }
        return low;
    }
}
