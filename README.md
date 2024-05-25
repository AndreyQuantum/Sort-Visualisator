# Sort Visualisator

This repository contains a Java Spring Boot and JavaScript tool for visualizing sorting algorithms.

## Implementing a New Visualization

To create a new algorithm visualization, follow these steps:

1. **Create a New Class**:
    - Navigate to the `src/main/java/com/azelentsov/sortVisualisator/Core/sortAlgorithms` directory.
    - Create a new class file and extend the abstract class `BaseSort`.

2. **Implement Required Methods**:
    - **run()**: Implement the main algorithm logic within the `run` method. During each iteration of the algorithm, call `saveArrayBeforeIteration()` before the iteration and `saveArrayAfterIteration()` after the iteration. This approach saves and detects swaps of array elements for visualization purposes. Between this functions use the `highlightVariable()` method to highlight variables, and the `displayVariable()` method to display variables in the table beneath the sorting graph.
    - **populateProps()**: Populate the properties of your algorithm in the `props` HashMap. This HashMap will be used to populate the algorithm comparison row.

3. **Annotation**:
    - After implementing the above steps, don't forget to add the `@Component` annotation to the class.

