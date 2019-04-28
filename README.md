# [Monopoly](https://github.com/Hex052/csce_222-final)

The final project for my Object Oriented programming class.

## Reasons for coding it this way

I designed the program this way by starting with getting a board working without a GUI, just the linked list of 40 squares, and what would happen if you landed on it.
From there, I decided I needed a player, and added one, along with the actions that would happen when you landed on a square.
Only at that point did I actually start a GUI, which I tried to keep separate from the rest of the board, and linked the players/squares and their GUI components together with variables referencing each other.
In theory, you could split the interface from the logic, as there's really only everything in `gui.actions`, which drives a fair amount of the game, that would be needed to have the game be playable.
The GUI's were easily the most tedious part of this, as I do not enjoy creating them, nor do I have the best idea of how they work.
I was happy that I got the icons and names to be changeable to whatever you wanted (with the icons, they just have to be 150*150 px, and put in `img/piece`).

For the most part, things inherit each other to change their functions, with the notable exception of `cards.CardDeck`, which isn't split into several classes.
This is because it would be far more complicated to have `cards.ChanceDeck` and `cards.ChestDeck` extending that versus just having two separate static methods for drawing each card type.
Not to say that it couldn't be done, just that I thought there wasn't much point, given the decks would have to be static no matter how I implemented them.

Almost all of the things I wrote were changed several times over, as I realized features needed to be added or that something didn't work as I intended.
My workflow was basically to start with a set of TOODs (both in the README and in comments), and then remove them when I finished with a task, or add more if there was more work to be done, but would have to be come back to.
I didn't start with a concrete plan of how I wanted to get things done, as evidenced by the fact that my code is slightly all over the place. Also, most of the variables are not private/protected even though they should be, or final even when they never change.

## TODO UML Diagram
