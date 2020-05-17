package org.crayzer.leetcode.editor.en.dfs_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode_210_课程表2 {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses == 0) return new int[0];

            HashSet<Integer>[] adj = new HashSet[numCourses];
            for (int i = 0; i < numCourses; i++) {
                adj[i] = new HashSet<>();
            }

            int[] inDegree = new int[numCourses];
            for (int[] p : prerequisites) {
                adj[p[1]].add(p[0]);
                inDegree[p[0]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int[] res = new int[numCourses];
            int count = 0;

            while (!queue.isEmpty()) {
                Integer head = queue.poll();
                res[count] = head;
                count++;

                Set<Integer> successors = adj[head];
                for (Integer nextCourse : successors) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
            if (count == numCourses) {
                return res;
            }
            return new int[0];
        }
    }
}
