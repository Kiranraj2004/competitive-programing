package rating_800;

import java.util.Scanner;

public class Rectangle_Cutting {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int a=in.nextInt();
            int b=in.nextInt();
            solve(a,b);
        }
    }
    public static void solve(int a,int b){
        if((a&1)==0){
            int rem=a/2;
            if(rem!=b){
                System.out.println("yes");
                return;
            }
        }
        if((b&1)==0){
            int rem=b/2;
            if(rem!=a){
                System.out.println("yes");
                return;
            }
        }
        System.out.println("No");

    }
}
