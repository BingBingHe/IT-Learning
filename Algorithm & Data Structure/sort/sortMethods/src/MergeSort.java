

/**
 * 归并排序 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
 * 时间复杂度为O(nlogn) 稳定排序方式
 * 
 * @param nums
 *            待排序数组
 * @return 输出有序数组
 */
public class MergeSort {
	public static void sort(int[] numbers) {
		int size = numbers.length;
		mergeSort(numbers, 0, size - 1);
	}

	public static void mergeSort(int[] numbers, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(numbers, low, mid);
			mergeSort(numbers, mid + 1, high);
			merge(numbers, low, mid, high);
		}
	}

	/**
	 * 将数组中low到high位置的数进行排序
	 * 
	 * @param nums
	 *            待排序数组
	 * @param low
	 *            待排的开始位置
	 * @param mid
	 *            待排中间位置
	 * @param high
	 *            待排结束位置
	 */
	public static void merge(int[] numbers, int low, int mid, int high) {
		int[] tmp = new int[high - low + 1];
		int i = low; // 左指针
		int j = mid + 1; // 右指针
		int k = 0;

		while (i <= mid && j <= high) {
			if (numbers[i] < numbers[j]) {
				tmp[k++] = numbers[i++];
			} else {
				tmp[k++] = numbers[j++];
			}
		}

		while (i <= mid) {
			tmp[k++] = numbers[i++];
		}

		while (j <= mid) {
			tmp[k++] = numbers[j++];
		}

		for (int t = 0; t < k; t++) {
			numbers[t + low] = tmp[t];
		}
	}

	// 非递归
	public static void merge_sort(int[] numbers) {
		int size = numbers.length;
		int[] tmpArray = new int[size];
		int block = 1;
		while (block < size * 2) {
			for (int start = 0; start < size; start += 2 * block) {
				int low = start;
				int mid = start + block;
				if (mid > size) {
					mid = size;
				}
				int high = start + 2 * block;
				if (high > size) {
					high = size;
				}

				int start1 = low;
				int end1 = mid;
				int start2 = mid;
				int end2 = high;
				int k = low;
				while (start1 < end1 && start2 < end2) {
					if (numbers[start1] < numbers[start2]) {
						tmpArray[k++] = numbers[start1++];
					} else {
						tmpArray[k++] = numbers[start2++];
					}
				}
				while (start1 < end1) {
					tmpArray[k++] = numbers[start1++];
				}
				while (start2 < end2) {
					tmpArray[k++] = numbers[start2++];
				}
			}
			for (int t = 0; t < size; t++) {
				numbers[t] = tmpArray[t];
			}
			block *=2;
		}
	}
}
