package algorithm.sort;

import java.util.Random;

/**
 * author: lllddd
 * created on: 2021/9/5 19:28
 * description:Main函数
 */
public class Main {
    public static void main(String[] args) {
        int[] array = genRandomArray(0, 100, 100);

//        // 冒泡排序
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.algorithm.sort(array);

//        // 插入排序
//        InsertSort insertSort = new InsertSort();
//        insertSort.algorithm.sort(array);

        // 优化后的插入排序
//        OptimizedInsertSort optimizedInsertSort = new OptimizedInsertSort();
//        optimizedInsertSort.algorithm.sort(array);

        // 选择排序
//        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.algorithm.sort(array);

//        // 归并排序
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);

        // 快速排序
//        QuickSort quickSort = new QuickSort();
//        quickSort.algorithm.sort(array);

        printArray(array);
    }

    /**
     * 随机生成数组
     *
     * @param min 最小元素
     * @param max 最大元素
     * @param len 数组长度
     * @return 结果数组
     */
    private static int[] genRandomArray(int min, int max, int len) {
        if (min >= max || len < 1) {
            return null;
        }
        int[] array = new int[len];
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            array[i] = Math.abs(random.nextInt()) % (max - min + 1);
        }

        return array;
    }

    /**
     * 打印数组
     *
     * @param array 数组
     */
    private static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int value : array) {
            System.out.print(value + "  ");
        }
    }
}
