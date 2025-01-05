package Codechef.START167D;

import java.util.Scanner;

public class Lottery_Tickets {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
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
        int last=(int)Math.pow(10,6);
        int cheflottery=arr[0];
        int low=0;
        int upper=last+1;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]<cheflottery&&arr[i]>low){
                low=arr[i];
            }
            if(arr[i]>cheflottery&&arr[i]<upper){
                upper=arr[i];
            }
        }
        long ans=1;
        if(low==0){
            ans+=cheflottery-1;
        }
        else {
            ans+=((cheflottery-low)/2);
        }
        if(upper==last+1){
            ans+=(upper-cheflottery)-1;
        }else{
            ans+=((upper-cheflottery)/2);
        }
        System.out.println(ans);
    }
}
