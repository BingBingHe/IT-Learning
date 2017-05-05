
public class HeapSort {
	public static void sort(int[] numbers) {
		int size = numbers.length;

		for (int i = 0; i < size - 1; i++) {

			// 建堆
			int lastIndex = size - 1 - i;
			buildMaxHeap(numbers, lastIndex);
			// 交换堆顶和最后一个元素
			swap(numbers, lastIndex, 0);
		}
	}

	public static void buildMaxHeap(int[] numbers, int lastIndex) {
		// 从lastIndex处节点(最后一个节点)的父节点开始，每次往前一个步长。
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int k = i; // 保存正在判断的父节点
			while (k * 2 + 1 <= lastIndex) { // 判断当前k节点的子节点是否存在
				int biggerIndex = 2 * k + 1; // 这是k节点的左子节点的索引。
				if (biggerIndex < lastIndex) {
					if (numbers[biggerIndex] < numbers[biggerIndex + 1]) { // 如果左子节点小于右子节点，那么将大索引赋值为相应节点索引。
						biggerIndex++;
					}
				}

				if (numbers[k] < numbers[biggerIndex]) {
					swap(numbers, k, biggerIndex);
					k = biggerIndex;
					// 交换，并在while循环内再做调整，保证k节点的值大于其左右子节点的值。
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
