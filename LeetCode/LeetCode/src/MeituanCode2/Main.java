package MeituanCode2;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static boolean DFS(int[][] matrix, boolean[] visited, int x, int dst) {
		visited[x] = true;
		if (x == dst)
			return true;

		boolean result = false;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i] && (matrix[x][i] == 1)) {
				result = result || DFS(matrix, visited, i, dst);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String t = in.nextLine();
		int N = Integer.parseInt(t);
		String[] input = new String[N+2];
		input[0] = "t";
		for (int i = 1; i <= N + 1; i++) {
			input[i] = in.nextLine();
		}

		Map<String, Integer> map = new HashMap<>();

		int id = 0;
		for (int i = 1; i < input.length; i++) {
			String[] rela = input[i].split(" ");
			for (String func : rela) {
				if (!map.containsKey(func)) {
					map.put(func, id++);
				}
			}
		}

		int[][] matrix = new int[id][id];
		for (int i = 1; i < input.length; i++) {
			String[] rela = input[i].split(" ");

			matrix[map.get(rela[0])][map.get(rela[1])] = 1;
		}

		int src = map.get(input[input.length - 1].split(" ")[0]);
		int dst = map.get(input[input.length - 1].split(" ")[1]);
		
		// DFS
		if (DFS(matrix, new boolean[id], src, dst) && DFS(matrix, new boolean[id], dst, src)) {
			System.out.println("T");
		} else {
			System.out.println("F");
		}
	}
}