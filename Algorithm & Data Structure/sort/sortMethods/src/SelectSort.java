

/**
 * ѡ�������㷨
 * ���ص������ҵ���СԪ�ص���������
 * ��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ��  
 * �ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ����δ����������ʼλ�õ�Ԫ�ؽ����� 
 * �Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ� 
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
