

/**  
* ��������
* 
* �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
* ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�� 
* �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��  
* �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��  
* ����Ԫ�ز��뵽��λ����  
* �ظ�����2  
* @param numbers  ����������
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
