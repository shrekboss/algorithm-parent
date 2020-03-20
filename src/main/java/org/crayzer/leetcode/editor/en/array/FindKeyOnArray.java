package org.crayzer.leetcode.editor.en.array;

/**
 * method_name:
 * param:
 * describe:
 *      在数组arr中，查找key，返回key所在的位置
 *      其中，length表示数组arr的长度
 **/
public class FindKeyOnArray {

    public static int findKeyOnArray1(int[] arr, int length, int key) {
        if (arr == null || length <= 0) {
            return -1;
        }

        int i = 0;
        while (i < length) {
            if (arr[i] == key) {
                return i;
            }
            i++;
        }

        return -1;
    }

    public static int findKeyOnArray2(int[] arr, int length, int key) {
        if (arr == null || length <= 0) {
            return -1;
        }

        // 这里因为要将a[n-1]的值替换成key，所以要特殊处理这个值
        if (arr[length-1] == key) {
            return length-1;
        }

        // 把a[n-1]的值临时保存在变量tmp中，以便之后恢复。tmp=6。
        // 之所以这样做的目的是：希望find()代码不要改变a数组中的内容
        int tmp = arr[length-1];
        // 把key的值放到a[n-1]中，此时a = {4, 2, 3, 5, 9, 7}
        arr[length-1] = key;

        int i = 0;
        // while 循环比起代码一，少了i<n这个比较操作
        while (arr[i] != key) {
            ++i;
        }

        // 恢复a[n-1]原来的值,此时a= {4, 2, 3, 5, 9, 6}
        arr[length-1] = tmp;

        if (i == length-1) {
            // 如果i == n-1说明，在0...n-2之间都没有key，所以返回-1
            return -1;
        } else {
            // 否则，返回i，就是等于key值的元素的下标
            return i;
        }
    }

    public static int[] createArray(int capacity) {
        int[] arr = new int[capacity];
        for (int i=0;i<capacity;i++) {
            arr[i] = i;
        }

        return arr;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // int[] arr1 = {4, 2, 3, 5, 9, 6};
        int[] arr1 = createArray(1000000);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + ", index: " + findKeyOnArray1(arr1, 1000000, 999999));

        start = System.currentTimeMillis();
        // int[] arr2 = {4, 2, 3, 5, 9, 6};
        int[] arr2 = createArray(1000000);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + ", index: " + findKeyOnArray2(arr2, 1000000, 999999));
    }

}
