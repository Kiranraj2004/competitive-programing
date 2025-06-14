package Codechef._1_star;

import java.util.HashMap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KBoxes {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            solve(in);
        }

    }

    private static void solve(Scanner in) {
        int n=in.nextInt();
        int k=in.nextInt();
        int []a=new int[n];
        int []b=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]= in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i]= in.nextInt();
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(a[i],b[i]);
        }
        long  []ans=new long[n+1];
        PriorityQueue<Integer>q=new PriorityQueue<>();
        long sum=0;

        for(int i=1;i<=n;i++){
            ans[i]=sum;
            sum+=map.get(i);
            q.add(map.get(i));
            if(q.size()>k){
                sum-=q.poll();
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(ans[a[i]]+" ");
        }
        System.out.println();
    }
}
