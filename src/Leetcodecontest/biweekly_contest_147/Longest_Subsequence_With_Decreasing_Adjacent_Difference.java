package Leetcodecontest.biweekly_contest_147;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Longest_Subsequence_With_Decreasing_Adjacent_Difference {
    public static void main(String[] args) {
        int []arr={6,5,3,4,2,1};
        System.out.println(longestSubsequence(arr));

    }
    public static int longestSubsequence(int[] nums) {
        int max=0;
        int maxnumber=0;
        for(int i:nums){
            maxnumber=Math.max(maxnumber,i);
        }
        int [][]dp=new int[nums.length][maxnumber+1];
        for(int[]r:dp){
            Arrays.fill(r,-1);
        }
        for (int i = 0; i <nums.length ; i++) {
            int m=helper(nums,i,maxnumber,dp);
            max=Math.max(max,m);
        }
        return max;
    }
    public static int helper(int[]nums,int index,int maxprevious,int[][]dp){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index][maxprevious]!=-1)return dp[index][maxprevious];

        int max=0;
        for (int i = index+1; i <nums.length ; i++) {
            int nextdiff=Math.abs(nums[index]-nums[i]);
            if(nextdiff<=maxprevious){
                max=Math.max(helper(nums,i,nextdiff,dp),max);
            }
        }
        dp[index][maxprevious]=max+1;
        return dp[index][maxprevious];
    }
}
