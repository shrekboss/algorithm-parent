package org.crayzer.leetcode.editor.en.stack;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode_871_最低加油次数 {

    class Solution1 {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            int N = stations.length;
            long[] dp = new long[N + 1];
            dp[0] = startFuel;
            for (int i = 0; i < N; ++i)
                for (int t = i; t >= 0; --t)
                    if (dp[t] >= stations[i][0])
                        dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

            for (int i = 0; i <= N; ++i)
                if (dp[i] >= target) return i;
            return -1;
        }
    }

    class Solution {
        public int minRefuelStops(int target, int tank, int[][] stations) {
            // pq is a maxheap of gas station capacities
            PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
            int ans = 0, prev = 0;
            for (int[] station: stations) {
                int location = station[0];
                int capacity = station[1];
                tank -= location - prev;
                while (!pq.isEmpty() && tank < 0) {  // must refuel in past
                    tank += pq.poll();
                    ans++;
                }

                if (tank < 0) return -1;
                pq.offer(capacity);
                prev = location;
            }

            // Repeat body for station = (target, inf)
            {
                tank -= target - prev;
                while (!pq.isEmpty() && tank < 0) {
                    tank += pq.poll();
                    ans++;
                }
                if (tank < 0) return -1;
            }

            return ans;
        }
    }
}
