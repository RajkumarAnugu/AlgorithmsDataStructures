[Huffman Tree](dataStructures/HuffmanTree.md)

[Binary Search Tree](dataStructures/binarySearchTree.md)

[Tree Traversal](treeTraversal.md)

[Algorithms and data structures TDT4120](README.md)

[Algorithms](algorithms.md)

[Terminology](terminology.md)

[Graph](graph/README.md)

[Searching](searching/README.md)



Introduction to Algorithms
==

II Sorting and Order Statistics
--
Insertion sort, merge sort, heapsort, and quicksort are all comparison sorts:
    - they determine the sorted order of an input array by comparing elements.
    - heapsort & merge sort are asymtotically optimal comparison sorts.

| Algorithm         | Worst-case running time   | Average-case / expected running timea |
| --- | --- | --- |
| Insertion sort    | Θ(n^2)                    | Θ(n^2) |
| merge sort        | Θ(n lg n)                 | Θ(n lg n) |
| heapsort          | O(n lg n)                 | -
| quicksort         | Θ(n^2)                    | Θ(n lg n) (expected)
| Counting sort     | Θ(k + n)                  | Θ(k + n) | 
| Radix sort        | Θ(d(n + k))               | Θ(d(n + k))
| Bucket sort       | Θ(n^2)                    | Θ(n) (average-case)

6 Heapsort
--

6.1 Heaps
--

6.4 The heapsort algorithm
--

6.5 Priority queues
--

7 Quicksort
--

7.4 Analysis of quicksort
--

8 Sorting in Linear Time
--

8.2 Counting sort
--

8.3 Radix sort
--

8.4 Bucket sort
--

9 Medians and Order Statistics
--


III Data Structures
--

10 Elementary Data Structures
--

10.2 Linked lists
--
En lenket liste er en enkel lineær datastruktur som representerer elementer i sekvens. Hvert element peker til det neste i rekkefølgen.
```python
class Node:
    def __init__(self):
        self.value = None
        self.next  = None
n1 = Node()
n2 = Node()
n3 = Node()
n1.value = 1
n2.value = 2
n3.value = 3
n1.next  = n2
n2.next  = n3
print ("Linked List:\nn1:"+str(n1.value)+"\nn2:"+str(n1.next.value)+"\nn3:"+str(n1.next.next.value))

Linked List:
n1:1
n2:2
n3:3
```
`
11 Hash Tables
--

11.2 Hash Tables
--

11.3 Hash functions
--

12 Binary Search Trees
--

12.1 What is a binary search tree?
--

12.2 Querying a binry search tree
--


IV Advanced Design and Analysis Techniques
--

15 Dynamic Programming
--


16 Greedy Algorithms
--


16.3 Huffman codes
--


VI Graph Algorithms
--

22 Elementary Graph Algorithms
--


22.2 Breadth-first search
--

22.3 Depth-first search
--

22.4 Topological sort
--


23 Minimum Spanning Trees
--

23.2 The algorithms of Kruskal and Prim
--

24 Single-Source Shortest Paths
--

24.1 The Bellman-Ford algorithm
--


24.3 Dijkstra's algorithm
--

25 All-Pairs Shortest Paths
--

25.2 The Floyd-Warshall algorithm
--


26 Maximum Flow
--

26.2 The Ford-Fulkerson method
--


VII Selected Topics
--

34 NP-Completeness
--


