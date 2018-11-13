# Refactoring Golf

Refactoring Golf is a game designed to stretch your refactoring muscles and 
tp get you to explore your IDE to see what's really possible using 
shortcuts and automation.

This repository contains multiple versions of a simple class to calculate tax on a payslip.
Each version is a refactoring of the previous version.

Your goal is to refactor from each version to the next safely and efficiently,
using the features of the IDE with as few "strokes" as possible, where a stroke is a 
change to the code. Every stroke costs you points.

Your pairing partner should carefully score you as follows:

- 0 points for formatting and selection
- 1 point for every change made to the code using a shortcut or automated IDE feature 
  (e.g., an automated refactoring, code template, rename, or Find/Replace)
- 2 points for every manual edit. Note that a single "edit" could cover multiple lines of code.
- There is a double points penalty for changes that leave the code failing the tests or not compiling.

Allow yourselves a maximum of 2 attempts at each round to determine your best score.

## Hints: 

1. You might want to keep the target code open in another window, or perhaps on the partner's machine. 
It's easy to get confused about which file is which.
1. Commit your code frequently, especially after each refactoring stage. That will make rolling-back easier 
if you want to make another attempt or if you get confused.
1. Run the tests after each "stroke". You can do this by selecting the top-level *refactoring-golf* in 
the project view and selecting `Run 'All Tests'` from the pop-up menu. 

## Course records:
These are the best known scores, achieved using IntelliJ:

| Hole | Best score | Notes |
|------|------------|-------|
| 1    | 3          |       |
| 2    | 7          |       |
| 3    | 5          |       |
| 4    | 6          |       |
| 5    | 10         |       |
| 6    | 7          |       |
 

## Acknowledgements:
This exercise was mainly taken from an example by Lance Walton
Other ideas were taken from David Denton and Ivan Sanchez, inspired by @ivanmoore and @rchatley
These instructions were mostly stolen from @jasongorman's 
<a href="https://github.com/jasongorman/RefactoringGolfJava">Refactoring Golf</a>.

## Notes

- we're using `double` for the calculations. Using floating point types is usually a bad idea for money, 
but here it's to simplify the exercises.  
