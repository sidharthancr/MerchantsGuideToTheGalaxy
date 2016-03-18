package com.thoughtworks.assignment.parser;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.assignment.beans.CurrencyMappping;
import com.thoughtworks.assignment.constants.MerchantConstants;
import com.thoughtworks.assignment.exception.InvalidInputException;

/** The Class MerchantCalculatorTest tests MerchantCalculator file.*/
public class MerchantCalculatorTest {


	public static CurrencyMappping currencyMappping;

	@Before
	public void initilizeBean() {
		currencyMappping = new CurrencyMappping();
	}
	@Test
	public void testCalculateValues01() {
		try {
			InputParser.readFile("resource/input3.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
			try {
			UnknownElementValueCalculator.calculateUnknownElementValue(currencyMappping);
			MerchantCalculator.calculateValues(currencyMappping);
			Assert.assertTrue(currencyMappping.getAnswers().get(0).equals(MerchantConstants.ERROR_MESSAGE_FOR_UNDEFINED_ELEMENT));
					} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateValues02() {
		try {
			InputParser.readFile("resource/input4.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
			try {
			UnknownElementValueCalculator.calculateUnknownElementValue(currencyMappping);
			MerchantCalculator.calculateValues(currencyMappping);
			System.out.println(currencyMappping.getAnswers().get(0));
			Assert.assertTrue(currencyMappping.getAnswers().get(0).endsWith("42"));
					} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}

}
