package Leetcodecontest.weekly_contest_422;
import java.util.*;
// shortest distance problem
public class Find_Minimum_Time_to_Reach_Last_Room_I {
    public static void main(String[] args) {
        int [][]arr={{0,4},{4,4}};
        System.out.println(minTimeToReach(arr));

    }
    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        // Priority queue for Dijkstra's algorithm, with (time, i, j)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0}); // start at (0, 0) with time 0

        // Distance array to track minimum time to each cell
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] =0 ;

        // Directions array for adjacent cells
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], i = current[1], j = current[2];

            // If reached the last cell, return the minimum time
            if (i == n - 1 && j == m - 1) {
                return time;
            }

            // Explore neighbors
            for (int d = 0; d < 4; d++) {
                int ni = i + dRow[d];
                int nj = j + dCol[d];

                // Check boundaries
                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                    int difftime=Math.max(moveTime[ni][nj]-time,0);
                    int realtime=time+difftime+1;

                    if(dist[ni][nj]>realtime){
                        dist[ni][nj]=realtime;
                        pq.add(new int[]{realtime,ni,nj});
                    }
                }
            }
        }
        return -1; // Return -1 if unreachable, though problem constraints imply this won't happen
    }
}
