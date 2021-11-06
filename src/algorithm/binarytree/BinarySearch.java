package algorithm.binarytree;

import algorithm.AlgorithmHelper;

import java.util.Arrays;

/**
 * author: lllddd
 * created on: 2021/9/13 21:13
 * description:二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = AlgorithmHelper.genRandomArray(100, 0, 100);
        Arrays.sort(array);
        AlgorithmHelper.printArray(array);
        System.out.println();
        System.out.println(findTargetRecursion(array, 10));
    }

    /**
     * 常规的二分查找法实现
     *
     * @param array  数组
     * @param target 目标
     * @return 索引
     */
    private static int findTarget(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int len = array.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int findTargetRecursion(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        return __recursiveSearch(array, target, 0, array.length - 1);
    }

    private static int __recursiveSearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return __recursiveSearch(array, target, left, mid - 1);
        } else {
            return __recursiveSearch(array, target, mid + 1, right);
        }
    }
}
