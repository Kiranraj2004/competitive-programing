package Leetcodecontest.jan2025;

import java.util.Arrays;
import java.util.HashMap;

public class minimun_cost_to_make_array_identical {
    public static void main(String[] args) {

    }
    public static long minCost(int[]arr,int[]brr,long k){
        int n=arr.length;
        long ans=0;
        long pre=0;
        for (int i = 0; i <n ; i++) {
            if(arr[i]>0&&brr[i]>0){
                pre+=Math.abs(arr[i]-brr[i]);
            }
            else if(arr[i]<0&&brr[i]<0){
                int a=Math.abs(arr[i]);
                int b=Math.abs(brr[i]);
                pre+=Math.abs(a-b);
            }
            else{
                int a=Math.abs(arr[i]);
                int b=Math.abs(brr[i]);
                pre+=Math.abs(a+b);

            }
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            map.put(arr[i],brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        for (int i = 0; i <n ; i++) {
            if(map.get(arr[i])!=brr[i]){
                ans+=k;
                break;
            }
        }
        for (int i = 0; i <n ; i++) {
            if(arr[i]>0&&brr[i]>0){
                ans+=Math.abs(arr[i]-brr[i]);
            }
            else if(arr[i]<0&&brr[i]<0){
                int a=Math.abs(arr[i]);
                int b=Math.abs(brr[i]);
                ans+=Math.abs(a-b);
            }
            else{
                int a=Math.abs(arr[i]);
                int b=Math.abs(brr[i]);
                ans+=Math.abs(a+b);

            }
        }


        return Math.max(pre,ans);

    }
}
