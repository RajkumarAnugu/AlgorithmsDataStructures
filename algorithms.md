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
I Foundations
--
2.1 Insertion sort
--
Insertion sort is like sort a hand of playing cards:
- start with an empty hand
- take one card each time
- compare the card to the cards already in hand from right to left
- then put it in the right place.

| Algorithm         | Worst-case running time   | Average-case / expected running timea |
| ---               | ---                       | ---                                   |
| Insertion sort    | Θ(n^2)                    | Θ(n^2)                                | 

2.3 Designing algorithms
--
**recursive** structure: 
- solve problem by call themselves recursively to deal with closely related subproblems.

**divide-and-conquer** approach:
- recursive structure typically follow a divide-and-conquer approach.
- which break the problem into several subproblems, solve subproblems recursively, then combine solutions to create a solution to the original problem.
    - **Divide** the problem into a number of subproblems that are smaller instances of the same problem.
    - **Conquer** the subproblems by solving them recursively. If the subproblem sizes are small enough, however, just solve the subproblems in a straightforward manner.
    - **Combine** the solutions to the subproblems into the solution for the original problem.

#####Merge sort
![Merge sort](algorithms/mergesort.png)

- T(n) = Θ(1) if n ⩽ c
    - problem size n, if problem size is small enough say n ⩽ c
- T(n) = aT(n/b) + D(n) +C(n) otherwise
    - a subproblems, each of which is 1/b the size of original.
        - it takes time T(n/b) to solve one subproblem of size n/b
            - so it takes time aT(n/b) to solve a of them.
    - D(n) time to divide the problem into subproblems
    - C(n) time to combine the solutions.

    - total cost :
        - cn(lg n + 1) = cn lg n + cn
            - recursion tree has lg n+1 levels each costing cn
        - ignoring low-order term and constant c:
            - **Θ(n lg n)**

 
| Algorithm         | Worst-case running time   | Average-case / expected running timea |
| ---               | ---                       | ---                                   |
| merge sort        | Θ(n lg n)                 | Θ(n lg n)                             |

II Sorting and Order Statistics
--

Insertion sort, merge sort, heapsort, and quicksort are all comparison sorts:
- they determine the sorted order of an input array by comparing elements.
- heapsort & merge sort are asymtotically optimal comparison sorts.

| Algorithm         | Worst-case running time   | Average-case / expected running timea |
| ---               | ---                       | ---                                   |
| Insertion sort    | Θ(n^2)                    | Θ(n^2)                                |
| merge sort        | Θ(n lg n)                 | Θ(n lg n)                             |
| heapsort          | O(n lg n)                 | -                                     |
| quicksort         | Θ(n^2)                    | Θ(n lg n) (expected)                  |
| Counting sort     | Θ(k + n)                  | Θ(k + n)                              | 
| Radix sort        | Θ(d(n + k))               | Θ(d(n + k))                           |
| Bucket sort       | Θ(n^2)                    | Θ(n) (average-case)                   |

6 Heapsort
--

6.1 Heaps
--
The (binary) heap data structure is an aray object that we can view as a nearly complete binary tree.
- the tree is conpletely filled on all levels except possibly the lowest, which is filled from the left up to a point.
- heap property:
    - If A is a parent node of B then the key of node A is ordered with respect to the key of node B with the same ordering applying across the heap. 
    - Either the keys of parent nodes are always greater than or equal to those of the children and the highest key is in the root node (this kind of heap is called **max heap**) 
    - or the keys of parent nodes are less than or equal to those of the children and the lowest key is in the root node (**min heap**).

![max heap](algorithms/maxheap.png)

The max-heap property:
- A[Parent(i)] ⩾ A[i]
    - largest element is at the root.
        - subtree rooted at a node contains values no larger than that contained at the node itself. 

The min-heap property:
- is opposite with max-heap
    - the smallest element in a min-heap is at the root.
- A[Parent(i)] ⩽ A[i]

| Algorithm         | Worst-case running time   | Average-case / expected running timea |
| ---               | ---                       | ---                                   |
| heapsort          | O(n lg n)                 | -                                     |

6.2 Maintaining the heap property
--
```Java
    public static int[] maxHeapify(int[] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= A.length - 1 && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= A.length - 1 && A[r] > A[i]) {
            largest = r;
        }
        if (largest != i) {
            swap(A, i, largest);
            maxHeapify(A, largest);
        }
        return A;
    }
```
`
run time:
- subtree size n
- cost Θ(1) to fix up the relationships
- the children's subtrees each have size at most 2n/3
- the worst case occurs when the bottom level of the tree is exactly half full.
- T(n) ⩽ T(2n/3) + Θ(1)
    - T(n) = O(lg n)
        - size 2n/3 has max lg n levels which is runtime

6.3 Building a heap
--
```Java
    public static int[] buildMaxHeap(int[] A) {
        for (int i = A.length; i > 0; i--) {
            maxHeapify(A, i);
        }
        return A;
    }
