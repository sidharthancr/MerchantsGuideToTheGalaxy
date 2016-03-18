package com.thoughtworks.assignment.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.assignment.beans.CurrencyMappping;
import com.thoughtworks.assignment.constants.MerchantConstants;
import com.thoughtworks.assignment.exception.InvalidInputException;

/**
 * The Class RomanToDecimal to convert roman to interger value of the
 * expression.
 */
public class RomanToDecimal {

	/** The non repeatable romans list. */
	private final List<Character> nonRepeatableRomans;

	/** The repeatable romans list. */
	private final List<Character> repeatableRomans;

	/** The currency mappping variable. */
	private CurrencyMappping currencyMapping;

	/** The repeatable romans count map. */
	private Map<Character, Integer> repeatableRomansCount;

	/** The non repeatable romans count map. */
	private Map<Character, Integer> nonRepeatableRomansCount;

	/**
	 * Constructor to instantiates a new roman to decimal object and put initial
	 * values to repeatable and non repeatable elements maps.
	 * 
	 * @param currencyMapping
	 *            the currency mappping
	 */
	public RomanToDecimal(CurrencyMappping currencyMapping) {
		repeatableRomans = new ArrayList<Character>();
		nonRepeatableRomans = new ArrayList<Character>();
		nonRepeatableRomansCount = new HashMap<Character, Integer>();
		repeatableRomansCount = new HashMap<Character, Integer>();
		repeatableRomansCount.put('I', 0);
		repeatableRomansCount.put('X', 0);
		repeatableRomansCount.put('C', 0);
		repeatableRomansCount.put('M', 0);
		nonRepeatableRomansCount.put('V', 0);
		nonRepeatableRomansCount.put('L', 0);
		nonRepeatableRomansCount.put('D', 0);
		nonRepeatableRomans.add('D');
		nonRepeatableRomans.add('L');
		nonRepeatableRomans.add('V');
		repeatableRomans.add('I');
		repeatableRomans.add('V');
		repeatableRomans.add('X');
		repeatableRomans.add('M');
		this.currencyMapping = currencyMapping;
	}

	/**
	 * Roman to decimal converter.
	 * 
	 * @param inputRomans
	 *            the input romans
	 * @return the int
	 * @throws InvalidInputException
	 *             the invalid input exception
	 */
	public int romanToDecimal(String inputRomans) throws InvalidInputException {
		int total = 0;
		int lastNumber = 0;
		// The process of conversion will be done from last to first
		for (int index = inputRomans.length() - 1; index >= 0; index--) {
			char currentChar = inputRomans.charAt(index);
			int currentRomanToIntValue = currencyMapping.getRomanToInterger().get(currentChar);
			switch (currentChar) {
			case 'M':
				checkRomanRepeatingRules(currentChar);
				total = subtractLogic(currentRomanToIntValue, lastNumber, total);
				break;

			case 'D':
				checkRomanRepeatingRules(currentChar);
				total = subtractLogic(currentRomanToIntValue, lastNumber, total);
				break;

			case 'C':
				checkRomanRepeatingRules(currentChar);
				total = subtractLogic(currentRomanToIntValue, lastNumber, total);
				break;

			case 'L':
				checkRomanRepeatingRules(currentChar);
				total = subtractLogic(currentRomanToIntValue, lastNumber, total);
				break;

			case 'X':
				checkRomanRepeatingRules(currentChar);
				total = subtractLogic(currentRomanToIntValue, lastNumber, total);
				break;

			case 'V':
				checkRomanRepeatingRules(currentChar);
				total = subtractLogic(currentRomanToIntValue, lastNumber, total);
				break;

			case 'I':
				checkRomanRepeatingRules(currentChar);
				total = subtractLogic(currentRomanToIntValue, lastNumber, total);
				break;
			}
			lastNumber = currentRomanToIntValue;
		}

		return total;
	}

	/**
	 * Subtract logic to subtract value if small value precedes large value.
	 * 
	 * @param value
	 *            the value
	 * @param lastNumber
	 *            the last number parsed
	 * @param total
	 *            the total
	 * @return the int
	 */
	private int subtractLogic(int value, int lastNumber, int total) {
		if (lastNumber > value) {
			if (Arrays.asList(this.currencyMapping.getRomanSubtractValuesMapping().get(value)).contains(lastNumber)) {
				return total - value;
			} else {
				return total + value;
			}
		} else {
			return total + value;
		}
	}

	/**
	 * Check roman repeating rules and throws exceptions.
	 * 
	 * @param character
	 *            the character
	 * @return true, if successful
	 * @throws InvalidInputException
	 *             the invalid input exception
	 */
	private boolean checkRomanRepeatingRules(Character character) throws InvalidInputException {
		// non repeatable character should not repeat more than once
		if (nonRepeatableRomans.contains(character)) {
			nonRepeatableRomansCount.put(character, nonRepeatableRomansCount.get(character) + 1);
			if (nonRepeatableRomansCount.containsValue(2)) {
				System.out.println(MerchantConstants.ERROR_MESSAGE_FOR_REPEATING_D_L_V);
				throw new InvalidInputException(MerchantConstants.ERROR_MESSAGE_FOR_REPEATING_D_L_V);
			}
		} else if (repeatableRomans.contains(character)) {
			repeatableRomansCount.put(character, repeatableRomansCount.get(character) + 1);
			// repeatable character should not repeat more than 3
			if (repeatableRomansCount.containsValue(4)) {
				System.out.println(MerchantConstants.ERROR_MESSAGE_FOR_REPEATING_I_X_C_M_MORE_THAN_3_TIMES);
				throw new InvalidInputException(MerchantConstants.ERROR_MESSAGE_FOR_REPEATING_I_X_C_M_MORE_THAN_3_TIMES);
			} else {
				for (Character charc : repeatableRomansCount.keySet()) {
					if (!charc.equals(character)) {
						repeatableRomansCount.put(charc, 0);
					}
				}
			}
		}
		return true;
	}
}
