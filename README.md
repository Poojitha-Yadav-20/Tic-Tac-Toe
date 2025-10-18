# Tic-Tac-Toe 
Overview :
A simple console-based Tic Tac Toe game built in Java. It allows two players to take turns marking positions on a 3x3 grid, checks for valid moves, detects winners or draws, and replaying with new player names.

Features : 
Turn-based 2-player gameplay.
Input validation ensures fair play.
Detects wins across rows, columns, and diagonals.
Declares draws automatically.
Allows replaying new matches.

Approach :
The game uses a main board and two separate matrices (pathX and pathO) to track each player’s moves.
When a player marks a cell, it is recorded in both the main board and the player’s matrix.
After each move, the program checks all rows, columns, and diagonals in the player’s matrix. If any line is fully marked, that player wins.
Invalid moves (out-of-bound or already occupied cells) are rejected, and the player is prompted to enter a new move.
The game continues until someone wins or all cells are filled (draw).
After a match, players can play again with new names or exit.
