package Codechef.START167D;

import java.util.Scanner;

public class Temperature_Balance {
    public static void main (String[] args) throws java.lang.Exception
    {

        // your code goes
         Scanner in=new Scanner(System.in);
                int t=in.nextInt();
                for(int i=1;i<=t;i++){
                    int n=in.nextInt();
                    int []arr=new int[n];
                    for (int j = 0; j <n ; j++) {
                        arr[i]=in.nextInt();
                    }
                    getans(arr);
                }

    }

    private static void getans(int[] arr) {
        int low=0;
        while(low<arr.length){
            if(arr[low]==0){
                low++;
            }
            else{
                break;
            }
        }
        if(low>=arr.length) {
            System.out.println(0);
            return;
        }
        int end=arr.length-1;
        while(end>=0){
            if(arr[end]==0){
                end--;
            }
            else{
                break;
            }
        }
        long temp=arr[low];
        int sec=0;
        for (int i = low; i <=end ; i++) {
            sec+=Math.abs(arr[i]);
            temp=temp+arr[i+1];
        }
        System.out.println(sec);
    }
}
