package Codeforces.Round_995_Div3;


import java.util.Scanner;

public class Preparing_for_the_Exam {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for (int i = 0; i <t ; i++) {
            int n=in.nextInt();
            int m=in.nextInt();
            int k=in.nextInt();
            int []m_arr=new int[m];

            for (int j = 0; j <m ; j++) {
                m_arr[j]=in.nextInt();
            }
            long k_sum=0;
            for (int j = 0; j <k ; j++) {
                k_sum+=in.nextInt();
            }


            helper(n,m,k,m_arr,k_sum);
            System.out.println();

        }

    }

    private static void helper(int n, int m, int k, int[] m_arr, long  k_sum) {
        if(m==k&&m==n){
            for (int i = 0; i <m ; i++) {
                System.out.print(1);
            }
            return;
        }
        if(k<n-1){
            for (int i = 0; i <m ; i++) {
                System.out.print(0);
            }
            return;
        }
        long sum=((long) n *(n+1))/2;
        int missing= (int) ((int)sum-k_sum);
        
        for (int i = 0; i <m ; i++) {
            int not_present=m_arr[i];
            if(missing==not_present||missing==0){
                System.out.print(1);
            }
            else{
                System.out.print(0);
            }
        }
    }

}
