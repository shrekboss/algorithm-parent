package org.crayzer.leetcode.editor.en.sort.heap.solution.midnum;

import java.util.PriorityQueue;

/**
 * 求中位数的问题
 *
 * @author liujun
 * @version 0.0.1
 * @date 2018/12/02
 */
public class MidNumCount {

  /** 求中位数的信息 */
  public static final MidNumCount INSTANCE = new MidNumCount();

  /** 大顶堆，用来存储前半部分的数据，如果完整为100，那此存储的为0-50 */
  private PriorityQueue<Integer> firstBigHeap =
      new PriorityQueue<>(
          51,
          (o1, o2) -> {
            if (o1 < o2) {
              return 1;
            } else if (o1 > o2) {
              return -1;
            }
            return 0;
          });

  /** 小顶堆,用来存储后半部分的数据，如果完整为100,那此存储的为51-100 */
  private PriorityQueue<Integer> afterLittleHeap = new PriorityQueue<>(51);

  /** 元素的个数 */
  private int count;

  /**
   * 插入数据
   *
   * @param num 当前动态的数据集
   */
  public void putNum(int num) {

    count++;

    // 1,如果堆为空，则插入大顶堆中
    if (firstBigHeap.isEmpty() && afterLittleHeap.isEmpty()) {
      firstBigHeap.offer(num);
      return;
    }

    // 如果数据当前元素比大顶堆中的元素大，则插入小顶堆中
    if (firstBigHeap.peek() < num) {
      afterLittleHeap.offer(num);
    }
    // 如果元素的数据比大顶堆中的元素小，则插入大顶堆中
    else {
      firstBigHeap.offer(num);
    }

    int countValue = count / 2;

    // 如果大顶堆中的数据超过了中位数，则需要要移动,
    // 因为大顶堆中存储的数据为n/2+1个当n为奇数的情况下，所以每次取数，仅返回大顶堆中的数据即可
    if (firstBigHeap.size() > countValue) {
      move(firstBigHeap, afterLittleHeap, afterLittleHeap.size() - countValue);
      return;
    }
    // 如果小顶堆中的数据超过了中位数，也需要移动
    if (afterLittleHeap.size() > countValue) {
      move(afterLittleHeap, firstBigHeap, afterLittleHeap.size() - countValue);
      return;
    }
  }

  /**
   * 返回中位数的数据
   *
   * @return
   */
  public int getMidValue() {
    return firstBigHeap.peek();
  }

  /**
   * 从一个堆向另一个堆中移动元素
   *
   * @param src
   * @param out
   */
  private void move(PriorityQueue<Integer> src, PriorityQueue<Integer> out, int runNum) {
    for (int i = 0; i < runNum; i++) {
      out.offer(src.poll());
    }
  }
}
