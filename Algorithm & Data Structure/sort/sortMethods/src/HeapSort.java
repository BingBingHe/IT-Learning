
public class HeapSort {
	public static void sort(int[] numbers) {
		int size = numbers.length;

		for (int i = 0; i < size - 1; i++) {

			// ����
			int lastIndex = size - 1 - i;
			buildMaxHeap(numbers, lastIndex);
			// �����Ѷ������һ��Ԫ��
			swap(numbers, lastIndex, 0);
		}
	}

	public static void buildMaxHeap(int[] numbers, int lastIndex) {
		// ��lastIndex���ڵ�(���һ���ڵ�)�ĸ��ڵ㿪ʼ��ÿ����ǰһ��������
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int k = i; // ���������жϵĸ��ڵ�
			while (k * 2 + 1 <= lastIndex) { // �жϵ�ǰk�ڵ���ӽڵ��Ƿ����
				int biggerIndex = 2 * k + 1; // ����k�ڵ�����ӽڵ��������
				if (biggerIndex < lastIndex) {
					if (numbers[biggerIndex] < numbers[biggerIndex + 1]) { // ������ӽڵ�С�����ӽڵ㣬��ô����������ֵΪ��Ӧ�ڵ�������
						biggerIndex++;
					}
				}

				if (numbers[k] < numbers[biggerIndex]) {
					swap(numbers, k, biggerIndex);
					k = biggerIndex;
					// ����������whileѭ����������������֤k�ڵ��ֵ�����������ӽڵ��ֵ��
				} else {
					break;
				}
			}
		}
	}

	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}
