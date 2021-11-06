package algorithm.sort;

/**
 * author: lllddd
 * created on: 2021/9/5 21:28
 * description:快速排序
 */
public class QuickSort implements ISort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        __quickSort(array, 0, array.length - 1);
    }

    private void __quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = __partation2(array, left, right);
        __quickSort(array, left, p - 1);
        __quickSort(array, p + 1, right);
    }

    /**
     * 分块，将数组分为左中右散步备份，中间是某个元素排序好后应该在的位置，左侧的数组元素都比它小，右侧的数组元素都比它大
     *
     * @param array 数组
     * @param left  左侧游标
     * @param right 右侧游标
     * @return 最终中间元素的游标
     */
    private int __partation(int[] array, int left, int right) {
        // TODO: 2021/9/5
        int value = array[left];

        int div = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < value) {
                int temp = array[i];
                array[i] = array[div + 1];
                array[div + 1] = temp;
                div++;
            }
        }

        int temp = array[left];
        array[left] = array[div];
        array[div] = temp;
        return div;
    }

    /**
     * 第二种分块方法
     *
     * @param array 数组
     * @param left  左游标
     * @param right 右游标
     */
    private int __partation2(int[] array, int left, int right) {
        int value = array[left];

        int i = left + 1;
        int j = right;
        while (i <= right && j >= left + 1) {
            while (i <= right && array[i] <= value) {
                i++;
            }
            while (j >= left + 1 && array[j] >= value) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        array[left] = array[j];
        array[j] = value;
        return j;
    }
}
