package com.greatlearning.dsalab;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input String");
		String input = sc.next();
		if (isValidBalancedString(input))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

	public static boolean isValidBalancedString(String input) {
		// Base Condition
		if (input.length() == 0 || input.length() % 2 != 0)
			return false;

		HashMap<Character, Character> hash = new HashMap<Character, Character>();
		hash.put('(', ')');
		hash.put('[', ']');
		hash.put('{', '}');

		Stack<Character> stack = new Stack<Character>();
		for (char currentCh : input.toCharArray()) {
			if (currentCh == '(' || currentCh == '{' || currentCh == '[') {
				char closingCh = hash.get(currentCh);
				stack.push(closingCh);
			} else if (!stack.isEmpty()) {
				// Definitely opposite char
				char topCh = stack.peek();
				if (topCh == currentCh)
					stack.pop();
				else
					return false;
			} else {
				return false;
			}
		}
		
		return stack.isEmpty();
	}

}
