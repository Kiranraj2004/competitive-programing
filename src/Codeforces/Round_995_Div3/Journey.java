package Codeforces.Round_995_Div3;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for (int i = 0; i <t ; i++) {
            int n=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();

            helper(n,a,b,c);

        }
    }
    public  static void helper(int n,int a,int b,int c){
        int sum=a+b+c;
        int days;
        int q=n/sum;
        days=q*3;
        if(n%sum!=0){
            int modula=n%sum;
            modula-=a;
            days++;
            if(modula<=0){

                System.out.println(days);
                return;
            }
            modula-=b;
            days++;
            if(modula<=0){

                System.out.println(days);
                return;
            }
            modula-=c;
            days++;
            if(modula<=0){

                System.out.println(days);
                return;
            }

        }
        System.out.println(days);
    }

}
