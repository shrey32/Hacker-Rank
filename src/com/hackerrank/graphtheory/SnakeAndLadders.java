package src.com.hackerrank.graphtheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**Problem Statement

 Markov takes out his Snakes and Ladders game and stares at the board, and wonders: If he had absolute control on the die, and could get it to generate any number (in the range 1-6) he desired, what would be the least number of rolls of the die in which he'd be able to reach the destination square (Square Number 100) after having started at the base square (Square Number 1)?

 Snakes And Ladders Board

 Rules

 Markov has total control over the die and the face which shows up every time he tosses it. You need to help him figure out the minimum number of moves in which he can reach the target square (100) after starting at the base (Square 1).

 A die roll which would cause the player to land up at a square greater than 100, goes wasted, and the player remains at his original square. Such as a case when the player is at Square Number 99, rolls the die, and ends up with a 5.

 If a person reaches a square which is the base of a ladder, (s)he has to climb up that ladder, and he cannot come down on it. If a person reaches a square which has the mouth of the snake, (s)he has to go down the snake and come out through the tail - there is no way to climb down a ladder or to go up through a snake.

 Input Format

 The first line contains the number of tests, T. T testcases follow.

 For each testcase, there are 3 lines.

 The first line contains the number of ladders and snakes, separated by a comma. 
 The second is a list of comma separated pairs indicating the starting and ending squares of the ladders. The first point is the square from which a player can ascend and the second point is his final position. 
 The third is a list of comma separated pairs indicating the starting and ending (mouth and tail) squares of the snakes. the first point is the position of the mouth of the snake and the second one is the tail. 
 Multiple comma separated pairs of snakes and ladders are separated by a single space.

 Constraints 
 The board is always of the size 10 x 10 
 1 <= T <= 10 
 1 <= Number of Snakes <= 15 
 1 <= Number of Ladders <= 15 
 Squares are always numbered 1 to 100 and the order can be seen in the image above.

 Output Format

 For each of the T test cases, output one integer, each of a new line, which is the least number of moves (or rolls of the die) in which the player can reach the target square (Square Number 100) after starting at the base (Square Number 1). This corresponds to the ideal sequence of faces which show up when the die is rolled.

 Sample Input

 3
 3,7
 32,62 42,68 12,98
 95,13 97,25 93,37 79,27 75,19 49,47 67,17
 5,8
 32,62 44,66 22,58 34,60 2,90
 85,7 63,31 87,13 75,11 89,33 57,5 71,15 55,25
 4,9
 8,52 6,80 26,42 2,72
 51,19 39,11 37,29 81,3 59,5 79,23 53,7 43,33 77,21
 Sample Output

 3
 3
 5
 Explanation

 For the first test: To traverse the board via the shortest route, the player first rolls the die to get a 5, and ends up at square 6. He then rolls the die to get 6. He ends up at square 12, from where he climbs the ladder to square 98. He then rolls the die to get '2', and ends up at square 100, which is the target square. So, the player required 3 rolls of the die for this shortest and best case scenario. So the answer for the first test is 3.

 For the second test: Rolls the die to get 1, reaches square 2. Then, climbs the ladder to square 90. Rolls the die to get 4, reaches square 94. Rolls the die to get 6, reaches square 100, which is the target square. So the answer for the second test is also 3. */

/**
 * @author Shrey
 *
 */
public class SnakeAndLadders {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String sl = br.readLine();
				int l = Integer.parseInt(sl.split(",")[0]);
				int s = Integer.parseInt(sl.split(",")[1]);
				List<KeyVal> ladders = new ArrayList<KeyVal>();
				List<KeyVal> snakes = new ArrayList<KeyVal>();
				String l1 = br.readLine();
				String s1 = br.readLine();
				String[] lArr = l1.split(" ");
				String[] sArr = s1.split(" ");
				for (int j = 0; j < lArr.length; j++) {
					String[] a1 = lArr[j].split(",");
					int a = Integer.parseInt(a1[0]);
					int b = Integer.parseInt(a1[1]);
					KeyVal k = new KeyVal();
					k.setKey(a);
					k.setValue(b);
					ladders.add(k);
				}
				for (int j = 0; j < sArr.length; j++) {
					String[] a1 = sArr[j].split(",");
					int a = Integer.parseInt(a1[0]);
					int b = Integer.parseInt(a1[1]);
					KeyVal k = new KeyVal();
					k.setKey(a);
					k.setValue(b);
					snakes.add(k);
				}
				System.out.println(noOfMoves(ladders, snakes));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class KeyVal implements Comparator<KeyVal>, Comparable<KeyVal> {
		private int key, value;

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public int compare(KeyVal o1, KeyVal o2) {
			return (o1).compareTo(o2);
		}

		@Override
		public int compareTo(KeyVal k) {
			return (this.value - this.key) - (k.value - k.key);
		}
	}

	private static int noOfMoves(List<KeyVal> ladders, List<KeyVal> snakes) {
		Collections.sort(ladders);
		Collections.sort(snakes);
		int count = 0;
		int curr = 0;
		int currKey = 0;
		int i = ladders.size() - 1;
		while (curr != 100) {
			if (i >= 0) {
				int a = ladders.get(i).getValue();
				if ((curr + a) < 100) {
					currKey = ladders.get(i).getKey();
					curr = ladders.get(i).getValue();

					if (100 - curr > 0 && 100 - curr <= 100) {
						if (currKey <= 6) {
							count++;
							if (curr == 100) {
								break;
							}
						} else {
							count += moves(currKey);
							if (curr == 100) {
								break;
							}
						}
					} else {
						int diff = 100 - curr;
						if (diff <= 6 && curr != 100) {
							count++;
						} else {
							count += moves(diff);
						}
						curr += diff;
					}
				} else {
					int diff = 100 - curr;
					if (diff <= 6 && curr != 100) {
						count++;
					} else {
						count += moves(diff);
					}
					curr += diff;
				}
				i--;
			} else {
				int diff = 100 - curr;
				if (diff <= 6 && curr != 100) {
					count++;
				} else {
					count += moves(diff);
				}
				curr += diff;
			}
		}
		return count;
	}

	private static int moves(int val) {
		int rem = 0;
		if (val % 6 == 0) {
			return val / 6;
		} else {
			val = val / 6;
			rem += val + 1;
		}
		return rem;
	}

}