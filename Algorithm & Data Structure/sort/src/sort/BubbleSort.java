package sort;

/**
 * ð������ 
 * �Ƚ����ڵ�Ԫ�ش�С��ǰ�ߴ��ں��ߣ��ͽ�������������
 * ��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ�����һ�㣬����Ԫ��Ӧ�û����������� ������е�Ԫ���ظ����ϵĲ��裬�������һ����
 * ����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
 * 
 * @author Bingbing He
 * 
 * @param numbers
 *            ��Ҫ�������������
 * 
 * @return void
 */
public class BubbleSort {
	public static void sort(int[] numbers) {
		int size = numbers.length;
		int tmp = 0;
		// ��(size - 1)��
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
