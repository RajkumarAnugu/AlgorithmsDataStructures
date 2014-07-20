Data Structures
==


[Huffman Tree](HuffmanTree.md)

[Binary Search Tree](binarySearchTree.md)

[Algorithms and data structures TDT4120](../README.md)

Linked list
--

- A linked list object holds reference to the first node, and each node holds a reference to the next node.

- When adding or removing the first element the reference to the first node must be updated.

- Alist iterator object has a reference to the last visited node.

- To advance an iterator, update the position and remember the old position for the remove method. 

- In a doubly-linked list, accessing an element is an O(n) operation; adding and removing an element is O(1). 

efficiency of array list operation: 
--

- Getting or setting an array list element is an O(1) operation.

- Inserting or removing an array list element is an O(n) operation.

- Adding or removing the last element in an array list takes amortized O(1) time. 

Stacks and Queues:
--
- A stack can be implemented as a linked list, adding and removing elements at the front.

- When implementing a stack as an array list, add and remove elements at the back. (last in first out) 

- A queue can be implemented as a linked list, adding elements at the back and removing them at the front. 

- In a circular array implementation of a queue, element locations wrap from the end of the array to the beginning. 

```
 
    class Stack 
    ...........
    Node first
    -----------

    class Node
    ...........
    Object data
    Node next
    -----------

    class Queue
    ...........
    Node first
    Node last
    -----------
```

Hash tables:
----

- A good hash function minimizes collisions, identical hash codes for different objects.

- A hash table uses the hash code to determine where to store each element. 

- A hash table can be implemented as an array of buckets - sequences of nodes that hold elements with the same hash code.

- If there are no or only a few collisions, then adding, locating, and removing hash table elements takes constant or O(1) time.

Tree
--

Binary Search Trees:
--

- All nodes in a binary search tree fulfill the property that the descendants to the left have smaller data values than the node data value, and the descendants to the right have larger data values.

```
a binary search tree:
        2
    1       3

a binary tree but not a binary search tree:
        2
    3       1
```


