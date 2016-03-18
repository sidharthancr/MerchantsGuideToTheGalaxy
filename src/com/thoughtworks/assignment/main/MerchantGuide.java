package com.thoughtworks.assignment.main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.thoughtworks.assignment.beans.CurrencyMappping;
import com.thoughtworks.assignment.constants.MerchantConstants;
import com.thoughtworks.assignment.exception.InvalidInputException;
import com.thoughtworks.assignment.parser.InputParser;
import com.thoughtworks.assignment.parser.MerchantCalculator;
import com.thoughtworks.assignment.parser.UnknownElementValueCalculator;

/**
 * The Class MerchantGuide to read input data from file and create output for
 * questions in input.
 */
public class MerchantGuide {

	/**
	 * 
	 * The main method to execute Merchant guide project.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InvalidInputException
	 */
	public static void main(String[] args) throws IOException, InvalidInputException {
		Scanner scan = new Scanner(System.in);
		System.out.println(MerchantConstants.ENTER_FILE_NAME);
		// Get file path as input to scan input
		String filePath = scan.next();
		scan.close();
		CurrencyMappping currencyMappping = new CurrencyMappping();
		// Read input from file and populate currency mapping bean
		InputParser.readFile(filePath, currencyMappping);
		// Parse the line with new element with unknown value
		UnknownElementValueCalculator.calculateUnknownElementValue(currencyMappping);
		// Process the question and create answers and put the answers in o
		// answers list in currency mapping bean.
		MerchantCalculator.calculateValues(currencyMappping);
		List<String> ListOfAnswers = currencyMappping.getAnswers();
		// Iterate and print the answers
		for (String answers : ListOfAnswers) {
			System.out.println(answers);
		}

	}

}
