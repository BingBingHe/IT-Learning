
/**
 * 用于测试，排序的效果。
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 待排序数组
		int[] numbers = { 49, 38, 65, 97, 76, 100 , 2 , 13, 27, 49 };

		// 排序
//		BubbleSort.sort(numbers);

//		QuickSort.sort(numbers);
		
//		SelectSort.sort(numbers);
		
//		InsertSort.sort(numbers);
		
//		ShellSort.sort(numbers);
		
//		HeapSort.sort(numbers);
		
//		MergeSort.sort(numbers);
//		MergeSort.merge_sort(numbers);

		// 输出
		print(numbers);
	}
	
	public static void print(int[] numbers){
		
		StringBuilder sb = new StringBuilder("排序结果：");
		for (int t : numbers) {
			sb.append(t+",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
