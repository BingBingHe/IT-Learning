

public class ShellSort {
	public static void sort(int[] numbers) {
		int size = numbers.length;
		for (int increment = size / 2; increment > 0; increment /= 2) {
			for (int k = 0; k < increment; k++) {

				// Ö±½Ó²åÈëÅÅÐò
				for (int i = k; i < size; i += increment) {
					int tmp = numbers[i];
					int j = i;
					while (j - increment >= 0 && tmp < numbers[j - increment]) {
						numbers[j] = numbers[j - increment];
						j -= increment;
					}
					numbers[j] = tmp;
				}
			}
		}
	}
}
