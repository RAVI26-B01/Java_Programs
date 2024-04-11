package recursion;

import java.util.Arrays;

public class MazeAllPath {
    public static void main(String[] args) {
        boolean[][] maze={
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        // allPath("",maze, 0, 0);
        int[][] pathArr = new int[maze.length][maze[0].length];
        int count =0;
        printPathTraverse("",maze, 0, 0, pathArr, count);
        
    }

    @SuppressWarnings("unused")
    private static void allPath(String path, boolean[][] maze, int r, int c) {
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(path);
            return;
        }
       
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        if(r  < maze.length-1)
           allPath(path+"D", maze, r+1, c);
        if(c < maze[0].length-1)
            allPath(path+"R", maze, r, c+1);
        if(r > 0)
          allPath(path+"U", maze, r-1 , c);
        if(c > 0)
             allPath(path+"L", maze, r , c-1);
             maze[r][c]=true;
    }


    private static void printPathTraverse(String path, boolean[][] maze, int r, int c, int[][] pathArr, int count) {
       
        if(r == maze.length-1 && c == maze[0].length-1){  
            pathArr[r][c]=count;
            for(int[] ar:pathArr)
            System.out.println(Arrays.toString(ar));
            
            System.out.println(path);
            System.out.println();
            return;
        }
       
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        pathArr[r][c]=count;
        if(r  < maze.length-1){
            printPathTraverse(path+"D", maze, r+1, c, pathArr, count+1);
        }  
        if(c < maze[0].length-1){
            printPathTraverse(path+"R", maze, r, c+1, pathArr, count+1);
        }
        if(r > 0)  {
            printPathTraverse(path+"U", maze, r-1 , c, pathArr, count+1);
        }
        if(c > 0){
            printPathTraverse(path+"L", maze, r , c-1, pathArr, count+1);
        }
        pathArr[r][c] = 0;
        maze[r][c]=true;
    }
}
