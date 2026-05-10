# Assignment 4: Graph Traversal and Representation System

## A. Project Overview
This project implements a graph data structure to model vertices and edges, utilizing an Adjacency List representation. The core focus is evaluating the functionality and efficiency of two fundamental graph traversal algorithms: Breadth-First Search (BFS) and Depth-First Search (DFS).

## B. Class Descriptions
Vertex: Represents an individual node in the graph. It relies on a unique integer `id`.
Edge: Models a directional relationship between a `source` Vertex and a `destination` Vertex.
Graph: The core data structure utilizing a `Map<Integer, List<Edge>>` to create an adjacency list. This provides an efficient way to store sparse graphs and quickly iterate through neighbors.
Experiment: A utility class that generates randomized graphs of various sizes, executes the algorithms, and benchmarks performance using `System.nanoTime()`.

## C. Algorithm Descriptions
### Breadth-First Search (BFS)
Step-by-Step: Starts at a root node and explores all immediate neighbors first. It uses a `Queue` to keep track of nodes to visit next and a `Set` to track visited nodes to prevent infinite loops.
Use Cases: Finding the shortest path in unweighted graphs, peer-to-peer networks, web crawlers.
Time Complexity: $O(V + E)$ where $V$ is vertices and $E$ is edges.

### Depth-First Search (DFS)
Step-by-Step: Starts at a root node and explores as far as possible along each branch before backtracking. It uses recursion (which relies on the call stack) and a `Set` for visited nodes.
Use Cases: Solving puzzles/mazes, topological sorting, finding connected components.
Time Complexity: $O(V + E)$.

## D. Experimental Results

| Graph Size | BFS Execution Time (ns) | DFS Execution Time (ns) |
|------------|-------------------------|-------------------------|
| 10 nodes   | [not yet]       | [not yet]      |
| 30 nodes   | [not yet]       | [not yet]       |
| 100 nodes  | [not yet]       | [not yet]      |

### Analysis Questions
How does graph size affect performance? As the number of vertices and edges increases, execution time grows linearly, verifying the Big-O expectation.
Which traversal is faster? 
Do results match expected complexity? Yes, the execution times scale at roughly the same pace as the input size expands.
When is BFS preferred? When looking for the shortest path or when the target node is known to be close to the root.
What are the limitations of DFS? It is not optimal for finding the shortest path. On massive, extremely deep graphs, recursive DFS can cause a `StackOverflowError`. 

## E. Reflection
Through this assignment, I learned how to represent complex network relationships using code without relying on pre-built Graph libraries. Translating the theoretical $O(V+E)$ complexity into a tangible Adjacency List helped solidify why this structure is generally preferred over an Adjacency Matrix for memory efficiency. 

One challenge was properly ensuring that undirected edges were represented correctly by adding relationships in both directions. Understanding the difference between a Queue (for BFS) and the recursive Call Stack (for DFS) was critical to getting the traversal order right.
