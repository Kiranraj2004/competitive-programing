package Leetcodecontest.weekly_contest_429;

import java.util.HashSet;

public class Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct {

    public static void main(String[] args) {
        int []arr={1,13,13,14,9,12,9};
        System.out.println(minimumOperations(arr));

    }
    public static int minimumOperations(int[] nums) {
        int count=0;
        int start=0;
        HashSet<Integer>map=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            while(i<nums.length&&map.contains(nums[i])) {
                int index = 0;
                count++;
                while (index < 3) {
                    int remove_index = index + start;
                    if (remove_index < nums.length && map.contains(nums[remove_index])) {

                            map.remove(nums[remove_index]);
                        }
                        index++;
                }
                start+=index;
                if(start>i)i=start;
            }
            if(i<nums.length)map.add(nums[i]);

        }
        return count;


    }
}
