
import java.util.Arrays;

public class CoinChange {

	public static int minCoins(int[] coins, int sum) {
		int[] dp = new int[sum + 1];

		// Initialize all dp values to a large number
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0; // Base case: 0 coins to make sum 0

		// Compute minimum coins for all sums from 1 to sum
		for (int i = 1; i <= sum; i++) {
			for (int coin : coins) {
				if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}

		return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
	}

	public static void main(String[] args) {
		int[] coins1 = { 25, 10, 5 };
		int sum1 = 30;
		System.out.println(minCoins(coins1, sum1)); // Output: 2

		int[] coins2 = { 9, 6, 5, 1 };
		int sum2 = 19;
		System.out.println(minCoins(coins2, sum2)); // Output: 3

		int[] coins3 = { 5, 1 };
		int sum3 = 0;
		System.out.println(minCoins(coins3, sum3)); // Output: 0

		int[] coins4 = { 4, 6, 2 };
		int sum4 = 5;
		System.out.println(minCoins(coins4, sum4)); // Output: -1
	}
}
