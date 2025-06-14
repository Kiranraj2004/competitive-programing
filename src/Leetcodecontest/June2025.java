package Leetcodecontest;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class June2025 {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int [][]ans=new int[m-k+1][n-k+1];
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                ans[i][j]=getmindiff(grid,i,j,k);
            }
        }
        return  ans;

    }

    private int getmindiff(int[][] grid, int row, int col, int k) {
        ArrayList<Integer>temp=new ArrayList<>();
        for(int i=row;i<row+k;i++) {
            for(int j = col; j <col+k ; j++) {
                if(!temp.contains(grid[i][j])){
                    temp.add(grid[i][j]);
                }
            }
        }
        if(temp.size()==1)return 0;
        Collections.sort(temp);
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<temp.size();i++){
            int diff=Math.abs(temp.get(i)- temp.get(i-1));
            ans=Math.min(ans,diff);
        }
        return ans;
    }


    public boolean checkEqualPartitions(int[] nums, long target) {
        long product=1;
        for(int i:nums){
            product*=i;
        }
        if(target*target==product){
            return subsequence(nums,0,1,target);
        }
        return false;
    }

    private boolean subsequence(int[] nums,int index, long sum, long target) {
        if(sum==target){
            return true;
        }
        if(index>=nums.length){
            return false;
        }
        if(sum*nums[index]<=target){
            if(subsequence(nums,index+1,sum*nums[index],target)){
                return true;
            }
        }
        if(subsequence(nums,index+1,sum,target)){
            return true;
        }
        return false;
    }
}
