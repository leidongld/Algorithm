package algorithm.sort;

/**
 * author: lllddd
 * created on: 2021/9/5 19:28
 * description:插入排序
 */
public class InsertSort implements ISort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }
}
