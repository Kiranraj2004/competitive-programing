package rating_800;

import java.util.Scanner;

public class Dont_Try_to_Count {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int m=in.nextInt();
            String a=in.next();
            String b=in.next();
            System.out.println(solve(a,b,n,m));
        }
    }

    private static int solve(String a, String b, int n, int m) {
        for(int i=0;i<=5;i++){
            if(a.contains(b)){
                return i;
            }
            a+=a;
        }
        return -1;
    }
}
