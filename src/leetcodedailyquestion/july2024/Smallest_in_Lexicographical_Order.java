package leetcodedailyquestion.july2024;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Smallest_in_Lexicographical_Order {
    public static void main(String[] args) {
        String []arr=new String[]{"107","10","1","2"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int findKthNumber(int n, int k) {
        String []arr=new String[n];
        for(int i=1;i<=n;i++)
        {
            arr[i]= String.valueOf(i);
        }
        Arrays.sort(arr);
        return Integer.parseInt(arr[k-1]);

    }
}
