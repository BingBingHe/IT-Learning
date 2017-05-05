

import java.util.Stack;

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
	 * 递归方法
	 * 
	 * @param numbers
	 *            待排序数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int middle = partition(numbers, low, high);
			quickSort(numbers, low, middle - 1);
			quickSort(numbers, middle + 1, high);
		}
	}

	/**
	 * 非递归方法
	 * 
	 * @param numbers
	 *            待排序数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 */
	public static void quickSort2(int[] numbers, int low, int high) {
		Stack<Integer> stack = new Stack<>();
		if (low < high) {
			stack.add(low);
			stack.add(high);
			while (!stack.isEmpty()) {
				high = stack.pop();
				low = stack.pop();
				if (low >= high) {
					continue;
				}
				int middle = partition(numbers, low, high);
				stack.add(low);
				stack.add(middle - 1);
				stack.add(middle + 1);
				stack.add(high);
			}
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
	public static int partition(int[] numbers, int low, int high) {
		int tmp = numbers[low];
		while (low < high) {
			while (low < high && numbers[high] >= tmp) {
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
		return middle;
	}

	/**
	 * 查找出中轴,把小的放一边，把大的放一边
	 * 
	 * @param numbers
	 *            带查找数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 * @return 中轴所在位置
	 */
	public static int partition2(int[] numbers, int low, int high) {
		int pivot = numbers[high];
		int current = low;
		for (int i = low; i <= high; i++) {
			if (numbers[i] < pivot) {
				swap(numbers, i, current);
				current++;
			}
		}
		swap(numbers, high, current);
		int middle = current;
		return middle;
	}

	public static int partition3(int[] numbers, int low, int high) {
		int pivot = numbers[low];
		int start = low;
		while(low <= high){
			while(low<= high && numbers[low] <= pivot){
				low++;
			}
			while(low<=high && numbers[high] >= pivot){
				high--;
			}
			if(low < high){
				swap(numbers, low, high);
			}
		}
		swap(numbers, high , start);
		int middle = high;
		return middle;
	}

	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

}
