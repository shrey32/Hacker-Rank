package com.hackerrank.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement

 The city of Hackerland has formed a new football club and wants to participate in the upcoming Football League of their country. The coach is worried that they will not be able to qualify because they don't have a famous footballer in their team. The assistant coach suggests that the team should buy Cristiano Ronaldo as he can single-handedly get their team qualified.

 On day 1, today, the club has to pay 'A' HackerCoins in order to buy Ronaldo. After each passing day, the price of buying Ronaldo becomes A times the price on the previous day. Any normal person would buy him on the 1st day itself as the price will be the lowest but since the coach always failed in high school Mathematics, he wants 'B' days to think before making him an offer.

 As the coach doesn't know how to calculate the price of Ronaldo on the Bth day, he has asked for your help.

 Your task is to tell the price of Ronaldo on the Bth day. Since, the price can be a very large number, please tell him the price modulo 109 + 7.

 Input Format 
 The first line contains an integer T, the number of testcases. It's followed by T lines. 
 Each testcase will contain two integers A & B separated by a space.

 Output Format 
 Output T lines, each corresponding to the answer of the testcase.

 Constraints 
 1 <= T <= 10 
 1 <= A,B <= 10100000 
 A % (109 + 7) != 0

 Note 
 Both integers will have a maximum of 100000 digits.

 Sample Input #00:

 5
 3 2
 4 5
 7 4
 34534985349875439875439875349875 93475349759384754395743975349573495
 34543987529435983745230948023948 3498573497543987543985743989120393097595572309482304
 Sample Output #00:

 9
 1024
 2401
 735851262
 985546465
 Explanation #00:

 As value of 32 = 9, So output for first case will be 9. 
 Similarly 45 modulo (109 + 7) = 1024 
 Similarly 74 modulo (109 + 7) = 2401 
 Similarly we can do for others.
 */
/**
 * 
 * @author Shrey
 *
 */
public class PowerOfLargeNumbers {

	private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(Byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] temp = br.readLine().split(" ");
            byte[] A = strToBigInt(temp[0]);
            byte[] B = strToBigInt(temp[1]);
            temp = null;
            int Am = bigIntModInt(A, MOD);
            int Bm = bigIntModInt(B, MOD - 1);
            int C = pow(Am, Bm, MOD);
            sb.append(C + "\n");
        }
        System.out.print(sb);
    }
    private static byte[] strToBigInt(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        byte[] bytes = new byte[n];
        for(int i = 0; i < n; ++i){
            bytes[i] = (byte)(chars[i] - '0');
        }
        return bytes;
    }
    private static int bigIntModInt(byte[] ar, int mod){
        int n = ar.length;
        long r = ar[0] % mod;
        for(int i = 1; i < n; r = (10*r + ar[i++]) % mod){}
        return (int)r;
    }
    private static int pow(int A, int B, int M){
        if (B < 2){
            return (B < 1) ? 1 : A % M;
        }
        long C = pow(A, B>>1, M);
        C = (C*C) % M;
        return ((B&1) == 0) ? (int)C : (int)((C*A)%M);
    }
}
