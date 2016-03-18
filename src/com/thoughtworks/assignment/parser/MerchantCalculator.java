package com.thoughtworks.assignment.parser;

import java.util.List;

import com.thoughtworks.assignment.beans.CurrencyMappping;
import com.thoughtworks.assignment.constants.MerchantConstants;
import com.thoughtworks.assignment.exception.InvalidInputException;

/**
 * The Class MerchantCalculator to process questions and create answers for
 * question and add it to answers list.
 */
public class MerchantCalculator {

	/**
	 * Calculate values for given questions.
	 * 
	 * @param currencyMapping
	 *            the currency mapping
	 * @throws InvalidInputException
	 *             the invalid input exception
	 */
	public static void calculateValues(CurrencyMappping currencyMapping) throws InvalidInputException {
		List<String> listOfQuestions = currencyMapping.getQuestions();
		for (String string : listOfQuestions) {
			if (string.toLowerCase().startsWith(MerchantConstants.HOW_MUCH)) {
				string = string.toLowerCase().replace(MerchantConstants.HOW_MUCH_IS, "");
				processQuestion(string, currencyMapping, false);
			} else if (string.toLowerCase().startsWith(MerchantConstants.HOW_MANY)) {
				string = string.toLowerCase().replace(MerchantConstants.HOW_MANY_CREDITS_IS, "");
				processQuestion(string, currencyMapping, true);
			}

		}

	}

	/**
	 * Process question and get corresponding values from currency mapping and
	 * calculate proper value of it.
	 * 
	 * @param question
	 *            the question
	 * @param currencyMapping
	 *            the currency mapping
	 * @param isHowMany
	 *            the is how many
	 * @throws InvalidInputException
	 *             the invalid input exception
	 */
	private static void processQuestion(String question, CurrencyMappping currencyMapping, boolean isHowMany)
			throws InvalidInputException {
		String[] splitString = question.trim().split(" ");
		StringBuilder str = new StringBuilder("");
		String element = null;
		boolean flag = true;
		for (String string : splitString) {
			if (!string.equals(MerchantConstants.QUESTION_MARK) && !string.equalsIgnoreCase(MerchantConstants.IS)
					&& !string.equalsIgnoreCase(MerchantConstants.CREDITS)) {
				if (currencyMapping.getElementToRoman().containsKey(string)) {
					str.append(currencyMapping.getElementToRoman().get(string));
				} else if (currencyMapping.getElementToInterger().keySet().contains(string)) {
					element = string;
				} else {
					// if element in given question is not found in roman and
					// also new elemnts , then it says as its not found.
					currencyMapping.getAnswers().add(MerchantConstants.ERROR_MESSAGE_FOR_UNDEFINED_ELEMENT);
					flag = false;
					break;
				}
			}
		}
		// if some elemts are not found the following lines will be skipped.
		if (flag) {
			RomanToDecimal decimal = new RomanToDecimal(currencyMapping);
			int value;
			if (element == null) {
				value = decimal.romanToDecimal(str.toString());
			} else {
				value = (int) (decimal.romanToDecimal(str.toString()) * currencyMapping.getElementToInterger().get(
						element));
			}
			question = question.replace(MerchantConstants.QUESTION_MARK, "").trim();
			if (isHowMany) {
				currencyMapping.getAnswers()
						.add(question + " " + MerchantConstants.IS + " " + value + " "
								+ MerchantConstants.CREDITS_CAPITAL_C);
			} else {
				currencyMapping.getAnswers().add(question + " " + MerchantConstants.IS + " " + value);
			}

		}
	}
}
