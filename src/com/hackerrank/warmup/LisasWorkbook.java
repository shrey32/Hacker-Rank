package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters.

 There are  chapters in Lisa's workbook, numbered from  to .
 The -th chapter has  problems, numbered from  to .
 Each page can hold up to  problems. There are no empty pages or unnecessary spaces, so only the last page of a chapter may contain fewer than  problems.
 Each new chapter starts on a new page, so a page will never contain problems from more than one chapter.
 The page number indexing starts at .
 Lisa believes a problem to be special if its index (within a chapter) is the same as the page number where it's located. Given the details for Lisa's workbook, can you count its number of special problems?

 Note: See the diagram in the Explanation section for more details.

 Input Format

 The first line contains two integers  and  — the number of chapters and the maximum number of problems per page respectively. 
 The second line contains  integers , where  denotes the number of problems in the -th chapter.

 Constraints

 Output Format

 Print the number of special problems in Lisa's workbook.

 Sample Input

 5 3  
 4 2 6 1 10
 Sample Output

 4
 Explanation

 The diagram below depicts Lisa's workbook with  chapters and a maximum of  problems per page. Special problems are outlined in red, and page numbers are in yellow squares.

 bear_workbook.png

 There are  special problems and thus we print the number  on a new line.
 */
/**
 * 
 * @author Shrey
 *
 */
public class LisasWorkbook {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		int n = Integer.parseInt(line.split(" ")[0]);
		int k = Integer.parseInt(line.split(" ")[1]);
		line = br.readLine().trim();
		String[] problemArray = line.split(" ");
		int specialProblemCount = 0;
		int pageNum = 1;
		for (int i = 0; i < n; i++) {
			int totalProblems = Integer.parseInt(problemArray[i]);
			for (int j = 1, internalCounter = 1; j <= totalProblems; j++, internalCounter++) {
				if (internalCounter > k) {
					internalCounter = 1;
					pageNum++;
				}
				if (j == pageNum)
					specialProblemCount++;
			}
			pageNum++;
		}
		System.out.println(specialProblemCount);
		br.close();
	}
}
