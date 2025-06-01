# AVL Tree Performance Analysis

This project analyzes the performance of an AVL tree data structure with a large dataset of student records. It measures and reports performance metrics for insertion, search, traversal, and removal operations.

## Project Structure

- `src/` - Source code directory
  - `AVLNode.java` - Represents a node in the AVL tree
  - `AVLTree.java` - Implementation of the AVL tree data structure
  - `Student.java` - Represents a student record from the dataset
  - `CSVReader.java` - Utility class for reading and parsing CSV data
  - `PerformanceAnalyzer.java` - Analyzes and reports performance metrics
  - `App.java` - Main class to run the analysis

- `data/` - Data directory
  - `dataset.csv` - Dataset containing student records

## Features

- **AVL Tree Implementation**: A balanced binary search tree with O(log n) complexity for insert, search, and delete operations
- **Performance Analysis**: Measures and reports time taken for various operations
- **Large Dataset Processing**: Handles a dataset of 11,000+ student records

## How to Compile and Run

### Compilation

```
javac src/AVLNode.java src/AVLTree.java src/CSVReader.java src/PerformanceAnalyzer.java src/Student.java src/App.java
```

### Execution

```
java src.App
```

## Performance Metrics

The application measures and reports the following performance metrics:

1. **Insertion Time**: Time taken to insert all students into the AVL tree
2. **Search Time**: Time taken to search for a specified number of random students
3. **Traversal Time**: Time taken to perform an inorder traversal of the tree
4. **Removal Time**: Time taken to remove a specified number of students from the tree

## Sample Output

```
Starting AVL Tree Performance Analysis
======================================
Loaded 11000 students from data/dataset.csv
Sample student: Student{studentId='S1000', age=23, examScore=56.2}

Running performance analysis with:
- Total students: 11000
- Number of searches: 5000
- Number of removals: 1000

===== AVL Tree Performance Analysis =====

Measuring insertion time for 11000 students...
Insertion time: 10 ms
Tree size after insertion: 11000

Measuring search time for 5000 random students...
Search time: 7 ms
Students found: 5000 out of 5000

Measuring inorder traversal time...
Number of students in traversal: 11000
First 5 students in sorted order:
  1. Student{studentId='S1000', age=23, examScore=56.2}
  2. Student{studentId='S10000', age=23, examScore=76.8}
  3. Student{studentId='S10001', age=20, examScore=57.6}
  4. Student{studentId='S10002', age=24, examScore=36.1}
  5. Student{studentId='S10003', age=19, examScore=85.7}
Traversal time: 2 ms

Measuring removal time for 1000 random students...
Removal time: 3 ms
Students removed: 1000 out of 1000
Tree size after removal: 10000

===== Performance Summary =====
Total number of students: 11000
Total insertion time: 10 ms (avg: 0.000909 ms per student)
Total search time: 7 ms (avg: 0.001400 ms per search)
Total traversal time: 2 ms
Total removal time: 3 ms (avg: 0.003000 ms per removal)
=============================

Performance analysis completed successfully!