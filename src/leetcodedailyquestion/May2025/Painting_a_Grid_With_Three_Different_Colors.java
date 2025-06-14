package leetcodedailyquestion.May2025;

import java.util.Arrays;

public class Painting_a_Grid_With_Three_Different_Colors {

    public static void main(String[] args) {
        Painting_a_Grid_With_Three_Different_Colors obj=new Painting_a_Grid_With_Three_Different_Colors();
        System.out.println(obj.colorTheGrid(1,1));
    }
    private final int MOD=1000000007;
    public int colorTheGrid(int m, int n) {
        int [][][]dp=new int[m][n][3];
        for(int[][]row:dp){
            for(int[]k:row){
                Arrays.fill(k,-1);
            }
        }
        int [][]fillcolour=new int[m][n];
        return helper(0,0,0,m,n,fillcolour,dp);
    }

    private int helper(int row, int col,int c, int m, int n, int[][] fillcolour,int[][][]dp) {
        if(col==n){
            row++;
            col=0;
        }
        if(row==m)return 1;
        if(dp[row][col][c]!=-1)return dp[row][col][c];
        int upindex=row-1;
        int leftindex=col-1;
        int sum=0;
        for(int color=0;color<3;color++){
            if(upindex>=0&&fillcolour[upindex][col]==color)continue;
            else if(leftindex>=0&&fillcolour[row][leftindex]==color)continue;
            fillcolour[row][col]=color;
            sum=((sum+helper(row,col+1,c,m,n,fillcolour,dp))%MOD);
        }
//        dp[]
        return sum;
    }
}
