# ECSE-250-Software-Development
This repository contains the assignments for ECSE 250 - Fundamentals of Software Development at McGill University.
The assignments are organized into three folders: A1, A2, and A3 and are intended to be run independently in IntelliJ IDEA.

## Assignment 1 - Travel Agency
The goal of this project is to create a simplified model of a travel agency system, focusing on key functionalities.
The project contains the following classes: Airport, Room, Hotel, Reservation, FlightReservation, HotelReservation, BnBReservation, Basket, and Customer.

## Assignment 2 - Caterpillar Game
This assignment is divided into 3 sections, encompassing the development of a Caterpillar Game.
### Part I - Data Structures
Several data structure are implemented and those are: Lists, Linked Lists, Doubly Linked Lists, Queues, and Stacks.
### Part II - Information Parsing with Stacks
In this part, strings are decoded and parsed into a structures that would be supported by the game in Part III.
The strings are parsed to produce the following data: Position, Target Queue, Direction, and Action Queue.
### Part III - Caterpillar Game
The caterpillar game is implemented through the following classes
#### Region
- Represents a 2D world.
#### Caterpillar
- Extends `MyDoublyLinkedList<Position>`.
- Represents caterpillar's body.
#### World
- Defines the full implementation of the game with fields: caterpillar, food position, region, action/target queues, game state.
#### Graphical Interface
- Graphical interface for visualizing the movement of the caterpillar through `CaterpillarGame.java` and `CaterpillarDrawer.java`.

## Assignment 3 - Recursive Blob Game
This assignment involves implementing a visual game where players manipulate a recursive structure using operations like rotations. The primary data structure is a quad-tree, and players aim to achieve specific goals on a game board resembling a Mondrian painting.

### The Game
- Randomly generated game board with colored squares.
- Players assigned goals: create the largest connected blob of a color or place as much of a color on the outer perimeter.
- Three types of moves: rotate a block (clockwise/counterclockwise), reflect a block horizontally/vertically, and "smash" a block (subdivide into four random sub-blocks).
- Score determined by goal achievement after each move.
- Highest score at the end wins.

### The Game Board
- Game board is a "block," recursively defined.
- Block can be a square of one color or subdivided into 4 equal-sized blocks.
- Top-level block at level 0; sub-blocks at level 1, and so on.
- Maximum allowed depth determines the board's complexity.
- Scoring based on unit cells at maximum depth.

### Moves
- Players can apply moves to any block at any level.
- Smashing the top-level block or a unit cell is not allowed.
- Moves include rotation, reflection, and smashing.

### Goals and Scoring
- Players assigned random goals:
  - Blob goal: Create the largest orthogonally connected blob of a given color. Score based on unit cells.
  - Perimeter goal: Place the most units of a color on the outer perimeter. Corner cells count twice. Score based on perimeter unit cells.
