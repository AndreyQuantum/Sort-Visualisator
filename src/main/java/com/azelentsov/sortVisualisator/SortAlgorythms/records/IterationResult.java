package com.azelentsov.sortVisualisator.SortAlgorythms.records;

import java.util.List;

public record IterationResult(int[] indexesToFocusOn,
                              List<ArrayElement> arrayBeforeIteration,
                              List<ArrayElement> arrayAfterIteration) {
}
