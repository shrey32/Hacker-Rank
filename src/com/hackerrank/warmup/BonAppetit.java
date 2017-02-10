package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Anna and Brian order  items at a restaurant, but Anna declines to eat any of the  item (where ) due to an allergy. When the check comes, they decide to split the cost of all the items they shared; however, Brian may have forgotten that they didn't split the  item and accidentally charged Anna for it.
 * <p>
 * You are given , , the cost of each of the  items, and the total amount of money that Brian charged Anna for her portion of the bill. If the bill is fairly split, print Bon Appetit; otherwise, print the amount of money that Brian must refund to Anna.
 * <p>
 * Input Format
 * <p>
 * The first line contains two space-separated integers denoting the respective values of  (the number of items ordered) and  (the -based index of the item that Anna did not eat).
 * The second line contains  space-separated integers where each integer  denotes the cost, , of item  (where ).
 * The third line contains an integer, , denoting the amount of money that Brian charged Anna for her share of the bill.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * If Brian did not overcharge Anna, print Bon Appetit on a new line; otherwise, print the difference (i.e., ) that Brian must refund to Anna (it is guaranteed that this will always be an integer).
 * <p>
 * Sample Input 0
 * <p>
 * 4 1
 * 3 10 2 9
 * 12
 * Sample Output 0
 * <p>
 * 5
 * Explanation 0
 * Anna didn't eat item , but she shared the rest of the items with Brian. The total cost of the shared items is  and, split in half, the cost per person is . Brian charged her  for her portion of the bill, which is more than the  dollars worth of food that she actually shared with him. Thus, we print the amount Anna was overcharged, , on a new line.
 * <p>
 * Sample Input 1
 * <p>
 * 4 1
 * 3 10 2 9
 * 7
 * Sample Output 1
 * <p>
 * Bon Appetit
 * Explanation 1
 * Anna didn't eat item , but she shared the rest of the items with Brian. The total cost of the shared items is  and, split in half, the cost per person is . Because this matches the amount, , that Brian charged Anna for her portion of the bill, we print Bon Appetit on a new line.
 * <p>
 * Created by Shrey on 2/10/2017.
 */
public class BonAppetit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int k = Integer.parseInt(line.split(" ")[1]);
        String[] arr = br.readLine().trim().split(" ");
        k = Integer.parseInt(arr[k]);
        int sum = 0;
        for (String s : arr)
            sum += Integer.parseInt(s);
        int bCharged = Integer.parseInt(br.readLine().trim());
        int actual = sum - k;
        int bDifference = Math.abs(bCharged - (actual / 2));
        if (0 == bDifference) {
            System.out.print("Bon Appetit");
        } else {
            System.out.print(bDifference);
        }
        br.close();
    }

}
