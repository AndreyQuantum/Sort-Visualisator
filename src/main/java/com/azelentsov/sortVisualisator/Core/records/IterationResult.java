package com.azelentsov.sortVisualisator.Core.records;


public record IterationResult(int[] indexesToFocusOn,
                              int[] arrayBeforeIteration,
                              int[] arrayAfterIteration,
                              IterationActionResult actionResult) {
}
