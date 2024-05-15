package com.azelentsov.sortVisualisator.Core.records;

import java.util.List;

public record IterationResult(int[] indexesToFocusOn,
                              int[] arrayBeforeIteration,
                              int[] arrayAfterIteration,
                              IterationActionResult actionResult) {
}
