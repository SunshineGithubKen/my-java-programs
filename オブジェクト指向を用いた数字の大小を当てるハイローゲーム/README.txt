プログラム説明：
このプログラムは、Javaを使って作成されたBig or Smallゲームです。
ゲームの目的は、1から9までのランダムな数字を使用して、現在の数字が次の数字よりも大きいか小さいかを予想することです。
ゲームが開始されると、最初の数字が表示され、プレイヤーは「Big」か「Small」のいずれかを選択する必要があります。
次に、新しいランダムな数字が表示され、実際の答えと一致するかどうかが確認されます。
正解すると、スコアが増加し、10回プレイするか、スコアが0になるまで続けることができます。
また、プレイ中にログファイルが生成され、プレイ結果が記録されます。

Program  Outline:
The provided code is a simple command-line game called "Big or Small". 
The game generates a random number between 1 and 9, and the player has 
to guess whether the next randomly generated number will be bigger or smaller than the previous one. 
The player gets points for correct guesses and loses points for incorrect guesses, 
and the game ends after a certain number of rounds.

The code consists of several Java classes, including a RandomNumberGenerator class 
that generates random numbers, a Player class that handles player input, 
and a BigOrSmall class that runs the game logic. 
There is also a custom NumberOutOfRange_Exception class for handling exceptions related to player input.

The game starts by displaying the current number and asking the player 
to guess whether the next number will be bigger or smaller. 
If the player's guess is correct, they earn points and move on to the next round. 
If their guess is incorrect, they lose points and move on to the next round. 
After a certain number of rounds, the game ends and the player's final score is displayed. 
The game also records the player's score and the date and time of the game in a log file.


