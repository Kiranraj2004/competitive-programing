package leetcodedailyquestion.Jan2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {
    public static void main(String[] args) {

    }
    static class pair{
        int row;
        int col;
        int count;
        pair(int r,int c,int s){
            row=r;
            col=c;
            count=s;
        }
    }
    public static int minCost(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        boolean [][]f=new boolean[m][n];
        int[][]a=new int[m][n];
        for(int []r:a) Arrays.fill(r,-1);
        PriorityQueue<pair>q=new PriorityQueue<>((x,y)->x.count-y.count);
        q.add(new pair(0,0,0));
        int []r={0,0,1,-1};
        int []c={1,-1,0,0};
        while (!q.isEmpty()){
            pair node=q.poll();
            int row=node.row,col=node.col,count=node.count;
            if(row==m-1&&col==n-1)return count;
            f[row][col]=true;
            int direct=grid[row][col];
            for (int i = 1; i <=4 ; i++) {
                if(i==direct){
                    int t_row=row+r[i-1];
                    int t_col=col+c[i-1];
                    if(isvalid(t_row,t_col,m,n,f))continue;
                    if(a[t_row][t_col]!=-1){
                        if(a[t_row][t_col]<count)continue;
                    }
                    a[t_row][t_col]=count;
                    q.add(new pair(t_row,t_col,count));


                }
                else{
                    int t_row=row+r[i-1];
                    int t_col=col+c[i-1];
                    if(isvalid(t_row,t_col,m,n,f))continue;
                    if(a[t_row][t_col]!=-1){
                        if(a[t_row][t_col]<count+1)continue;
                    }
                    a[t_row][t_col]=count+1;
                    q.add(new pair(t_row,t_col,count+1));
                }
            }
        }
        return 0;
    }
    public static boolean isvalid(int row,int col,int m,int n,boolean[][]f){
        if(row>=m||row<0)return true;
        if(col>=n||col<0)return true;
        return f[row][col];
    }
}
