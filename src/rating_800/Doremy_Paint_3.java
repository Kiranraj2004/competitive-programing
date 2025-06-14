package rating_800;

import java.util.HashMap;
import java.util.Scanner;

public class Doremy_Paint_3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int []arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=in.nextInt();
            }
            System.out.println(solve(n,arr));
        }
    }

    private static String solve(int n, int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if(map.size()>=3)return "No";
        int mid=n/2;
        for(int i:map.values()){
            if(i<mid){
                return "No";
            }
        }
        return "Yes";
    }
}
