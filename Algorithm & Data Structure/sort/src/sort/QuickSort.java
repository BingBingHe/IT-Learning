package sort;

public class QuickSort {

	/**
	 * 快速排序
	 * 
	 * @param numbers
	 *            带排序数组
	 */
	public static void sort(int[] numbers) {
		if (numbers.length > 0) {
			quickSort(numbers, 0, numbers.length - 1);
		}
	}

	/**
	 * @param numbers
	 *            待排序数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int middle = getMiddle(numbers, low, high);
			
			quickSort(numbers, low, middle - 1);
			quickSort(numbers, middle + 1, high);
		}
	}

	/**
	 * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
	 * 
	 * @param numbers
	 *            带查找数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 * @return 中轴所在位置
	 */
	public static int getMiddle(int[] numbers, int low, int high) {
		int tmp = numbers[low];
		while (low < high) {
			while (low < high && numbers[high] >= tmp) {
				System.out.println("?");
				high--;
			}
			numbers[low] = numbers[high];

			while (low < high && numbers[low] <= tmp) {
				low++;
			}
			numbers[high] = numbers[low];
		}

		numbers[low] = tmp;
		int middle = low;
		System.out.println(middle);
		return middle;
	}

}
