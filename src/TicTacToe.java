import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] gameBoard = {
                {'1', '|', '2', '|', '3'},
                {'-', '-', '-', '-', '-'},
                {'4', '|', '5', '|', '6'},
                {'-', '-', '-', '-', '-'},
                {'7', '|', '8', '|', '9'}};
        printGameBoard(gameBoard);
        choosePosition(gameBoard, "computer");

    }

    public static void printGameBoard(char[][] board) {

        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void choosePosition(char[][] board, String player) {
        System.out.print("Please enter the position of your choice from 1-9:");
        Scanner positionChoice = new Scanner(System.in);
        int position = positionChoice.nextInt();

        char piece = ' ';

        if (player.equals("player1"))
            piece = 'X';
        if (player.equals("computer"))
            piece = 'O';

        if (position == 1)
            board[0][0] = piece;
        else if (position == 2)
            board[0][2] = piece;
        else if (position == 3)
            board[0][4] = piece;
        else if (position == 4)
            board[2][0] = piece;
        else if (position == 5)
            board[2][2] = piece;
        else if (position == 6)
            board[2][4] = piece;
        else if (position == 7)
            board[4][0] = piece;
        else if (position == 8)
            board[4][2] = piece;
        else if (position == 9)
            board[4][4] = piece;

        printGameBoard(board);

    }









}

