import java.util.*;

public class TicTacToe {
    static Vector <Byte> player1Positions = new Vector<>();
    static Vector <Byte> computerPositions = new Vector<>();

    public static void main(String[] args) {
        char[][] gameBoard = {
                {'1', '|', '2', '|', '3'},
                {'-', '-', '-', '-', '-'},
                {'4', '|', '5', '|', '6'},
                {'-', '-', '-', '-', '-'},
                {'7', '|', '8', '|', '9'}};

        printGameBoard(gameBoard);
        System.out.println();
        String result ;

        while(winner().equals("")) {
            System.out.println("Player 1's turn:");
            choosePosition(gameBoard, "player1");
            System.out.println();

            result = winner();
            if (!result.equals("")) {
                System.out.println(result);
                break;
            }

            System.out.println("Computer's turn:");
            choosePosition(gameBoard, "computer");
            System.out.println();

            result = winner();
            System.out.println(result);
        }
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

        Random computerPositionChoice = new Random();
        byte computerPosition = (byte) (computerPositionChoice.nextInt(9) + 1);

        byte position = 0;
        char piece = ' ';

        if (player.equals("player1")) {
            System.out.print("Please enter the position of your choice from 1-9:");
            Scanner player1PositionChoice = new Scanner(System.in);
            byte player1Position = player1PositionChoice.nextByte();

            while (player1Position < 1 || player1Position > 9 ){
                System.out.println("Position chosen is out of range. Please enter a correct one.");
                player1Position = player1PositionChoice.nextByte();
                //position = player1Position;
            }
             position = player1Position;

            while (player1Positions.contains(position)||computerPositions.contains(position)){
                System.out.println("Position chosen by player 1 is occupied, please choose another one.");
                player1Position = player1PositionChoice.nextByte();
                position = player1Position;

            }

            player1Positions.add(player1Position);
            piece = 'X';
        }
        else if (player.equals("computer")){
            position = computerPosition;

            while (player1Positions.contains(position)||computerPositions.contains(position)){
                System.out.println("Position chosen by computer is occupied, please choose another one.");
                computerPosition = (byte) (computerPositionChoice.nextInt(9) + 1);
                position = computerPosition;
            }
            computerPositions.add(position);
            piece = 'O';
        }

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

  public static String winner (){

      List<List<Byte>> conditions = new ArrayList<>();
      conditions.add(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
      conditions.add(Arrays.asList((byte) 4, (byte) 5, (byte) 6));
      conditions.add(Arrays.asList((byte) 7, (byte) 8, (byte) 9));
      conditions.add(Arrays.asList((byte) 1, (byte) 4, (byte) 7));
      conditions.add(Arrays.asList((byte) 2, (byte) 5, (byte) 8));
      conditions.add(Arrays.asList((byte) 3, (byte) 6, (byte) 9));
      conditions.add(Arrays.asList((byte) 1, (byte) 5, (byte) 9));
      conditions.add(Arrays.asList((byte) 3, (byte) 5, (byte) 7));

      for (List<Byte> l : conditions) {
          if (player1Positions.containsAll(l))
              return "Player 1 wins!";
          else if (computerPositions.containsAll(l))
              return "Computer wins :(";
      }
          if (player1Positions.size() + computerPositions.size() == 9)
             return "Tie";
   return "";
  }







}

