package com.thoughtworks.assignment.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.thoughtworks.assignment.beans.CurrencyMappping;
import com.thoughtworks.assignment.constants.MerchantConstants;

/**
 * The Class InputParser to read input from file and parse it to corresponding
 * list and maps.
 */
public class InputParser {

	/**
	 * Read file.
	 * 
	 * @param filePath
	 *            the file path
	 * @param currencyMappping
	 *            the currency mappping bean with values
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void readFile(String filePath, CurrencyMappping currencyMappping) throws IOException {
		if (filePath == null) {
			System.out.println(MerchantConstants.FILE_PATH_NULL);
			return;
		} else if (currencyMappping == null) {
			System.out.println(MerchantConstants.BEAN_IS_NULL);
			return;
		} else {
			try {
				FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = bufferedReader.readLine();
				// read input from file line by line
				while (line != null) {
					parseLine(line, currencyMappping);
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Parses the line from file and add it to corresponding list or map.
	 * 
	 * @param line
	 *            the line
	 * @param currencyMappping
	 *            the currency mappping
	 */
	private static void parseLine(String line, CurrencyMappping currencyMappping) {
		String arr[] = line.split(" ");
		// add to questions if it ends with '?'
		if (line.endsWith(MerchantConstants.QUESTION_MARK)) {
			currencyMappping.getQuestions().add(line);
			// add to new elements if given line with 'is' is middle element
		} else if (arr.length == 3 && arr[1].equalsIgnoreCase(MerchantConstants.IS)) {
			currencyMappping.getElementToRoman().put(arr[0].toLowerCase(), arr[2]);
			// add rest to unknown values to find unknown element values
		} else if (line.toLowerCase().endsWith(MerchantConstants.CREDITS)) {
			currencyMappping.getUnknownElements().add(line);
		}

	}

}
