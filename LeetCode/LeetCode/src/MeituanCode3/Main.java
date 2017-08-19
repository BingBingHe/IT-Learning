package MeituanCode3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int T = in.nextInt();
		int C = in.nextInt();
		int[] t = new int[n];
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = in.nextInt();
			c[i] = in.nextInt();
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (t[i] < min)
				min = t[i];
			if (t[i] > max)
				max = t[i];
		}
//		System.out.println(min);
//		System.out.println(max);
		if (T >= min && T <= max) {
			System.out.println("Impossible");
		} else if (T < min) {
			double sumTmp = 0;
			for (int i = 0; i < n; i++) {
				sumTmp += (t[i] - min) * c[i] * 1.0 / (min - T);
			}
			if (sumTmp <= C) {
				System.out.println("Possible");
				System.out.println(String.format("%.4f", min * 1.0000));
			} else {
				System.out.println("Impossible");
			}
		} else {
			double sumTmp = 0;
			double[] cd = new double[n];
			for (int i = 0; i < n; i++) {
				double tmp = (t[i] - max) * c[i] * 1.0 / (max - T);
				sumTmp += tmp;
				cd[i] = tmp + c[i];
			}
			if (sumTmp <= C) {
				System.out.println("Possible");
				double cc = C * 1.0 - sumTmp;

				double[] unit = new double[n];
				double units = 0;
				for (int i = 0; i < n; i++) {
					unit[i] = cd[i] / (T - max - 1);
					units += unit[i];
//					System.out.println(cd[i]);
//					System.out.println(unit[i]);
//					System.out.println((unit[i] * T + max * cd[i]) / (cd[i] + unit[i]));
				}
//				double s = 0;
//				for (int i = 0; i < n; i++) {
//					System.out.println(cc / units * unit[i]);
//					s+= cc / units * unit[i];
//				}
//				
//				System.out.println(s);
//				System.out.println(cc / units);

				System.out.println(String.format("%.4f", max * 1.0000 + cc / units));
			} else {
				System.out.println("Impossible");
			}
		}
	}
}