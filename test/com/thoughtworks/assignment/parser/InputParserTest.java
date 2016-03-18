package com.thoughtworks.assignment.parser;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.thoughtworks.assignment.beans.CurrencyMappping;
/** The Class InputParserTest tests input parser file.*/
public class InputParserTest {

	@Test
	public void testReadFile() {
		CurrencyMappping currencyMappping = new CurrencyMappping();
		try {
			InputParser.readFile("resource/input1.txt", currencyMappping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("I", currencyMappping.getElementToRoman().get("glob"));
		Assert.assertTrue(currencyMappping.getUnknownElements().contains("glob glob Silver is 34 Credits"));
		Assert.assertEquals(5, currencyMappping.getQuestions().size());
		Assert.assertFalse(currencyMappping.getAnswers().contains("glob glob Silver is 34 Credits"));
	}
}
