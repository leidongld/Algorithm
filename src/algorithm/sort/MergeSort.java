package algorithm.sort;

/**
 * author: lllddd
 * created on: 2021/9/5 20:05
 * description:归并排序法
 */
public class MergeSort implements ISort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        __mergeSort(array, 0, array.length - 1);
    }

    /**
     * 递归方法
     *
     * @param array 数组
     * @param left  左闭区间
     * @param right 右闭区间
     */
    private void __mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        // 优化2 right-left较小的话可以使用插入排序

        int middle = (left + right) / 2;
        __mergeSort(array, left, middle);
        __mergeSort(array, middle + 1, right);
        if (array[middle] > array[middle + 1]) {// 优化1，不一定必须__merge()
            __merge2(array, left, middle, right);
        }
    }

    /**
     * 归并的第二种方式
     *
     * @param array  数组
     * @param left   左游标
     * @param middle 中游标
     * @param right  右游标
     */
    private void __merge2(int[] array, int left, int middle, int right) {
        int len = right - left + 1;

        int[] aux = new int[len];

        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                aux[k++] = array[i++];
            } else {
                aux[k++] = array[j++];
            }
        }
        while (i > middle && j <= right) {
            aux[k++] = array[j++];
        }

        while (j > right && i <= middle) {
            aux[k++] = array[i++];
        }

        System.arraycopy(aux, 0, array, left, len);
    }

    /**
     * 合并
     *
     * @param array  数组
     * @param left   左游标
     * @param middle 中间游标
     * @param right  右游标
     */
    private void __merge(int[] array, int left, int middle, int right) {
        int[] newArray = new int[right - left + 1];

        if (right + 1 - left >= 0) System.arraycopy(array, left, newArray, 0, right + 1 - left);

        int i = left;
        int j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                array[k] = newArray[j - left];
                j++;
            } else if (j > right) {
                array[k] = newArray[i - left];
                i++;
            } else {
                if (newArray[i - left] < newArray[j - left]) {
                    array[k] = newArray[i - left];
                    i++;
                } else {
                    array[k] = newArray[j - left];
                    j++;
                }
            }
        }
    }


}