```
`
run time:
- build max heap cost O(n) times to call
- maxHeapity, each maxHeapilty run O(lg n) times
    - so building a heap cost **O(n lg n)**

6.4 The heapsort algorithm
--
```Java
    public static int[] heapsort(int[] A) {
        A = buildMaxHeap(A);
        for (int i = A.length; i < 1; i--) {
            swap(A, 1, i);
            maxHeapify(A, 1);
        }
        return A;
    }
```
`
run time:
- **O(n lg n)**

6.5 Priority queues
--
A **priority queue** 
- is a data structure for maintaining a set S of elements, each with an associated value called key. 
- is an abstract data type which is like a regular queue or stack data structure, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. If two elements have the same priority, they are served according to their order in the queue. <wikipedia>
- While priority queues are often implemented with heaps, they are conceptually distinct from heaps. A priority queue is an abstract concept like "a list" or "a map"; just as a list can be implemented with a linked list or an array, a priority queue can be implemented with a heap or a variety of other methods such as an unordered array. <wikipedia>
- A max-priority queue supports :
    
    - INSERT (S, x) inserts the element x into the set S, which is equivalent to the operation S = S ⋃ {x}.
    - MAXIMUM(S) returns the element of S with the largest key.
    - EXTRACT-MAX (S) removes and returns the element of S with the largest key.
    - INCREASE-KEY (S, x, k) increases the value of element x’s key to the new value k, which is assumed to be at least as large as x’s current key value.


7 Quicksort
--
| Algorithm         | Worst-case running time   | Average-case / expected running timea |
| ---               | ---                       | ---                                   |
| quicksort         | Θ(n^2)                    | Θ(n lg n) (expected)                  |

quicksort is often the best parctical choice for sorting
- efficient on the average
- is often faster in practice than other O(n log n) algorithms.

```Java
    public static void sort(int[] a, int from, int to) {
        if (from >= to) {
            return;
        }
        int p = partition(a, from, to);
        sort(a, from, p - 1);
        sort(a, p + 1, to);
    }

    public static int partitioning(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

// result:
array: 2, 8, 7, 1, 3, 5, 6, 4, 
swap : 2, 8, 7, 1, 3, 5, 6, 4, 
swap : 2, 1, 7, 8, 3, 5, 6, 4, 
swap : 2, 1, 3, 8, 7, 5, 6, 4, 
swap : 2, 1, 3, 4, 7, 5, 6, 8, 
swap : 2, 1, 3, 4, 7, 5, 6, 8, 
swap : 2, 1, 3, 4, 7, 5, 6, 8, 
swap : 2, 1, 3, 4, 7, 5, 6, 8, 
swap : 1, 2, 3, 4, 7, 5, 6, 8, 
a    : 1, 2, 3, 4, 7, 5, 6, 8,   p: 0
a    : 1, 2, 3, 4, 7, 5, 6, 8,   p: 2
swap : 1, 2, 3, 4, 7, 5, 6, 8, 
swap : 1, 2, 3, 4, 7, 5, 6, 8, 
swap : 1, 2, 3, 4, 7, 5, 6, 8, 
swap : 1, 2, 3, 4, 7, 5, 6, 8, 
swap : 1, 2, 3, 4, 5, 7, 6, 8, 
swap : 1, 2, 3, 4, 5, 6, 7, 8, 
a    : 1, 2, 3, 4, 5, 6, 7, 8,   p: 5
a    : 1, 2, 3, 4, 5, 6, 7, 8,   p: 7
a    : 1, 2, 3, 4, 5, 6, 7, 8,   p: 3
       1, 2, 3, 4, 5, 6, 7, 8, 

```
`
![quick sort](algorithms/quicksort.png)

7.4 Analysis of quicksort
--
worst-case partitioning:
```java
    int[] A = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static int partitioning(int[] A, int p, int r) {
        int x = A[r];
        ...
```
`
- run time:
    - partitioning costs Θ(n) time
    - one recursive call (array size 0) cost T (0) = Θ(1)
    - the other recursive call cost T(n-1)
    - T(n) = T(n-1) + T(0) + Θ(n)
        - T(n) = T(n-1) + Θ(n)
            - **T(n) = Θ(n^2)**

best-case partitioning:
- if each of the subproblems size are no more than n/2
- T(n) = 2T(n/2) + Θ(n)
    - **T(n) = Θ(n lg n)**

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


