# **COMP2003 Assignment 1**
###### Devnitha Dewasinghe - 22714671

---

### *Overview*

This is a WBS(Work Breakdown Structure) management tool for software engineers to estimate effort. This loads a WBS from a file the allows the user to estimate task effort using different estimation stratagies then displays the WBS as a tree structure and saves the updates WBS into the original file.

### *Strategy pattern*

Strategy patterns used to support different ways for reconciling estimating effort entered by multiple estimations. Interface named `EstimateStrategy` defines operations used to calculate final estimations from a list. This interface is implemented by three strategy classes

1. `HighestStrategy`
2. `MedianStrategy`
3. `DiscussStrategy`

`Configuration` class stores the currently selected strategy. When user implements a task `EstimateManager` gets the strategy from the configuration and call it through `EstimateStrategy`. Because the `EstimateManager` only depends on the `EstimateStrategy` rather than specific implmentation the reconciliation method can be changed at runtime without having to change the estimtion logic. This shows ***polymorphism***.

### *Alternative for Strategy planner*

Could have usedlarge `switch` statements indide the `EstimateManager` to decide how to calculate final estimation. Adding a new estimation method would make need of modification to the existing code which make the app harder to extend in case of need to add new strategies.

### *Composite pattern*

The hierarchical structure of the WBS is shown in this as an abstract `Task` class representing all tasks. `GroupTask` and `LeafTask` are the two extended subclasses which contains child tasks and represents indivdual tasks accordingly.

While each `GroupTask` maintas a collection of child `Task` objects teh `WBS` stores the root tasks cas both `GroupTask` and `LeafTask` usese teh same base class. This allow operations to traverse the hierarchy without needing a seprate logic for each of the tasks.

### *Alternative for Composite*

Alternative implementation would have been to store every task in a single list and use parent IDs whenever relationships needed to be found. While this wld work displayhing th eWBS and recursively estimating subtasks would require repeatedly searching the list for child tasks. Using the composite pattern models the hierarchical nature of a WBS more naturally and makes recursive operations much simplar.

### *Map usage*

Within the `WBS` class `Map<String, Task>` is used to efficiantly store and get tasks by their IDs, and makes it easier to lookup when loading the file.

### *Error handling*

This uses exception handling to deal with invalid input files and input/output errors. I made custom exception named `InvalidWBSFileException` to be thrown when the input file is not staisfing the required WBS format.

### *Logging*

To record important events during program execution. Includes loading and saving the WBS file change done to the configuration and final effort estimation.

### Issues i ran into

1. Understanding the WBS

At first i found it diffult to understand how the WBS file should be converted into a tree structure. Reading the file like by line was straightforward but creating parent child relationships between tasks required a different approach. I solved this by first creating all task objects and then linked them together.

2. IMplementing design patterns 

Understanding how to apply the strategy pattern and composite pattern correctly was challenging. I design it so that it demonstrates proper object oriented priniciples and runtime polymorphism.

3. FIle loading and saving

File loading was straightforward but saving th eupdated WBS back into the same format was difficult, I had to make ssure the saved file preserved the required strucure while updating estimated effort correctly. 

4. matching the assignment specification

Throughout the development i repeatedly compared my implementaion with the assignment specification. Small requirements lie displaying all entered estimates before reconciliation, recurrsive estimating subtask and saving the updated WBS before exiting. 

Over the for the biggest issue was not writing individual methods it was integrating all components so they worked together while satisfying the requirements.