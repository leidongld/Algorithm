package algorithm.heap;

import algorithm.AlgorithmHelper;

import java.util.Random;

/**
 * author: lllddd
 * created on: 2021/9/12 22:28
 * description:最大堆的实现
 */
public class MaxHeap {
    private int[] mArray;

    private int mCount;

    private int mCapacity;

    public MaxHeap(int capacity) {
        this.mArray = new int[capacity + 1];
        this.mCapacity = capacity;
        this.mCount = 0;
    }

    public int size() {
        return this.mCount;
    }

    public boolean isEmpty() {
        return this.mCount == 0;
    }

    /**
     * 新加入一个元素
     *
     * @param item 元素
     */
    public void insert(int item) {
        if (mCapacity >= mCount + 1) {
            mArray[mCount + 1] = item;
            mCount++;

            shiftUp(mCount);
        }
    }

    /**
     * 删除元素
     */
    public int extractMax() {
        int result = mArray[1];
        swap(mArray, 1, mCount);
        mCount--;

        shiftDown(1);
        return result;
    }

    private void shiftDown(int index) {
        while (2 * index <= mCount) {
            int i = 2 * index;
            if (i + 1 <= mCount && mArray[i] < mArray[i + 1]) {
                i += 1;
            }
            if (mArray[index] > mArray[i]) {
                break;
            }
            swap(mArray, index, i);
            index = i;
        }
    }

    /**
     * 将索引为index的元素移动到合适的位置以保证最大堆
     *
     * @param index 等待处理元素在数组中的索引
     */
    private void shiftUp(int index) {
        while (index > 1 && mArray[index] > mArray[index / 2]) {
            swap(mArray, index, index / 2);
            index /= 2;
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);

//        System.out.println(algorithm.heap.isEmpty());
//        System.out.println(algorithm.heap.size());

        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            heap.insert(Math.abs(random.nextInt()) % 20);
        }

        for (int i = 1; i < heap.mCount + 1; i++) {
            System.out.println(heap.extractMax());
        }
    }
}
