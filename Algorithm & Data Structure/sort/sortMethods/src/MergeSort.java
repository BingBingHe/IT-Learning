

/**
 * �鲢���� ���:�����������������ϣ������ϲ���һ���µ������ ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������
 * ʱ�临�Ӷ�ΪO(nlogn) �ȶ�����ʽ
 * 
 * @param nums
 *            ����������
 * @return �����������
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
	 * ��������low��highλ�õ�����������
	 * 
	 * @param nums
	 *            ����������
	 * @param low
	 *            ���ŵĿ�ʼλ��
	 * @param mid
	 *            �����м�λ��
	 * @param high
	 *            ���Ž���λ��
	 */
	public static void merge(int[] numbers, int low, int mid, int high) {
		int[] tmp = new int[high - low + 1];
		int i = low; // ��ָ��
		int j = mid + 1; // ��ָ��
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

	// �ǵݹ�
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
