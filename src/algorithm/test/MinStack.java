package algorithm.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * author: lllddd
 * created on: 2021/10/5 19:42
 * description:
 */
public class MinStack {
    public static void main(String[] args) {
//        MinStack stack = new MinStack();
//        stack.push(-2);
//        stack.push(0);
//        stack.push(-3);
//        System.out.println(stack.top());

        int[] array1 = new int[2];
        int[] array2 = new int[10];
        System.arraycopy(array1, 0, array2, 0, array1.length);

        Set<Integer> set = new HashSet<>();
    }

    private int mCount = 0;

    private int[] mNums;

    private final int INIT_SIZE = 10;

    private int mCurrentSize;

    public MinStack() {
        this.mCount = 0;
        this.mNums = new int[INIT_SIZE];
        this.mCurrentSize = INIT_SIZE;
    }

    public void push(int val) {
        if (mCount + 1 == mCurrentSize) {
            mCurrentSize += INIT_SIZE;
            mNums = Arrays.copyOf(mNums, mCurrentSize);
        }
        mNums[mCount++] = val;
    }

    public void pop() {
        --mCount;
    }

    public int top() {
        return mNums[mCount - 1];
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mCount; i++) {
            if (mNums[i] < min) {
                min = mNums[i];
            }
        }
        return min;
    }
}
