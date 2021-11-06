package algorithm.sort;

/**
 * author: lllddd
 * created on: 2021/9/5 19:28
 * description:冒泡排序
 */
public class BubbleSort implements ISort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
