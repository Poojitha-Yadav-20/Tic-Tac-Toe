import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Enter name of Player X:");
            String playerX = sc.nextLine();
            System.out.println("Enter name of Player O:");
            String playerO = sc.nextLine();

            int[][] board = new int[3][3];
            int[][] pathX = new int[3][3];
            int[][] pathO = new int[3][3];
            int moves = 0;
            int player = 1;

            while (true) {
                printBoard(board);
                System.out.println((player == 1 ? playerX : playerO) + " enter row and column (0-2):");
                int r = sc.nextInt();
                int c = sc.nextInt();

                if (r < 0 || r > 2 || c < 0 || c > 2 || board[r][c] != 0) {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }

                board[r][c] = player;
                if (player == 1) pathX[r][c] = 1;
                else pathO[r][c] = 1;
                moves++;

                if ((player == 1 && checkPath(pathX)) || (player == 2 && checkPath(pathO))) {
                    printBoard(board);
                    System.out.println((player == 1 ? playerX : playerO) + " wins!");
                    break;
                } else if (moves == 9) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }

                player = (player == 1) ? 2 : 1;
            }

            sc.nextLine(); // consume leftover newline
            System.out.println("Do you want to play again? (yes/no):");
            String answer = sc.nextLine().trim().toLowerCase();
            if (!answer.equals("yes")) {
                keepPlaying = false;
                System.out.println("Thanks for playing!");
            }
        }

        sc.close();
    }

    static void printBoard(int[][] b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch = (b[i][j] == 1) ? 'X' : (b[i][j] == 2) ? 'O' : ' ';
                System.out.print(" " + ch + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    }

    static boolean checkPath(int[][] path) {
        for (int i = 0; i < 3; i++)
            if (path[i][0] == 1 && path[i][1] == 1 && path[i][2] == 1)
                return true;
        for (int j = 0; j < 3; j++)
            if (path[0][j] == 1 && path[1][j] == 1 && path[2][j] == 1)
                return true;
        if (path[0][0] == 1 && path[1][1] == 1 && path[2][2] == 1) return true;
        if (path[0][2] == 1 && path[1][1] == 1 && path[2][0] == 1) return true;
        return false;
    }
}
