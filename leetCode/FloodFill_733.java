package leetcode;

import java.util.Arrays;

public class FloodFill_733 {
    public static void main(String[] args) {
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1,sc=1,color=2;
        floodFill(image,sr,sc,color);
        for(int[] i : image){
            System.out.println(Arrays.toString(i));
        }
    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int same=image[sr][sc];
        helper(image , sr, sc, color,same);
        return image;
    }


    private static void helper(int[][] image, int sr, int sc, int color, int same) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length ){
            return ;
        }

        if( image[sr][sc] !=same || image[sr][sc] == color)
            return;
        
             image[sr][sc] = color;
        
             helper(image,sr-1,sc,color,same);
             helper(image,sr,sc-1,color,same);
             helper(image,sr+1,sc,color,same);
             helper(image,sr,sc+1,color,same);
    }
}
