package leetcodedailyquestion.Dec2024;

public class Minimum_Cost_For_Tickets {
    public static void main(String[] args) {
        int []days={1,4,6,7,8,20};
        int []cost={2,7,15};
        System.out.println(mincostTickets(days,cost));

    }
    public static  int mincostTickets(int[] days, int[] costs) {
        int []dp=new int[days.length];
        return helper(days,dp,0,costs);
    }
    public static int helper(int[]days,int[] dp,int index,int[]cost){
        if(index>=days.length){
            return 0;
        }
        int []pass={1,7,30};
        if(dp[index]!=0)return dp[index];
        int max=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            int currentcost=cost[i];
            int move_index=upperbound(days,days[index]+pass[i],index);
            currentcost+=helper(days,dp,move_index,cost);
            max=Math.min(max,currentcost);
        }
        return dp[index]=max;
    }
    public static  int upperbound(int []days,int target,int index){

        int start=index+1;
        int end=days.length-1 ;
        while(start<=end){
            int mid=(start+end)/2;
            if(days[mid]==target)return mid;
            else if(days[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
}
