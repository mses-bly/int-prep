import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
* https://www.hackerrank.com/challenges/coin-change
**/
public class CoinChange {
	public static HashSet<String> coinWays(int N, int[] coins, int idx, HashSet<String>[][] mem, boolean[][] visited) {
		if (idx < 0) return null;
		if (N < 0) return null;
		if (idx == 0 && N == 0) return new HashSet<String>();
		if(N == 0) return new HashSet<String>();

		if (visited[N][idx]) return mem[N][idx];

		HashSet<String> result = new HashSet<String>();

		int rem = N - coins[idx];

		String current = String.valueOf(coins[idx]);

		//Option 1: Reduce N & idx
		HashSet<String> o1 = coinWays(rem, coins, idx - 1, mem, visited);
		if (o1 != null) {
			if (o1.isEmpty()) {
				result.add(current);
			} else {
				for (String s : o1) {
					result.add(current + s);
				}
			}

		}

		//Option 2: Reduce N & keep idx
		o1 = coinWays(rem, coins, idx, mem, visited);
		if (o1 != null) {
			if (o1.isEmpty()) {
				result.add(current);
			} else {
				for (String s : o1) {
					result.add(current + s);
				}
			}
		}

		//Option 2: Keep N & reduce idx
		o1 = coinWays(N, coins, idx - 1, mem, visited);
		if (o1 != null) {
			for (String s : o1) {
				result.add(s);
			}
		}

		visited[N][idx] = true;
		if (result.isEmpty()) return null;
		mem[N][idx] = result;
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] coins = new int[M];
		for (int i = 0; i < M; i++) {
			coins[i] = in.nextInt();
		}

		HashSet<String>[][] mem = new HashSet[N + 1][M];
		boolean[][] visited = new boolean[N + 1][M];


		Arrays.sort(coins);
		HashSet<String> result = coinWays(N, coins, M - 1, mem, visited);
		if(result  == null) System.out.println(0);
		else System.out.println(result.size());

	}
}