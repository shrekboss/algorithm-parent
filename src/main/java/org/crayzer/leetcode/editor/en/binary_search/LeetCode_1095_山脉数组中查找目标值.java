package org.crayzer.leetcode.editor.en.binary_search;

public class LeetCode_1095_山脉数组中查找目标值 {
    class MountainArray {
        public int get(int index) {
            // todo
            return 0;
        }

        public int length() {
            // todo
            return 0;
        }
    }

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            // 先找到峰顶索引 peakIdx
            int lo = 0, hi = mountainArr.length() - 1;
            while (lo + 1 < hi) {
                int mid = lo + (hi - lo) / 2;
                int midVal = mountainArr.get(mid);

                if (midVal > mountainArr.get(mid - 1)) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
            int peakIdx = mountainArr.get(lo) > mountainArr.get(hi) ? lo : hi;


            // 根据峰顶将山脉数组分为「升序数组」和「降序数组」两段，分别进行二分查找
            int idx = binSearch(mountainArr, 0, peakIdx, target, true);
            return idx != -1 ? idx : binSearch(mountainArr, peakIdx + 1, mountainArr.length() - 1, target, false);
        }

        private int binSearch(MountainArray mountainArr, int lo, int hi, int target, boolean asc) {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int midVal = mountainArr.get(mid);

                if (midVal == target) {
                    return mid;
                }
                if (midVal < target) {
                    lo = asc ? mid + 1 : lo;
                    hi = asc ? hi : mid - 1;
                } else {
                    hi = asc ? mid - 1 : hi;
                    lo = asc ? lo : mid + 1;
                }
            }
            return -1;
        }
    }
}
