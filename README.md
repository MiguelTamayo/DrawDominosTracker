# DrawDominosTracker
Track domino tiles and view plausible tiles your opponents have

Status: proof of concept done

When playing draw dominos an essential skill to have is the ability to track the tiles in the game.
Knowing which tiles your opponent has and doesn't have helps when choosing the ones you'll play.

With this application you will be able to visually see which pieces your opponents plausibly have by easily adding which pieces have been played and which one you have.

## Assumptions of the application:
-Dominos used are a double-six set total of 28 tiles
-Each player gets only 7 tiles
-Players do not pass their turn if there are still tiles in the draw pile or if they have a tile that can be played
-no cheating(trading tiles, hiding tiles, duplicate tiles...etc)

## How to use:
Download repository and open the index.html file within the web files folder
at first you should be presented the prompt to select the number of players including yourself
after your choice you should see the the amount of opponents each with their own stack of dominoes

by clicking a domino in the opponent's section you remove it for only that individual. when you click a domino in the global dominoes section you remove that domino for all your opponents.

each opponent has a drop down menu with numbers 0-6 and a button with the prompt 'remove all'. you can remove all dominoes that have the selected value from the drop down menu for that opponent. this comes in handy when for example, an opponent skips you know the dont have any tiles with the values that are on either end of the gameboard.
