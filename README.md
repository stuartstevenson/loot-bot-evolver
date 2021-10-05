loot-bot-evolver
================

This is my pet project to build a Genetic Algorithm (GA) to evolve heuristics for bots to play my fave game Loot! 

The game concept and the rules are not my IP. I just use this project as a platform for trying out different software technologies.

Development
---

Build and test

```shell
./gradlew clean build
```

To run locally

```shell
./gradlew bootRun
```

Design
---

### Evolver

The evolver will create a generation of players, run games between the player
and score them.

It will then use mutation and crossover to produce a new generation to replace the later
and repeat the process for the given number of generations.

### Game components

Player decisions are simplified to recognise a pattern of
 - the current hand
 - the state of the battles on the board
 - whether the deck if empty

If a match is found then it will be re-used. If no match is found then
a random valid move will be calculated and added to the list of available choices.