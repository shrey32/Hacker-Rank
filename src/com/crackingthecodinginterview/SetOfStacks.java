package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class SetOfStacks {

	private List<List<Integer>> stacks;
	private int maxSize = 0;

	public SetOfStacks(int maxSize) {
		stacks = new ArrayList<>();
		List<Integer> stack = new ArrayList<>(maxSize);
		stacks.add(stack);
		this.maxSize = maxSize;
	}

	/**
	 * 
	 * @param item
	 */
	public void push(int item) {
		int size = stacks.size();
		if (stacks.get(size - 1).size() == maxSize) {
			List<Integer> stack = new ArrayList<>(maxSize);
			stacks.add(stack);
		}
		size = stacks.size();
		List<Integer> stack = stacks.get(size - 1);
		stack.add(item);
	}

	/**
	 * 
	 * @return
	 */
	public Integer pop() {
		int size = stacks.size();
		List<Integer> stack = stacks.get(size - 1);
		int subSize = stack.size();
		int returnVal = stack.get(subSize - 1);
		stack.remove(subSize - 1);
		if (stack.size() == 0)
			stacks.remove(size - 1);
		return returnVal;
	}

	/**
	 * 
	 * @return
	 */
	public Integer peek() {
		int size = stacks.size();
		List<Integer> stack = stacks.get(size - 1);
		int subSize = stack.size();
		return stack.get(subSize - 1);
	}

	/**
	 * 
	 * @param subStackIndex
	 * @return
	 */
	public Integer pop(int subStackIndex) {
		int size = stacks.size();
		if (subStackIndex < 0 || subStackIndex >= size)
			throw new RuntimeException("Sub Stack Index is too high or too low");
		List<Integer> stack = stacks.get(subStackIndex);
		int subSize = stack.size();
		int returnVal = stack.get(subSize - 1);
		stack.remove(subSize - 1);
		if (stack.size() == 0)
			stacks.remove(subStackIndex);
		else {// shift
			shift(subStackIndex);
		}
		return returnVal;
	}

	public void shift(int subStackIndex) {
		List<Integer> stack = stacks.get(subStackIndex);
		while (stack.size() != maxSize && subStackIndex + 1 < stacks.size()) {
			List<Integer> nextStack = stacks.get(subStackIndex + 1);
			if (!nextStack.isEmpty()) {
				stack.add(nextStack.get(0));
				nextStack.remove(0);
				if (nextStack.isEmpty())
					stacks.remove(subStackIndex + 1);
				stack = nextStack;
				subStackIndex++;
			}
		}
	}

	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks(3);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);// [1,2,3][4,5,6]
		System.out.println("Peek =>" + stacks.peek());// [6]
		System.out.println("Peek =>" + stacks.pop());// 3 [1,2,3][4,5]
		System.out.println("Peek =>" + stacks.pop(0));// 3 [1,2,4][5]
		print(stacks.stacks);
		System.out.println("Peek =>" + stacks.pop(0));// 3 [1,2,4][5]
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);
		print(stacks.stacks);
	}

	private static void print(List<List<Integer>> stacks) {
		for (List<Integer> st : stacks)
			System.out.println(st);
		System.out.println();
	}

}
