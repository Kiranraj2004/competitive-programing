package Leetcodecontest.jan2025;

import java.util.*;
import java.lang.*;
import java.io.*;
public class Nutrition_Cost {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){

            System.out.println(solve(in));

        }

    }
    public static int solve(Scanner in){
        int n=in.nextInt();
        int c=in.nextInt();
        int []a=new int [n];
        for (int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int []b=new int [n];
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<n;i++){
            b[i]=in.nextInt();
            if(map.containsKey(a[i])){
                int min=Math.min(b[i],map.get(a[i]));
                map.put(a[i],min);
            }
            else{
                map.put(a[i],b[i]);
            }
        }
        int ans=c;
        ArrayList<Integer>arr=new ArrayList<>(map.values());
        Collections.sort(arr);
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            ans=Math.max(ans,((c*(i+1))-sum));
        }
        return ans==c?0:ans;
    }
}

