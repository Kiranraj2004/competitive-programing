package Leetcodecontest.biweekly_constest_143;

import java.util.*;

public class Count_Path_With_the_Given_XOR_Value {
    public static void main(String[] args) {

    }

    int mod=(int)Math.pow(10,9)+7;
    public int countPathsWithXorValue(int[][] grid, int k) {
        HashMap<Integer, Integer>[][] dp = new HashMap[grid.length][grid[0].length];

        // Fill each cell of the DP matrix with an empty HashMap
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = new HashMap<>();
            }
        }
        return helper(grid,k,0,0,0,dp);
    }
    public int helper(int[][] grid, int k ,int row,int col,int xor, HashMap<Integer, Integer>[][] dp) {
        if(row>=grid.length||col>=grid[0].length){
            return 0;
        }
        if(row==grid.length-1&&col==grid[0].length-1){
            if((xor^grid[row][col])==k)return 1;
            return 0;
        }
        if(dp[row][col].containsKey(xor)){
            return dp[row][col].get(xor);
        }

        //  move row
        int count=0;
        count = (count + helper(grid, k, row + 1, col, xor ^ grid[row][col], dp)) % mod;
        count = (count + helper(grid, k, row, col + 1, xor ^ grid[row][col], dp)) % mod;

        dp[row][col].put(xor,count);
        return count;
    }

//    tc O(m*n)
//    sc O(m*n) hashmap
}
