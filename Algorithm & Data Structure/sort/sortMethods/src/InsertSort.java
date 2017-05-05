

/**  
* 插入排序
* 
* 从第一个元素开始，该元素可以认为已经被排序
* 取出下一个元素，在已经排序的元素序列中从后向前扫描 
* 如果该元素（已排序）大于新元素，将该元素移到下一位置  
* 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置  
* 将新元素插入到该位置中  
* 重复步骤2  
* @param numbers  待排序数组
*/  

public class InsertSort {
	public static void sort(int[] numbers) {
		int size = numbers.length;
		int tmp = 0;
		for (int i = 0; i < size; i++) {
			tmp = numbers[i];
			int j = i;
			for (; j > 0 && tmp < numbers[j - 1]; j--) {
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = tmp;
		}
	}
}
