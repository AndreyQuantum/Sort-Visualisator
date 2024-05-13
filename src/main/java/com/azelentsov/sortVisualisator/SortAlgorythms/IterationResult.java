package com.azelentsov.sortVisualisator.SortAlgorythms;

import java.util.List;

public record IterationResult(int[] indexesToFocusOn,
                              List<ArrayElement> arrayBeforeIteration,
                              List<ArrayElement> arrayAfterIteration) {
}
