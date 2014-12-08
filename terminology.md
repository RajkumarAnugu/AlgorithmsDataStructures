Terminology
==

Discrete Mathematics
--

2.1 sets
--
A set is an unordered collection of objects, called elements or members of the set. A set is said to contain its elements. We write a ∈ A to denote that a is an element of the set A. The notation a !∈ A denotes that a is not an element of the set A.
- N = {0,1,2,3,...}, the set of natural numbers
- Z = {...,−2,−1,0,1,2,...}, the set of integers
- Z+ = {1, 2, 3, . . .}, the set of positive integers
- Q = {p/q | p ∈ Z, q ∈ Z, and q != 0}, the set of rational numbers R, the set of real numbers
- R+, the set of positive real numbers
- C, the set of complex numbers.

2.4 Sequences and Summations
--
Sequences are ordered lists of elements.

A sequence is a function from a subset of the set of integers (usually either the set {0, 1, 2, . . .} or the set{1,2,3,...})to a set S. We use the notation an to denote the image of the integer n. We call an a term of the sequence.

3.1 Algorithms
--
brute-force algorithms: 
- find solutions using a straightforward approach without introducing any cleverness.

greedy algorithms 
- a class of algorithms used to solve optimization problems

**An algorithm** is a finite sequence of precise instructions for performing a computation or for solving a problem.

#####Properties of algorithms
- Input. An algorithm has input values from a specified set.
- Output. From each set of input values an algorithm produces output values from a spec-
ified set. The output values are the solution to the problem.
- Definiteness. The steps of an algorithm must be defined precisely.
- Correctness.Analgorithmshouldproducethecorrectoutputvaluesforeachsetofinput
values.
- Finiteness. An algorithm should produce the desired output after a finite (but perhaps
large) number of steps for any input in the set.
- Effectiveness. It must be possible to perform each step of an algorithm exactly and in a
finite amount of time.
- Generality. The procedure should be applicable for all problems of the desired form, not
just for a particular set of input values.

#####Searching Algorithms
**linear search** or **sequential search**
- search one after another until the solution is found, or return 0

**binary search algorithm**
- split list to two sublists, solution is in one of the sublist, repeat the process until the solution is find.

#####Sorting
**bubble sort**
- one of the simplest sorting algorithms, not one of the most efficient.
- successively comparing adjacent elements, interchanging them if they are in the wrong order.

**insertion sort**
- simple but not efficient.
- begin with the second element, compares with other elements set to the place where the element does not exceed the next element, and then start with third element, repeat until the last element.

#####Greedy Algorithms
Algorithms that make what seems to be the “best” choice at each step are called greedy algorithms.

3.2 The Growth of Functions
--
#####Big-O Notation
- estimate the growth of a function without worrying about constant multipliers or smaller order terms.
    - Let f and g be functions from the set of integers or the set of real numbers to the set of real numbers. We say that f (x) is O(g(x)) if there are constants C and k such that
        - |f (x)| ≤ C |g(x)|
    - whenever x > k. [This is read as “f (x) is big-oh of g(x).”]

    - n!=1·2·3· ··· ·n

    - logn! ≤ logn^n = nlogn

Big-O notation is used extensively to describe the growth of functions, but it has limitations. 
- In particular, when f (x) is O(g(x)), we have an upper bound, in terms of g(x), for the size of f (x) for large values of x. 
- However, big-O notation does not provide a lower bound for the size of f (x) for large x. For this, we use 
- big-Omega notation. When we want to give both an upper and a lower bound on the size of a function f (x), relative to a reference function g(x), we use 
- big- Theta notation.

 
5.1 Mathematical Induction
--
- mathematical induction is used extensively to prove results about a large variety of discrete objects. 
- mathematical induction can be used only to prove results obtained in some other way. It is not a tool for discovering formulae or theorems.

- mathematical induction has two parts, a basis step, where we show that P (1) is true, and an inductive step, where we show that for all positive integers k, if P (k) is true, then P (k + 1) is true.



5.3 Recursive Definitions and Structural Induction
--

An algorithm is called recursive if it solves a problem by reducing it to an instance of the same problem with smaller input.

- PRINCIPLE OF MATHEMATICAL INDUCTION 
    - To prove that P(n) is true for all positive integers n, where P (n) is a propositional function, we complete two steps: 
        - BASIS STEP: We verify that P (1) is true.
        - INDUCTIVE STEP: We show that the conditional statement P (k) → P (k + 1) is true for all positive integers k.

- assume that P (k) is true for an arbitrary positive integer k and show that under this assumption, P (k + 1) must also be true. 
- The assumption that P (k) is true is called the **inductive hypothesis**.
- (P (1) ∧ ∀ k (P (k) → P (k + 1))) → ∀ nP (n)
