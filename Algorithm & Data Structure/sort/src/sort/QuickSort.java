package sort;

public class QuickSort {

	/**
	 * ��������
	 * 
	 * @param numbers
	 *            ����������
	 */
	public static void sort(int[] numbers) {
		if (numbers.length > 0) {
			quickSort(numbers, 0, numbers.length - 1);
		}
	}

	/**
	 * @param numbers
	 *            ����������
	 * @param low
	 *            ��ʼλ��
	 * @param high
	 *            ����λ��
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int middle = getMiddle(numbers, low, high);
			
			quickSort(numbers, low, middle - 1);
			quickSort(numbers, middle + 1, high);
		}
	}

	/**
	 * ���ҳ����ᣨĬ�������λlow������numbers�������������λ��
	 * 
	 * @param numbers
	 *            ����������
	 * @param low
	 *            ��ʼλ��
	 * @param high
	 *            ����λ��
	 * @return ��������λ��
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
