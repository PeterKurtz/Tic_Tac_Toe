import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String getPlayerNum(String[] refNumbers) {
        boolean isNum = false;
        System.out.println("Choose a number");
        String playerNum = " ";
        Scanner myObj;

        while (!isNum) {
            myObj = new Scanner(System.in);
            playerNum = myObj.nextLine();
            if (Arrays.asList(refNumbers).contains(playerNum)){
                isNum = true;
            }
            else {
                System.out.println("Choose a number between 0 and 9.");
            }
        }

        return playerNum;
    }

    static String[] playerTurn(String playerPiece, String[] boardChars, String[] refNumbers) {

        boolean empty = false;
        String playerNum;
        int intPlayerNum;

        while (!empty) {
            playerNum = getPlayerNum(refNumbers);
            intPlayerNum = Integer.parseInt(playerNum) - 1;

            if (boardChars[intPlayerNum] != " ") {
                System.out.println("Choose an empty value:");
            }
            else {
                empty = true;
                Array.set(boardChars, intPlayerNum, playerPiece);
            }
        }

        return boardChars;
    }

    static boolean checkWinner(String[] boardChars, String PlayerPiece) {
        boolean winner = false;

        if (boardChars[0] == PlayerPiece && boardChars[1] == PlayerPiece && boardChars[2] == PlayerPiece) {
            winner = true;
        }
        if (boardChars[3] == PlayerPiece && boardChars[4] == PlayerPiece && boardChars[5] == PlayerPiece) {
            winner = true;
        }
        if (boardChars[6] == PlayerPiece && boardChars[7] == PlayerPiece && boardChars[8] == PlayerPiece) {
            winner = true;
        }
        if (boardChars[0] == PlayerPiece && boardChars[3] == PlayerPiece && boardChars[6] == PlayerPiece) {
            winner = true;
        }
        if (boardChars[1] == PlayerPiece && boardChars[4] == PlayerPiece && boardChars[7] == PlayerPiece) {
            winner = true;
        }
        if (boardChars[2] == PlayerPiece && boardChars[5] == PlayerPiece && boardChars[8] == PlayerPiece) {
            winner = true;
        }
        if (boardChars[0] == PlayerPiece && boardChars[4] == PlayerPiece && boardChars[8] == PlayerPiece) {
            winner = true;
        }
        if (boardChars[2] == PlayerPiece && boardChars[4] == PlayerPiece && boardChars[6] == PlayerPiece) {
            winner = true;
        }

        return winner;

    }

    static void printBoard(String[] boardChars) {
        System.out.println(boardChars[0] + " | " + boardChars[1] + " | " + boardChars[2]);
        System.out.println("---------");
        System.out.println(boardChars[3] + " | " + boardChars[4] + " | " + boardChars[5]);
        System.out.println("---------");
        System.out.println(boardChars[6] + " | " + boardChars[7] + " | " + boardChars[8]);
    }

    public static void main(String[] args) {
        String[] boardChars = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        String[] refNumbers= {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        boolean winner = false;
        String winnerPiece = "Nobody";
        String playerX = "X";
        String playerO = "O";

        System.out.println("This is a Tick-Tack-Toe Game Program. Pick a location using the following numbers:");
        printBoard(refNumbers);

        while (!winner) {

            boardChars = playerTurn(playerX, boardChars, refNumbers);
            printBoard(boardChars);
            winner = checkWinner(boardChars, playerX);

            if (winner) {
                System.out.println("Player X wins.");
                break;
            }

            if (!Arrays.asList(boardChars).contains(" ")) {
                System.out.println("There was a tie.");
                break;
            }

            boardChars = playerTurn(playerO, boardChars, refNumbers);
            printBoard(boardChars);
            winner = checkWinner(boardChars, playerO);

            if (winner) {
                System.out.println("Player Y wins.");
            }

            if (!Arrays.asList(boardChars).contains(" ")) {
                System.out.println("There was a tie.");
                break;
            }

        }
    }
}
