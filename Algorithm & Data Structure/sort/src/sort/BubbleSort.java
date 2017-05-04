package sort;

/**
 * 冒泡排序 
 * 比较相邻的元素大小，前者大于后者，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 
 * @author Bingbing He
 * 
 * @param numbers
 *            需要排序的整型数组
 * 
 * @return void
 */
public class BubbleSort {
	public static void sort(int[] numbers) {
		int size = numbers.length;
		int tmp = 0;
		// 共(size - 1)轮
		for (int i = 0; i < size - 1; i++) {
			
			for (int j = 0; j < size - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					tmp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tmp;
				}
			}
		}
	}
}
