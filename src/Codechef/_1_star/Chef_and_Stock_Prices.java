package Codechef._1_star;

import javax.print.DocFlavor;
import java.util.Scanner;

public class Chef_and_Stock_Prices {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            System.out.println(solve(in));
        }

    }

    private static String solve(Scanner in) {
        double s=in.nextDouble();
        double a=in.nextDouble();
        double b=in.nextDouble();
        double c=in.nextDouble();
        boolean f=false;
        if(c<0){
            f=true;
        }
        c=Math.abs(c);
        double reduce=((c/100)*s);
        if(f){
            s-=reduce;
        }
        else{
            s+=reduce;
        }
        if(s>=a&&s<=b){
            return "YES";

        }
        return "No";


    }
}
