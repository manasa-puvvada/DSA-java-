import java.util.*;

public class ClassRoom {//back tracking 
    public static boolean isSafe(char board[][],int row ,int col){
        //to check vertical top
        for (int i=row-1; i>=0; i--) {
            if((board[i][col]) == 'Q') {
                return false;
            }
        }
        //to check up left diagonal
        for (int i= row-1, j=col-1;i>=0 && j>=0;i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        //to check up right diagonal
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]) {
        System.out.println("---------  chessBoard -------");
        for (int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int count = 0;
    public static void nQueens(char board[][],int row) {
        //base case
        if(row == board.length) {
            //printBoard(board);
            count++;
            return;
        }
        //column
        
        for(int j=0; j<board.length; j++) {
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueens(board,row+1);
                board[row][j] = 'X';
            }

        }
    }
    public static void main(String args[]) {
        int n = 5 ;
        char board [][] = new char [n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = 'X';
            }
        }
        nQueens(board,0);
        //to print total number of ways
        System.out.println("total no of ways" +" "+ count );
    }
}