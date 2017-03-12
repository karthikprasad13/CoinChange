package solutions;
import java.io.FileNotFoundException;

public class Part2 {
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

	public static void main(String[] args) throws FileNotFoundException {
		String path = args[0]; // "src/java/test/input";
		// process the input
		int length = InputProcessor.process(path);
		int[] arr = new int[100];
		System.out.println("Accepted suggestions: ");
		printAllWays(200, 0, arr, length + 1);
	}

	private static void printAllWays(int n, int i, int[] arr, int min) {
		// cut iterations going more than required length
		if (i > min) {
			return;
		}
		// print the found combination
		if (n == 0 && i == min) {
			printArray(arr, i);
		}
		// remove the used coin and recursively find for sub sum
		// complexity O(mn)
		else if (n > 0) {
			int k;
			for (k = coins.length - 1; k >= 0; k--) {
				arr[i] = coins[k];
				printAllWays(n - coins[k], i + 1, arr, min);
			}
		}
	}

	private static void printArray(int[] arr, int size) {
		// dont print if combination is not in sorted order
		// because it would be a duplicate
		for (int i = 0; i < size - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				return;
			}
		}
		// print array
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();

	}

}
