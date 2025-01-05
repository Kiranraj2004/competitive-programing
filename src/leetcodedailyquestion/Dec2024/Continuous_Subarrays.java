package leetcodedailyquestion.Dec2024;
import java.util.*;
public class Continuous_Subarrays {
    public static void main(String[] args) {
        Continuous_Subarrays obj=new Continuous_Subarrays();
        int []arr={65,66,67,66,66,65,64,65,65,64};
        System.out.println(obj.continuousSubarrays(arr));

    }
    public long continuousSubarrays(int[] nums) {
        long count=1;
        int left=0,right=1;
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer>minHeap=new PriorityQueue<>((a,b)->a-b);
        maxHeap.add(nums[0]);
        minHeap.add(nums[0]);
        while(right<nums.length){
            int maxdiff=Math.abs(maxHeap.peek()-nums[right]);
            int mindiff=Math.abs(minHeap.peek()-nums[right]);
            while(left<right&&(maxdiff>2||mindiff>2)){
                minHeap.remove(nums[left]);
                maxHeap.remove(nums[left]);
                left++;
                if(maxHeap.isEmpty())break;
                maxdiff=Math.abs(maxHeap.peek()-nums[right]);
                mindiff=Math.abs(minHeap.peek()-nums[right]);

            }
            maxHeap.add(nums[right]);
            minHeap.add(nums[right]);
            count+=(right-left+1);
            right++;

        }
        return count;
    }
}
