

/**
 * 选择排序算法
 * （重点在于找到最小元素的索引。）
 * 在未排序序列中找到最小元素，存放到排序序列的起始位置  
 * 再从剩余未排序元素中继续寻找最小元素，然后与未排序序列起始位置的元素交换。 
 * 以此类推，直到所有元素均排序完毕。 
 * @param numbers
 */

public class SelectSort {
	public static void sort(int[] numbers){
		int size = numbers.length;
		for(int i = 0; i < size - 1  ; i ++){
			int minIndex = i;
			for(int j = i + 1 ; j < size ; j++){
				if( numbers[j] < numbers[minIndex]){
					minIndex = j;
				}
			}
			int tmp = numbers[minIndex];
			numbers[minIndex] = numbers[i];
			numbers[i] = tmp;
		}
	}
}
