package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Sami's spaceship crashed on Mars! She sends  sequential SOS messages to Earth for help.

 NASA_Mars_Rover.jpg

 Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, , determine how many letters of Sami's SOS have been changed by radiation.

 Input Format

 There is one line of input: a single string, .

 Note: As the original message is just SOS repeated  times, 's length will be a multiple of .

 Constraints

 will contain only uppercase English letters.
 Output Format

 Print the number of letters in Sami's message that were altered by cosmic radiation.

 Sample Input 0

 SOSSPSSQSSOR
 Sample Output 0

 3
 Sample Input 1

 SOSSOT
 Sample Output 1

 1
 Explanation

 Sample 0

 = SOSSPSSQSSOR, and signal length . Sami sent  SOS messages (i.e.: ).

 Expected signal: SOSSOSSOSSOS
 Recieved signal: SOSSPSSQSSOR

 We print the number of changed letters, which is .

 Sample 1

 = SOSSOT, and signal length . Sami sent  SOS messages (i.e.: ).

 Expected Signal: SOSSOS 
 Received Signal: SOSSOT

 We print the number of changed letters, which is.
 */
/**
 * 
 * @author Shrey
 *
 */
public class MarsExploration {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		br.close();
		char sc[] = s.toCharArray();
		int count = 0;
		for (int i = 0; i < sc.length; i += 3) {
			if (sc[i] != 'S')
				count++;
			if (sc[i + 1] != 'O')
				count++;
			if (sc[i + 2] != 'S')
				count++;
		}
		System.out.print(count);
	}

}
