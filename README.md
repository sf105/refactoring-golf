# Refactoring Golf

_Refactoring Golf_ is a game designed to stretch your refactoring muscles and 
tp get you to explore your IDE to see what's really possible using 
shortcuts and automation.

This repository contains multiple versions of a simple class to calculate tax on a payslip.
* The first £5,000 is tax free
* Up to £20,000 is taxed at 10%
* Up to £40,000 is taxed at 20%
* Above £40,000 is taxed at 40%

Each version is a refactoring of the previous version. Sticking with the golf metaphor, 
each version is called a "hole". 

Your goal is to refactor from each _hole_ to the next safely and efficiently,
using the features of the IDE with as few "strokes" as possible, where a _stroke_ is 
an action that changes the code. Every stroke costs you points.

Your pairing partner should carefully score you as follows:

- 0 points for formatting and selection
- 1 point for every change made to the code using a shortcut or automated IDE feature 
  (e.g., an automated refactoring, code template, rename, or Find/Replace)
- 2 points for every manual edit. Note that a single "edit" could cover multiple lines of code.
- There is a double points penalty for changes that leave the code failing the tests or not compiling.

Allow yourselves a maximum of 2 attempts at each round to determine your best score.

## Hints: 

1. Each version has a `notes.md` file that describes the motivation for the next refactoring.
1. You might want to keep the target code open in another window, or perhaps on the partner's machine. 
It's easy to get confused about which file is which.
1. Commit your code frequently, especially after each refactoring stage. That will make rolling-back easier 
if you want to make another attempt or if you get confused.
1. Run the tests after each "stroke". You can do this by selecting the top-level *refactoring-golf* in 
the project view and selecting `Run 'All Tests'` from the pop-up menu. 

## Course records:
These are some example scores, achieved using IntelliJ:

| Hole | Best score | Notes 
|------|------------|-------
| 1    | 6          |       
| 2    | 3          |       
| 3    | 9          |       
| 4    | 17         | lots of manual edits 
| 5    | xx         |       
| 6    | 14         |       
| 7    | xx         |       
| 8    | xx         |       

## Acknowledgements:
This exercise was mainly taken from an example by Lance Walton.

Other ideas were taken from David Denton and Ivan Sanchez, inspired by @ivanmoore and @rchatley

These instructions were mostly stolen from @jasongorman's 
<a href="https://github.com/jasongorman/RefactoringGolfJava">Refactoring Golf</a>.

## Notes

- we're using `double` for the calculations. Using floating point types is usually a bad idea for money, 
but here it's to simplify the exercises.  
