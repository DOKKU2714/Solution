import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		solution4();
	}

/*
 * n x m 형태의 카드에서 각 행n마다 가장 작은 수를 선택하고,
 * 그 수 들중에서 가장 큰 수를 반환
 * 성공 25분 소요
 * */

	private static void solution3() {
		Scanner scanner = new Scanner(System.in);

		int row = 0;
		int column = 0;

		String input = scanner.nextLine();

		row = Integer.parseInt(input.split(" ")[0]);
		column = Integer.parseInt(input.split(" ")[1]);

		ArrayList<String> inputList = new ArrayList<>();

		int[] rowMinArr = new int[row];

		int min = 0;
		for (int i = 0 ; i < row ; i++) {
			inputList.add(scanner.nextLine());
			int[] input2Arr = new int[column];
			for (int j = 0 ; j < column ; j++) {
				input2Arr[j] = Integer.parseInt(inputList.get(i).split(" ")[j]);
			}
			Arrays.sort(input2Arr);
			rowMinArr[i] = input2Arr[0];
		}
		Arrays.sort(rowMinArr);
		System.out.println(rowMinArr[column-1]);

	}

	/*
	 * 주어진 수 n이 1이 될때까지 1씩 빼거나 k로 나누어서 1을 만들면된다. 이때 가장 빠른 횟수는?
	 * (n이 k에 나누어 떨어질때만 나눌 수 있따.)
	 * 성공 7분 소요
	 * */
	private static void solution4() {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		int n = Integer.parseInt(input.split(" ")[0]);
		int k = Integer.parseInt(input.split(" ")[1]);

		int count = 0;

		while(true) {
			if (n % k == 0) {
				n /= k;
			} else {
				n--;
			}
			count++;

			if (n == 1) {
				break;
			}
		}
		System.out.println(count);
	}
}
