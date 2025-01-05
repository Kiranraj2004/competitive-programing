package leetcodedailyquestion.Dec2024;

public class Best_Sightseeing_Pair {
    public static void main(String[] args) {

    }
    public int maxScoreSightseeingPair(int[] values) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <values.length-1 ; i++) {
            for (int j = i+1; j < values.length ; j++) {
                int score=values[i]+values[j]+j-i;
                max=Math.max(max,score);
            }
        }
        return max;
    }
//     optimal dp approach
    public int maxScoreSightseeingPair1(int[] values) {
        int maxleftscore=values[0];
        int maxscore=0;
        for(int i=1;i<values.length;i++){
//            present element can contribute as second pair then
            int currentrightscore=values[i]-i;
//            add the first pair maximun from the left side
            maxscore=Math.max(maxscore,currentrightscore+maxleftscore);
            int currentleftscore=values[i]+i;
//             if this want to be the first pair then it should be max then the maxleftscore
            maxleftscore=Math.max(maxleftscore,currentleftscore);
        }
        return maxscore;
    }
}
