package com.thoughtworks.assignment.parser;

import com.thoughtworks.assignment.beans.CurrencyMappping;
import com.thoughtworks.assignment.constants.MerchantConstants;
import com.thoughtworks.assignment.exception.InvalidInputException;

/**
 * The Class UnknownElementValueCalculator to calculate the value of new element
 * in the input.
 */
public class UnknownElementValueCalculator {

	/**
	 * Calculate unknown element value.
	 * 
	 * @param currencyMapping
	 *            the currency mappping
	 * @throws InvalidInputException
	 *             the invalid input exception
	 */
	public static void calculateUnknownElementValue(CurrencyMappping currencyMapping) throws InvalidInputException {

		for (String line : currencyMapping.getUnknownElements()) {
			parseNewElementLine(line, currencyMapping);
		}
	}

	/**
	 * Parses the new element line.
	 * 
	 * @param query
	 *            the query
	 * @param currencyMapping
	 *            the currency mapping
	 * @throws InvalidInputException
	 *             the invalid input exception
	 */
	private static void parseNewElementLine(String query, CurrencyMappping currencyMapping)
			throws InvalidInputException {
		String array[] = query.split(" ");
		int splitIndex = 0;
		int creditValue = 0;
		String element = null;
		String[] valueofElement = null;
		// process known symbols till credits
		for (int i = 0; i < array.length; i++) {
			if (array[i].toLowerCase().equals(MerchantConstants.CREDITS)) {
				creditValue = Integer.parseInt(array[i - 1]);
			}
			if (array[i].toLowerCase().equals(MerchantConstants.IS)) {
				splitIndex = i - 1;
				element = array[i - 1];
			}
			valueofElement = java.util.Arrays.copyOfRange(array, 0, splitIndex);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int j = 0; j < valueofElement.length; j++) {
			if (currencyMapping.getElementToRoman().get(valueofElement[j].toLowerCase()) != null) {
				stringBuilder.append(currencyMapping.getElementToRoman().get(valueofElement[j].toLowerCase()));
			} else {
				throw new InvalidInputException(MerchantConstants.ERROR_MESSAGE_FOR_UNDEFINED_ELEMENT);
			}
		}
		RomanToDecimal romanToDecimal = new RomanToDecimal(currencyMapping);
		// Get integer value of given expression
		float valueOfElementInDecimal = romanToDecimal.romanToDecimal(stringBuilder.toString());
		// Unknown value will be found by diving integer value from total
		// credit.
		currencyMapping.getElementToInterger().put(element.toLowerCase(), creditValue / valueOfElementInDecimal);
	}
}
