package com.spoj.basics;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * <a href="https://www.spoj.com/problems/SBANK/">SBANK - Sorting Bank
 * Accounts</a>
 * 
 * @author Shrey
 *
 */
public class SortingBankAccounts {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			Map<Account, Integer> map = new TreeMap<>();
			int n = scan.nextInt();
			for (int i = 0; i < n; i++) {
				String a = scan.next();
				String b = scan.next();
				String c = scan.next();
				String d = scan.next();
				String e = scan.next();
				String f = scan.next();
				Account account = new Account(a, b, c, d, e, f);
				map.put(account, map.getOrDefault(account, 0) + 1);
			}
			for (Account account : map.keySet())
				System.out.println(account + " " + map.get(account));
		}
		scan.close();
	}

	private static class Account implements Comparable<Account> {
		String a, b, c, d, e, f;

		public Account(String a, String b, String c, String d, String e, String f) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.f = f;
		}

		@Override
		public String toString() {
			return a + " " + b + " " + c + " " + d + " " + e + " " + f;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			result = prime * result + ((c == null) ? 0 : c.hashCode());
			result = prime * result + ((d == null) ? 0 : d.hashCode());
			result = prime * result + ((e == null) ? 0 : e.hashCode());
			result = prime * result + ((f == null) ? 0 : f.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Account other = (Account) obj;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			if (c == null) {
				if (other.c != null)
					return false;
			} else if (!c.equals(other.c))
				return false;
			if (d == null) {
				if (other.d != null)
					return false;
			} else if (!d.equals(other.d))
				return false;
			if (e == null) {
				if (other.e != null)
					return false;
			} else if (!e.equals(other.e))
				return false;
			if (f == null) {
				if (other.f != null)
					return false;
			} else if (!f.equals(other.f))
				return false;
			return true;
		}

		@Override
		public int compareTo(Account o) {
			if (!this.a.equals(o.a))
				return this.a.compareTo(o.a);
			if (!this.b.equals(o.b))
				return this.b.compareTo(o.b);
			if (!this.c.equals(o.c))
				return this.c.compareTo(o.c);
			if (!this.d.equals(o.d))
				return this.d.compareTo(o.d);
			if (!this.e.equals(o.e))
				return this.e.compareTo(o.e);
			if (!this.f.equals(o.f))
				return this.f.compareTo(o.f);
			return 0;
		}

	}

}
