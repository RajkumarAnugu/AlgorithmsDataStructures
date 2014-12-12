Terminology
==

Discrete Mathematics and Its Application
==
- Discrete mathematics provides the mathematical foundations for many computer science courses including data structures, algorithms, database theory, automata theory, formal languages, compiler theory, computer security, and operating systems.

1       The Foundations: Logic and Proofs
--
Logic is the basis of all mathematical reasoning, and of all automated reasoning. 
- It has practical applications to the design of computing machines, to the specification of systems, to artificial intelligence, to computer programming, to programming languages, and to other areas of computer science...

To understand mathematics, we must understand what makes up a correct mathematical argument, 
- that is, **a proof**. 
    - Once we prove a mathematical statement is true, we call it **a theorem**. 
        - A collection of theorems on a topic organize what we know about this topic.
    - proofs are used to: 
        - verify that computer programs produce the correct output for all possible input values, 
        - to show that algorithms always produce the correct result, 
        - to establish the security of a system, 
        - and to create artificial intelligence. 
        - Furthermore, 
            - automated reasoning systems have been created to allow computers to construct their own proofs.

1.1     Propositional Logic
--
The rules of logic give precise meaning to mathematical statements. 
- These rules are used to distinguish between valid and invalid mathematical arguments

A **proposition** is a declarative sentence 
- (that is, a sentence that declares a fact) 
    - that is either true or false, but not both.

    
        Conjunction: Let p and q be propositions. The conjunction of p and q, denoted by p ∧ q, is the proposition “p and q.” The conjunction p ∧ q is true when both p and q are true and is false otherwise.

1.2     Applications of Propositional Logic
--

1.3     Propositional Equivalences
--

1.4     predicates and Quantifiers
--

1.5     Nested Quantifiers
--

1.6     Rules of Inference
--

1.7     Introduction to Proofs
--

2       Basic Structures: Sets, Functions, Sequences, Sums, and Matrices
--

2.1     Sets
--
A set is an unordered collection of objects, called elements or members of the set. A set is said to contain its elements. We write a ∈ A to denote that a is an element of the set A. The notation a !∈ A denotes that a is not an element of the set A.
- N = {0,1,2,3,...}, the set of natural numbers
- Z = {...,−2,−1,0,1,2,...}, the set of integers
- Z+ = {1, 2, 3, . . .}, the set of positive integers
- Q = {p/q | p ∈ Z, q ∈ Z, and q != 0}, the set of rational numbers R, the set of real numbers
- R+, the set of positive real numbers
- C, the set of complex numbers.
2.2     Set Operations
--
2.3     Functions
--
2.4     Sequences and Summations
--
Sequences are ordered lists of elements.

A sequence is a function from a subset of the set of integers (usually either the set {0, 1, 2, . . .} or the set{1,2,3,...})to a set S. We use the notation an to denote the image of the integer n. We call an a term of the sequence.
2.5     Cardinality of Sets
--
2.6     Matrices
--
3       Algorithms
--
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

3.3     Complexity of Algorithms
--
4       Number Theory and Cryptography
--
4.1     Divisibility and Modular Arithmetic
--
4.2     Integer Representations and Algorithms
--
4.3     Primes and Greatest Common Divisors
--
4.4     Solving Congruences
--
4.5     Applications of Congruences
--
4.6     Cryptography
--
5       Induction and Recursion
--
5.1     Mathematical Induction
--
- mathematical induction is used extensively to prove results about a large variety of discrete objects. 
- mathematical induction can be used only to prove results obtained in some other way. It is not a tool for discovering formulae or theorems.

- mathematical induction has two parts, a basis step, where we show that P (1) is true, and an inductive step, where we show that for all positive integers k, if P (k) is true, then P (k + 1) is true.

5.2     Strong Induction and Well-Ordering
--

5.3     Recursive Definitions and Structural Induction
--

An algorithm is called recursive if it solves a problem by reducing it to an instance of the same problem with smaller input.

- PRINCIPLE OF MATHEMATICAL INDUCTION 
    - To prove that P(n) is true for all positive integers n, where P (n) is a propositional function, we complete two steps: 
        - BASIS STEP: We verify that P (1) is true.
        - INDUCTIVE STEP: We show that the conditional statement P (k) → P (k + 1) is true for all positive integers k.

- assume that P (k) is true for an arbitrary positive integer k and show that under this assumption, P (k + 1) must also be true. 
- The assumption that P (k) is true is called the **inductive hypothesis**.
- (P (1) ∧ ∀ k (P (k) → P (k + 1))) → ∀ nP (n)


5.4     Recursive Algorithms     
--



6       Counting
--
6.1     The Basics of Counting
--
6.2     The Pigeonhole Principle
--
6.3     Permutations and Combinations
--
6.4     Binomial Coefficients and Identities
--
6.5     Generalized Permutations and Combinations
--
8       Advanced Counting Techniques
--
8.1     Applications of Recurrence relations
--
8.2     Solving Linear Recurrence Relations
--


9       Relations
--
9.1     Relations and Their Properties
--
9.2     n-ary Relations and Their Applications
--
9.3     Representing Relations
--
9.4     Closures of Relations
--
9.5     equivalence Relations
--
9.6     Partial Orderings
--


10      Graphs
--
10.1    Graphs and Graph Models
--
10.2    Graph Terminology and Special Types of Graphs
--
10.3    Representing Graphs and Graph Isomorphism
--
10.4    Connectivity
--
10.5    Euler and Hamilton Paths
--
10.6    Shortest-Path Problems
--

11      Trees
--
11.1    Introduction to Trees
--
11.2    Applications of Trees
--
11.3    Tree Traversal
--
11.4    Spanning Trees
--
11.5    Minimum Spanning Trees
--


13      Modeling Computation
--
13.1    Languages and Grammars
--
13.2    Finite-State Machines with Output
--
13.3    Finite-State Machines with No Output
--
13.4    Language Recognition
--
13.5    Turing Machines
--

