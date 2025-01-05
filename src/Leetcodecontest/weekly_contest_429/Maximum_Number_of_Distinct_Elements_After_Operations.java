package Leetcodecontest.weekly_contest_429;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Maximum_Number_of_Distinct_Elements_After_Operations {
    public static void main(String[] args) {
        int []arr={1,2,2,3,3,4};
        System.out.println(maxDistinctElements(arr,2));

    }
    public static  int maxDistinctElements(int[] nums, int k) {
        PriorityQueue<Integer>queue=new PriorityQueue<>((a,b)->b-a);
        for (int num : nums) {
            queue.add(num);
        }
        HashSet<Integer>map=new HashSet<>();
        helper(queue,map,k);
        return  map.size();
    }

    private static void helper(PriorityQueue<Integer> queue, HashSet<Integer> map, int k) {
        int last_inserted=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int element=queue.poll();
            int start=element-k;
            int end=element+k;
            if(end >= last_inserted)end=last_inserted-1;
            for (int i = end; i >=start ; i--) {
                if(!map.contains(i)){
                    map.add(i);
                    last_inserted=i;
                    break;
                }
            }
        }
    }
}
