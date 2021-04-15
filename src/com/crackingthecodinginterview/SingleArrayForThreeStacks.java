package com.crackingthecodinginterview;

/**
 * 
 * @author Shrey
 *
 */
public class SingleArrayForThreeStacks {

	private Item[] items;
	private int currIndex = -1;
	private int size = 0;

	public SingleArrayForThreeStacks(int len) {
		this.items = new Item[len];
	}

	/**
	 * 
	 * @param val
	 */
	public void push(int val) {
		if (size + 1 < items.length) {
			if (this.currIndex < 0) { // for very first element
				this.currIndex++;
				this.size++;
			}
			Item currItem = this.items[this.currIndex];
			if (currItem == null) {
				currItem = new Item();
				this.items[this.currIndex] = currItem;

			}
			if (currItem.subItemsCurrIndex + 1 < 3) {
				currItem.subItemsCurrIndex++;
				this.items[this.currIndex].subItems[currItem.subItemsCurrIndex] = val;
			} else {
				this.currIndex++;
				currItem = new Item();
				currItem.subItemsCurrIndex++;
				this.items[this.currIndex] = currItem;
				this.items[this.currIndex].subItems[currItem.subItemsCurrIndex] = val;
				this.size++;
			}
			return;
		}
		throw new RuntimeException("StackOverflow Exception");
	}

	/**
	 * 
	 * @param stackIndex
	 * @return
	 */
	public int pop() {
		if (!this.isEmpty()) {
			Item currItem = this.items[this.currIndex];
			int val = currItem.subItems[currItem.subItemsCurrIndex];
			currItem.subItemsCurrIndex--;
			if (currItem.subItemsCurrIndex < 0) {
				this.items[this.currIndex] = null;
				this.currIndex--;
				this.size--;
			}
			return val;
		}
		throw new RuntimeException("StackUnderflow Exception");
	}

	/**
	 * 
	 * @param stackIndex
	 * @return
	 */
	public int peek() {
		if (!this.isEmpty()) {
			Item currItem = this.items[this.currIndex];
			return currItem.subItems[currItem.subItemsCurrIndex];
		}
		throw new RuntimeException("StackUnderflow Exception");
	}

	public boolean isEmpty() {
		return this.size <= 0;
	}

	public int size() {
		return this.size;
	}

	private static class Item {
		private int[] subItems;
		private int subItemsCurrIndex = -1;

		private Item() {
			subItems = new int[3];
		}
	}

	public static void main(String[] args) {
		SingleArrayForThreeStacks s = new SingleArrayForThreeStacks(5);
		s.push(1);
		s.push(2);
		s.push(3);
		// System.out.println("peek=>" + s.peek());
		s.push(4);
		s.push(5);
		s.push(6);
		// System.out.println("peek=>" + s.peek());
		System.out.println("pop=>" + s.pop());
		s.push(7);
		System.out.println("pop=>" + s.pop());
		System.out.println("pop=>" + s.pop());
		System.out.println("pop=>" + s.pop());
		System.out.println("pop=>" + s.pop());
		System.out.println("pop=>" + s.pop());
		System.out.println("pop=>" + s.pop());
		s.push(1);
		print(s.items);
	}

	private static void print(Item[] items) {
		for (Item i : items) {
			if (i == null) {
				System.out.println("[]");
				continue;
			}
			for (int j = 0; j <= i.subItemsCurrIndex; j++)
				System.out.print(i.subItems[j] + " ");
			System.out.println();
		}
	}

}
