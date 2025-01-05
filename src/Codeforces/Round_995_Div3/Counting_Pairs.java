package Codeforces.Round_995_Div3;

import java.util.*;

public class Counting_Pairs {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for (int i = 0; i <t ; i++) {
            int n=in.nextInt();
            long x=in.nextLong();
            long y=in.nextLong();
            long sum=0;
            int []arr=new int[n];
            for (int j = 0; j <n ; j++) {
                int element=in.nextInt();
                sum+=element;
                arr[j]=element;
            }
            get_count_pair(n,x,y,arr,sum);
        }
    }

    private static void get_count_pair(int n, long x, long y, int[] a, long totalSum) {
        int count=0;
        // Calculate the range for valid pair sums
        long lowerBound = totalSum - y;
        long upperBound = totalSum - x;

        // Sort the array
        Arrays.sort(a);

        // Use two pointers to find valid pairs

        int left = 0, right = n - 1;

        while (left < right) {
            long pairSum = a[left] + a[right];

            if (pairSum < lowerBound) {
                left++;
            } else if (pairSum > upperBound) {
                right--;
            } else {
                count += (right - left); // All pairs (left, left+1 ... right) are valid
                left++;
            }
        }
        System.out.println(count);
    }
}
