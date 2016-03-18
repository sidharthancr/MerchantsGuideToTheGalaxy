package com.thoughtworks.assignment.parser;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.assignment.beans.CurrencyMappping;
import com.thoughtworks.assignment.exception.InvalidInputException;

/** The Class RomanToDecimalTest tests RomanToDecimal file.*/
public class RomanToDecimalTest {

	public static CurrencyMappping currencyMappping;

	@Before
	public void initilizeBean() {
		currencyMappping = new CurrencyMappping();
	}

	@Test
	public void testRomanToDecimal() {
		try {
			InputParser.readFile("resource/input1.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		RomanToDecimal decimal = new RomanToDecimal(currencyMappping);
		try {
			Assert.assertEquals(2, decimal.romanToDecimal("II"));
			Assert.assertEquals(4, decimal.romanToDecimal("IV"));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = InvalidInputException.class)
	public void testRomanToDecimal1() throws InvalidInputException {
		try {
			InputParser.readFile("resource/input1.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		RomanToDecimal decimal = new RomanToDecimal(currencyMappping);
		Assert.assertEquals(2, decimal.romanToDecimal("IIII"));
	}

	@Test
	public void testRomanToDecimal2() throws InvalidInputException {
		try {
			InputParser.readFile("resource/input1.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		RomanToDecimal decimal = new RomanToDecimal(currencyMappping);
		Assert.assertEquals(20, decimal.romanToDecimal("XX"));
	}

}
