package leetcodedailyquestion.april2024;

public class Snakes_and_Ladders {
    public static void main(String[] args) {

    }
    public int snakesAndLadders(int[][] board) {
        int n= board.length;
        int dp[]=new int[n*n+1];
        int ans= dfs(board,1,n,dp);


        return ans==Integer.MAX_VALUE?-1:ans;
    }

    private int dfs(int[][] board, int number,int n,int []dp) {
        if(n*n==number){
            return 0;
        }
        if(dp[number]!=0){
            return dp[number];

        }

        int ans=Integer.MAX_VALUE;
        for (int i = 6; i >=1&&number+i<=n*n ; i--) {
            int temp=number+i;
            int []rowcoll=giverow(temp,n);
            int row=rowcoll[0];
            int col=rowcoll[1];
            if(board[row][col]!=-1){
                ans=Math.min(dfs(board,board[row][col],n,dp),ans);
            }
            else{
                ans=Math.min(dfs(board,temp,n,dp),ans);
            }
        }
        ans=ans==Integer.MAX_VALUE?ans:ans+1;
        return dp[number]=ans;
    }

    private int[] giverow(int number, int n) {
        int ceil= (int) Math.ceil((double) number /n);
        int []ans=new int[]{ceil,0};
        int temp=number-1;
        if(ceil%2==0){
            ans[1]=((n-1)-(temp%n));
        }
        else{
            ans[1]=temp%n;
        }
        return ans;

    }



}
