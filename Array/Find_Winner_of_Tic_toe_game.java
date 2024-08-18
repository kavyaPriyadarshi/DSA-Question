/*
1275.
Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

 

Example 1:


Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.
*/

class Solution {
    public String tictactoe(int[][] moves) {
        char symbol = '9';
        char symbol1 = 'X';

        boolean temp = true;
        char[][] tic_tac_toe = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            tic_tac_toe[moves[i][0]][moves[i][1]] = symbol1;

            if (symbol1 == 'X') {
                symbol1 = '0';
            } else {
                symbol1 = 'X';
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tic_tac_toe[i][1] == tic_tac_toe[i][0] && tic_tac_toe[i][1] == tic_tac_toe[i][2]) {
                symbol = tic_tac_toe[i][1];
                temp = false;
                break;
            }

        }
        if (temp != false) {
            for (int i = 0; i < 3; i++) {
                if (tic_tac_toe[1][i] == tic_tac_toe[0][i] && tic_tac_toe[1][i] == tic_tac_toe[2][i]) {
                    symbol = tic_tac_toe[1][i];
                    temp = false;
                    break;
                }

            }
        }
        if (temp != false) {
            if ((tic_tac_toe[1][1] == tic_tac_toe[0][0] && tic_tac_toe[1][1] == tic_tac_toe[2][2])
                    || (tic_tac_toe[1][1] == tic_tac_toe[0][2] && tic_tac_toe[1][1] == tic_tac_toe[2][0])) {
                symbol = tic_tac_toe[1][1];
                temp = false;
            }

        }

        if (symbol == 'X') {
            return "A";
        } else if (symbol == '0') {
            return "B";
        }

        if (moves.length < 9) {
            return "Pending";
        } else {
            return "Draw";
        }

    }
}
