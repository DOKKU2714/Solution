import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		solution115page(sc.nextLine());
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


	private static void solution4_1() {
		Scanner scanner = new Scanner(System.in);

		int area = Integer.parseInt(scanner.nextLine());
		String str = scanner.nextLine();

		int[][] areaArr = new int[area+1][area+1];
		String[] strArr = str.split(" ");

		int row = 1;
		int column = 1;

		//R R U D

		for (int i = 0 ; i < strArr.length ; i++) {
			switch (strArr[i]) {
				case "R":
					row++;
					break;
				case "L":
					row = row > 1 ? --row : 1;
					break;
				case "U":
					column = column > 1 ? --column : 1;
					break;
				case "D":
					column++;
					break;
			}
		}

		System.out.println(column+" "+row);
	}

	private static void solution4_2(int hour) {
		int count = 0;

		for (int x = 0 ; x <= hour ; x++) {
			for (int i = 0 ; i < 60 ; i++) {
				for (int j = 0 ; j < 60 ; j++) {
					String jnum = j+"";
					String inum = i+"";
					String xnum = x+"";
					if (jnum.contains("3") || inum.contains("3") || xnum.contains("3")) {
						count ++;
					}
				}
			}
		}

		System.out.println(count);
	}

	private static void solution115page(String position) {
		int[][] area = new int[8][8];
		int[][] canStep = {{1, 2}, {1,-2},{-1,2}, {-1,-2},{2,1},{2,-1},{-2,1}, {-2,-1}};

		int x = (int)((position.substring(0,1).toUpperCase()).charAt(0)-64)-1;
		int y = Integer.parseInt(position.substring(1,2))-1;

		int count = 0;

		for (int i = 0 ; i < 8 ; i++) {

			if ((x+canStep[i][0] > -1 && x+canStep[i][0] < 8)
					&& (y+canStep[i][1] > -1 && y+canStep[i][1] < 8)) {
				count++;
			}
		}

		System.out.println(count);
 	}

	private static void solution118page(String mapSize, String location, String[] map) {
		//현재 위치에서 왼쪽 90방향부터 갈 곳 정함
		//캐릭터의 왼쪽에 가보지 않은 칸 있으면 회전 후 한칸 전진함 가보지 않은 칸이 없으면 그냥 회전만하고 끝
		// 네 방향 모두 가본 칸이거나 바다면 바라보는 방향 유지 후 한칸 뒤로가고 다시 회전함
		//근데 뒤 방향이 바다인경우 움직임 멈추고 끝

		int x = Integer.parseInt(mapSize.split(" ")[0]);
		int y = Integer.parseInt(mapSize.split(" ")[1]);

		int[][] mapArr = new int[x][y];

		int locationX = Integer.parseInt(location.split(" ")[0]);
		int locationY = Integer.parseInt(location.split(" ")[1]);
		int look = Integer.parseInt(location.split(" ")[2]);

		mapArr[locationX][locationY] = 3;




	}
}
