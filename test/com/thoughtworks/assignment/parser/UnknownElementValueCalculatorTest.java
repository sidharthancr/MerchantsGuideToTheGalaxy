package com.thoughtworks.assignment.parser;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.thoughtworks.assignment.beans.CurrencyMappping;
import com.thoughtworks.assignment.exception.InvalidInputException;

/** The class UnknownElementValueCalculatorTest tests use cases in UnknownElementValueCalculator file.*/
public class UnknownElementValueCalculatorTest {

	@Test
	public void testCalculateUnknownElementValue01() throws InvalidInputException {
		CurrencyMappping currencyMappping = new CurrencyMappping();
		try {
			InputParser.readFile("resource/input1.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UnknownElementValueCalculator.calculateUnknownElementValue(currencyMappping);
		Assert.assertEquals(14450.0f, currencyMappping.getElementToInterger().get("gold"));
	}

	@Test
	public void testCalculateUnknownElementValue02() throws InvalidInputException {
		CurrencyMappping currencyMappping = new CurrencyMappping();
		try {
			InputParser.readFile("resource/input2.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UnknownElementValueCalculator.calculateUnknownElementValue(currencyMappping);
		Assert.assertEquals(18.0f, currencyMappping.getElementToInterger().get("silver"));
	}

	@Test(expected = InvalidInputException.class)
	public void testCalculateUnknownElementValue03() throws InvalidInputException {
		CurrencyMappping currencyMappping = new CurrencyMappping();
		try {
			InputParser.readFile("resource/wrongInput2.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UnknownElementValueCalculator.calculateUnknownElementValue(currencyMappping);
	}

	@Test(expected = InvalidInputException.class)
	public void testCalculateUnknownElementValue04() throws InvalidInputException {
		CurrencyMappping currencyMappping = new CurrencyMappping();
		try {
			InputParser.readFile("resource/wrongInput1.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UnknownElementValueCalculator.calculateUnknownElementValue(currencyMappping);
	}

}
