package solutions;

import java.util.Arrays;

public class Part1 {
	private static int[] coins = new int[8];

	static {
		coins[0] = 1;
		coins[1] = 5;
		coins[2] = 10;
		coins[3] = 20;
		coins[4] = 25;
		coins[5] = 50;
		coins[6] = 100;
		coins[7] = 200;
	}

	public static void main(String[] args) {

		long ways = countWays(-1);
		System.out.println(ways);

	}

	public static long countWays(int n) {
		// Time complexity of this function: O(mn)
		// m is the size of coins that can be used (8 here)
		// Space Complexity of this function: O(n)
		if(n < 0){
			return 0;
		}

		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Assuming base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < coins.length; i++)
			for (int j = coins[i]; j <= n; j++)
				table[j] += table[j - coins[i]];

		return table[n];
	}

}
