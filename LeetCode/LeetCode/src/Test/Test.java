package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		System.out.println(random.nextFloat());
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
			}
		});
		System.out.println(result.size());
	}
}
