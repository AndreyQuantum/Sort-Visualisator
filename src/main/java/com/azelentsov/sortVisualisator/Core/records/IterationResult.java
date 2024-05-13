package com.azelentsov.sortVisualisator.Core.records;

import java.util.List;

public record IterationResult(int[] indexesToFocusOn,
                              List<ArrayElement> arrayBeforeIteration,
                              List<ArrayElement> arrayAfterIteration) {
}
