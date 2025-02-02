package Leetcodecontest.Febrauary_2025;

import java.util.HashMap;

public class Maximum_Difference_Between_Even_and_Odd_Frequency {
    public static void main(String[] args) {
        String s="aaaaabbc";
        System.out.println(maxDifference(s));
    }
    public static  int maxDifference(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
       int []arr=new int[4];
        arr[1]=Integer.MAX_VALUE;
        arr[3]=Integer.MAX_VALUE;

        for(int i:map.values()){
            if(i%2==1){
                arr[0]=Math.max(arr[0],i);
                arr[1]=Math.min(arr[1],i);

            }
            else{
                arr[2]=Math.max(arr[2],i);
                arr[3]=Math.min(arr[3],i);
            }
        }

        int diff=Integer.MIN_VALUE;
        for(int i=0;i<2;i++){
            diff=Math.max(diff,(arr[i]-arr[2]));
            diff=Math.max(diff,(arr[i]-arr[3]));

        }
        return diff;

    }
}
