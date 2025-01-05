package Leetcodecontest.biweekly_constest_143;

public class Count_Subarrays_of_Length_Three_With_a_Condition {
    public static void main(String[] args) {

    }

//     optimal solution TC O(n-3) sc O(1)
    public int countSubarrays(int[] nums) {
        int count=0;

        for(int start=2;start<nums.length;start++){
            int sum_of_first_last=nums[start]+nums[start-2];
            if(nums[start-1]==sum_of_first_last*2){
                count++;
            }
        }
        return count;

    }
}
