package recursion;


public class MazePath {
    public static void main(String[] args) {
        // int count = pathCount(3, 3);
        // System.out.println(count);
        // pathPrint("", 3, 3);
        // pathDiagonalPrint("", 3, 3);

        boolean[][] maze={
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
        pathRestriction("",maze, 0, 0);
    }


    static int pathCount(int r, int c){
        if(r == 1 || c ==1){
            return 1;
        }

        int left = pathCount(r-1, c);
        int right = pathCount(r, c-1);
        return left + right ;
    }

    static void pathPrint(String path, int r, int c){
        if(r == 1 && c ==1){
            System.out.println(path);
            return;
        }

        if(r>1)
          pathPrint(path+"D",r-1, c);
        if(c>1)
          pathPrint(path+"R",r, c-1);
        
    }

    static void pathDiagonalPrint(String path, int r, int c){
        if(r == 1 && c ==1){
            System.out.println(path);
            return;
        }
        if(r>1 && c>1)
        pathDiagonalPrint(path+"D",r-1, c-1);
        if(r>1)
        pathDiagonalPrint(path+"V",r-1, c);
        if(c>1)
        pathDiagonalPrint(path+"H",r, c-1);
    }

    private static void pathRestriction(String path, boolean[][] maze, int r, int c) {
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(path);
            return;
        }
       
        if(!maze[r][c]){
            return;
        }

        if(r  < maze.length-1)
        pathRestriction(path+"D", maze, r+1, c);
        if(c < maze[0].length-1)
        pathRestriction(path+"R", maze, r, c+1);
    }
}
