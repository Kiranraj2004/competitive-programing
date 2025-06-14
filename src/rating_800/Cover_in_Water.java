package rating_800;
import java.util.*;
public class Cover_in_Water {
    public static void main(String[]hdbhf){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            String s=in.next();
            System.out.println(solve(n,s));
        }
    }
    public static int solve(int n,String s){
        int min=0;
        int count=0;
        for(char i:s.toCharArray()){
            if(i=='#')count=0;
           else {
                min++;
                count++;
            }
            if (count >= 3) return 2;
        }
        return min;
    }
}
