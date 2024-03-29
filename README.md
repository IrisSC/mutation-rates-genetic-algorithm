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
The GA for this research project was written in Java and took advantage of Object Oriented Programming. 

Each knapsack problem inherits from the abstract knapsack class. The abstract knapsack class contains all the setter, getters, and the fitness function for the knapsack problems. Thus to create a new knapsack problem all that is needed are the cap, weights, and values of the knapsack.

For the individual classes there is also an abstract class. This abstract individual class has constructors that can create and set a solution. It also has abstract methods for mutation, crossover, equals, copy, and getMutationRate. Having these abstract methods allows for all individuals who inherit from the abstract individual class to be used interchangeably in other classes. 

The population object is initialized with a knapsack object and an array list of individuals. The population object allows the GA to analyze the population as a whole with methods such as getParent, maxFitness, averageFitness, etc. 

The GA is run in the geneticAlgorithms class. The geneticAlgorithms class is where the type of mutation rate, number of individuals, knapsack problem, tournament size, number of generations, and number of times the algorithm is run is set. This is also the class that prints the data to an excel spreadsheet.

<h4>Fitness Functions: </h4>
When using a GA to solve an optimization problem there is a function that determines how well adapted or optimal an individual is. This function is called the fitness function. The fitness function takes an individual and outputs a fitness value for that individual. The fitness function should represent the objective of the problem that is being solved. The fitness function for the Knapsack Problem that was developed for this research is below:

<img src="./FitnessFunctionEquation1.png" alt="Equation 1"/>

The n is the number of items and the C is the cap weight of the knapsack.  The v is a List of values for all the items. The w is a List of weights for all the items.The g represents whether an item is placed in the knapsack and will either be a 1 or a 0. The fitness of each individual will be the sum of the values of the items in the knapsack, unless the weight exceeds the cap. If the weight exceeds the cap weight then the fitness is zero. 

While this fitness function works, it does disincentivize any individual from being over the cap. Decreasing these individuals' chances for reproduction is valuable since the GA needs to produce a valid optimal solution. However, it is also beneficial to keep the genetic diversity that these individuals have. The fitness function also treats every individual that goes over the cap weight the same, not taking into account that some individuals will go over the cap more than others. 

There are two different ways of changing the fitness function that have been used for the individuals that go over the cap weight. These are the repair operation and penalization method. The repair operation is when items are removed from the knapsack at random until the weight of the items in the knapsack is below the cap. With this method the genetic diversity of the population could still be lost. For the penalization method, if an individual’s weight exceeds the cap then the value of the individual is penalized. It is crucial that an individual is penalized enough that the fitness of the individual is less than the optimal solution. The penalization method was used in this research since it allows for the GA to retain the genetic diversity and for individuals that exceed the cap to be penalized differently based on how much they go over. 

A new fitness function was developed that used the penalization method. It is shown below in equation 2 and equation 3:

<img src="./FitnessFunctionEquation2&3.png" alt="Equation 2 and 3"/>

The new fitness function returns the sum of the values of all the items in the knapsack minus a penalty. If the weights of all the items in the knapsack are below or equal to the cap then the penalty is zero. Otherwise the penalty is ten times the amount the weight goes over the cap.

The new fitness function and the old fitness function were then tested on three different knapsack problems. One knapsack had 50 items (KS3), another had 80 items (KS4), and the last knapsack problem had 100 items (KS5). Each of these knapsack problems were run 100 times with both fitness functions. Each run had 100 generations and 100 individuals in the population. The average maximum fitness, average average fitness, and average minimum fitness was taken at every generation. 

The average maximum is slightly higher in the new fitness function represented by Equations 2 & 3 than the original fitness function represented by equation 1, however this increase was not significant. There were significant increases in the average average fitness and the average minimum fitness. This increase was likely due to the decrease in fitness values being zero. 

Both fitness functions are available in the abstract knapsack class to experiment with.


<h4>The Importance of Mutations: </h4>
Mutations allow for variations in the genetic makeup of individuals to be added to the population. For example, let's say that there is a knapsack problem where the optimal solution requires the first item to be placed in the knapsack. However, none of the current solutions in the population have the first item placed into the knapsack. With just parent selection and crossover there would be no way of finding the optimal solution, but since mutations “randomly” change the alleles of genes a solution could be mutated to place the first item in the kanspack. Often these mutations do not have a significant effect on an individual's fitness, but sometimes the mutations can create individuals who are better or worse adapted for their environment. 
<br><br>
The larger a mutation rate is, the more “genetic diversity” could be added to the population, which would increase chances of exploring more parts of the solution space. The solution space represents all possible solutions for which the population is a subset. For example, a three dimensional solution space would resemble a landscape where there are high points and low points (mountains and valleys). Depending on the optimization problem the algorithm would try to find either the global maximum or minimum in that landscape. This concept applies no matter how many dimensions the solution space exists in. The solution space for GAs is n-dimensional where n is the number of genes. 

