# mutation-rates-genetic-algorithm

<h4>Purpose of Repository:</h4>
This repository is the location of the code for Iris Shaker-Check’s Senior Thesis on mutation rates in Genetic Algorithms. 

<h4>What is a Genetic Algorithm:</h4>
Genetic Algorithms (GA) are a type of Evolutionary Algorithm (EA), which is a form of machine learning. It is inspired by the biological evolutionary process, specifically, the concept of survival of the fittest. Survival of the fittest is the concept that there are some individuals in a species that are more adapted to their environments than others. The better adapted an individual is the more likely it will be able survive long enough to reproduce and create offspring. The more offspring an individual produces the more its traits are represented in the population. Overtime, this leads to a population that is made up of individuals that are on average better adapted to their environment. 

For GAs each individual in the population is a solution. The population goes through the process of parent selection, crossover, and mutation to create a new generation of individuals. In this GA the tournament method is used for parent selection. In the tournament method a random subset of individuals is pulled from the population. Each individual in the subset has its fitness evaluated. The individual with the highest fitness is then selected. This process allows for solutions with a higher fitness to be selected, while maintaining genetic diversity among solutions. When the two parent individuals have been selected, crossover is performed. Crossover is achieved by splitting both collections of parent solutions in one or more places. These sections of the solutions are recombined to create a new individual(s). Mutations are the “random” changing of a gene. In a GA where the solution is encoded in 0’s and 1’s, a mutation would be switching a 1 to a 0 or vice versa. 

Over many generations, the goal is to find the optimal solution to a problem. The number of generations is set in the geneticAlgorithm class. GAs are most helpful for problems that require solutions that maximize or minimize a value. 

For more information on GAs and terminology see: <a href="https://www.tutorialspoint.com/genetic_algorithms/index.htm"> https://www.tutorialspoint.com/genetic_algorithms/index.htm </a>

<h4>The KnapSack Problem:</h4>
The Knapsack Problem is where there is a knapsack with a weight limit. There are also items that have a weight and a value. The weight of all the items exceeds the weight limit of the knapsack. The goal of the Knapsack Problem is to find the set of items that maximizes the value in the knapsack, but does not exceed the weight of the knapsack. 

This research specifically focuses on GA with the Knapsack Problem, since it is an optimization problem which Genetic Algorithms are particularly adept at solving. The Knapsack Problem is also an NP-Hard problem which makes it a difficult problem to solve efficiently. Therefore, making a Genetic Algorithm that can solve problems more accurately will give a better way of solving the Knapsack Problem and other NP-Hard problems efficiently. This research tests self-adapting mutation rates, gene specific self-adapting mutation rates, and static mutation rates.

<h4>Structure of the Genetic Algorithm:</h4>
(coming soon)

<h4>Fitness Functions: </h4>
(coming soon)

<h4>The Importance of Mutations: </h4>
(coming soon)

<h4>Types of mutation used: </h4>
<p>(coming soon)</p>

<h4>Current Results: </h4>
(coming soon)