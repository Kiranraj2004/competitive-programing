package Codeforces.Round_995_Div3;

import java.util.Scanner;

public class Preparing_for_the_Olympiad {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for (int i = 0; i <t ; i++) {
            int n=in.nextInt();
            int []a=new int[n];
            int  []b=new int[n];
            for (int j = 0; j <n ; j++) {
                a[j]=in.nextInt();
            }
            for (int j = 0; j <n ; j++) {
                b[j]=in.nextInt();
            }
            helper(a,b);

        }
    }
    public static void helper(int[]a,int []b){
        int m=0;
        int s=0;
        int n=a.length;
        for (int i = 0; i <n ; i++) {
            if(i+1<n){
                if(b[i+1]<a[i]){
                    m+=a[i];
                    s+=b[i+1];
                }
            }
            else{
                m+=a[i];
            }

        }
        System.out.println(m-s);
    }
}
