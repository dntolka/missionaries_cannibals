Missionaries and Cannibals Problem

In the missionaries and cannibals problem, three missionaries and three cannibals must cross a river using a boat which can carry at most two people, under the constraint that, for both banks, if there are missionaries present on the bank, they cannot be outnumbered by cannibals (if they were, the cannibals would eat the missionaries). The boat cannot cross the river by itself with no people on board.

Getting Started

A system for solving the Missionaries and Cannibals problem whereby the current state is represented by a simple vector ⟨left_c, left_m, b, right_c, right_m⟩. The vector's elements represent the number of missionaries, cannibals, and boats on each side, respectively. Since the boat and all of the missionaries and cannibals start on the left side, the vector is initialized to ⟨3,3,1,0,0⟩.

Solutions

The problem was solved using Java language. In the program there are three classes, a State class that saves the current state of the problem Also, in State class exists a method that is called successors method and checks the actions that can be applied to each state. Another state is BFS state and has the breadth_first_search method that returns the solution to the problem.

Compile

javac *.java

How to run 

java Main
