package sort;

/**
 * ���ڲ��ԣ������Ч����
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����������
		int[] numbers = { 49, 38, 65, 97, 76, 13, 27, 49 };

		// ����
//		BubbleSort.sort(numbers);
		System.out.println("===");
		QuickSort.sort(numbers);
		System.out.println("---");

		// ���
		print(numbers);
	}
	
	public static void print(int[] numbers){
		
		StringBuilder sb = new StringBuilder("��������");
		for (int t : numbers) {
			sb.append(t+",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
