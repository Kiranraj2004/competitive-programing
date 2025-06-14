package rating_800;

import java.util.Scanner;

public class Target_Practice {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            System.out.println(solve(in));
        }
    }

    private static int  solve(Scanner in) {
        int sum=0;
        char [][]arr=new char[10][10];
        int n=arr.length-1;
        for(int i=0;i<=n;i++){
            String s=in.next();
            arr[i]=s.toCharArray();
        }
        int up=0,down=n,left=0,right=n;
        for(int i=1;i<=5;i++){
            for(int j=left;j<=right;j++){
                if(arr[up][j]=='X')sum+=i;
                if(arr[down][j]=='X')sum+=i;

            }
            for(int j=up+1;j<=down-1;j++){
                if(arr[j][left]=='X')sum+=i;
                if(arr[j][right]=='X')sum+=i;
            }
            up++;
            down--;
            left++;
            right--;
        }


        return sum;
    }
}