It is unknown where in the solution space the optimal solution is located. For this reason it is important for the population to “explore” the solution space, which mutations allow for. However, having a mutation rate which is too high can decrease the chances of finding the optimal solution. For example, if a solution is close to the optimal solution it would be more advantageous for that solution's offspring to be in the solution space around the solution instead of “exploring” other regions of the solution space. In general it is considered better to “explore” more of the solution space early on in the algorithm and exploit or explore less as the algorithm continues. Thus it is important to have the correct or “goldilocks” mutation rate.

<h4>Types of Mutation Used: </h4>
In the most basic GAs mutations are represented as a static rate. However, past research has developed other types of mutation rates such as self-adaptive mutation rates. This research focuses on static mutation rates, self-adapting mutation rates, and global gene specific mutation rates.
<br> <br>
<ins>Static Mutation Rates:</ins><br>
A static mutation rate is set by the developer. This rate is represented by a percentage. Then for each gene a random number is generated. This random number is typically between 0 and 1, but can change based on the algorithm. If the randomly generated number is below the percentage then that gene is mutated. If the number is above the percentage then the gene is not mutated. For example, if the mutation rate was 0.02 then on average two percent of all genes would get mutated.
<br><br>
<ins>Self-Adaptive Mutation Rates:</ins><br>
Self-adapting mutation rates are similar to static mutation rates in that the rate is a percentage. Where self-adapting mutation rates differ is that self-adapting mutation rates are represented as a gene in the individuals. Representing the mutation rate as a gene allows for the mutation rate to evolve along with the other genes that an individual has. Having a self-adaptive mutation rate allows for the population to explore the solution space only when needed. Self-adapting mutations have been shown to outperform static mutation rates. 
<br><br>
<ins>Global Gene Specific Self-Adapting Mutation Rates:</ins><br>
Past research on mutation rates has focused on having a singular mutation rate that mutates all genes. In this research, a mutation rate for each gene was introduced. Since GAs perform better with different mutation rates at different parts of the problem solving process, it is possible that GAs will perform better with individual mutation rates for each gene. During the process of solving a problem there may be specific genes that are more beneficial to mutate than others. This follows what we know of genetics, some genes in organisms are more predisposed to mutation then others. The mutation rates for each gene were placed in a global list. After an individual is mutated, the fitness of the new individual will be checked. If that fitness is higher than the fitness of the individual before having been mutated then the mutation rates for the genes mutated will be increased. However if the mutation does not increase the fitness of the individual, then that mutation rate will be decreased. This goes beyond what happens in genetics. In nature, it is not possible to see if a mutation was beneficial to the organism until it has a chance to reproduce. However, in GAs there is the ability to check if a mutation was beneficial for the individual.

<h4>Current Results: </h4>
Both the static mutation rate and self-adaptive mutation rates were run on the same knapsack problems. Self-adaptive mutation rate significantly outperformed the static mutation rate, which follows past research on GAs. However, the self-adaptive mutation rate only outperformed the static mutation rate when the self-adaptive mutation rate had a floor of 1/n where n is the number of genes. Originally the floor for the self-adaptive mutation rate had been zero, since a negative mutation rate does not make sense. When the floor for the self-adaptive mutation rate was zero the best performing static mutation outperformed the self-adaptive mutation rate. Past research showed a floor of 1/n for the self-adaptive mutation rate so that was implemented. However, for the static mutation rate the best performing mutation rate was also 1/n. This creates many questions, such as: Is the self-adaptive mutation rate more effective than the static mutation rate if it needs to be floored at the best performing static mutation rate? The self-adaptive mutation rate still outperformed the static mutation rate, but why? How important is the floor for the self-adaptive mutation rates and is there an ideal floor? 

The global gene specific self-adaptive mutation rate underperformed both the static and the self-adaptive mutation rates. It is hypothesized that this underperformance is caused by the mutation rates remaining too high in the global gene specific self-adaptive mutation rates. The reason for the mutation rates remaining significantly higher than the self-adaptive mutation rates is unknown. It is suggested that in future research creating a shared or global mutation rate and a gene specific mutation rate should be separated into different individual classes to have a deeper look into the effects of each.
