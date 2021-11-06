package algorithm;

import java.util.Random;

/**
 * author: lllddd
 * created on: 2021/9/1 22:44
 * description:帮助类
 */
public class AlgorithmHelper {
    /**
     * 随机生成一个整型数组
     *
     * @param n   数组长度
     * @param min 最小数
     * @param max 最大数
     * @return 目标数组
     */
    public static int[] genRandomArray(int n, int min, int max) {
        if (n <= 0 || min >= max) {
            throw new RuntimeException("随机生成数组失败，请检查参数！");
        }

        int[] array = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int temp = Math.abs(random.nextInt()) % (max - min + 1) + min;
            array[i] = temp;
        }

        return array;
    }

    /**
     * 打印数组
     *
     * @param array 数组
     */
    public static void printArray(int[] array) {
        if (array != null && array.length != 0) {
            for (int item : array) {
                System.out.print(item);
                System.out.print("   ");
            }
        }
    }
}
