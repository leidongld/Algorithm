package algorithm.sort;

/**
 * author: lllddd
 * created on: 2021/9/5 19:28
 * description:优化后的插入排序
 */
public class OptimizedInsertSort implements ISort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1] > element ; j--) {
                array[j] = array[j - 1];
            }
            array[j] = element;
        }
    }
}
