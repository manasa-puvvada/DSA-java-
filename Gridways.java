public class Gridways {
    public static void ratMaze(int maze[][],int res[][], int row, int col,int n, int m) {
        //basecase 
        if(row == n-1 && col == m-1) {
            return;
        } 
        //recursion
        res[row][col] = 1;
        if(row <n-1 && col < m-1) {
            
            if(maze[row + 1][col] == 1) {
                res[row+1][col] = 1;
                ratMaze(maze,res,row+1,col,n,m);
            }
            if(maze[row][col+1] == 1){
                res[row][col+1] = 1;
                ratMaze(maze,res,row,col+1,n,m);
            }
        } 
        if(row == n-1 ) {
            if(maze[row][col+1] == 1){
                res[row][col+1] = 1;
                ratMaze(maze,res,row,col+1,n,m);
            }

        }
    }
    public static void printRes(int res[][],int n,int m) {
        for(int i =0 ;i<n;i++) {
            for(int j = 0;j<m;j++) {
                System.out.print(res[i][j] + " ");
            }
        System.out.println();
        }
    }
    public static void main(String args[]) {
        int n = 4;
        int m = 4;
        int maze[][] ={ { 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 }};
        int res[][] =new int[n][m];
        ratMaze(maze,res,0,0,n,m);
        printRes(res,n,m);
    }
}