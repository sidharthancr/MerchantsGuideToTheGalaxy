package com.thoughtworks.assignment.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class CurrencyMappping is bean class to store all the rules and
 * information about all elements,roman,questions,answer and its mapping.
 */
public class CurrencyMappping {

	/** The roman to interger mapping. */
	private Map<Character, Integer> romanToInterger;

	/** The element to roman mapping. */
	private Map<String, String> elementToRoman;

	/** The element to interger mapping. */
	private Map<String, Float> elementToInterger;

	/** The questions list to store questions. */
	private List<String> questions;

	/** The answers list to store answer. */
	private List<String> answers;

	/** The unknown elements in given input. */
	private List<String> unknownElements;

	/** The roman subtract allowed values mapping . */
	private Map<Integer, Integer[]> romanSubtractValuesMapping;

	/**
	 * Gets the roman subtract values mapping.
	 * 
	 * @return the roman subtract values mapping
	 */
	public Map<Integer, Integer[]> getRomanSubtractValuesMapping() {
		if (this.romanSubtractValuesMapping == null) {
			this.romanSubtractValuesMapping = Collections.unmodifiableMap(new HashMap<Integer, Integer[]>() {
				{
					put(1, new Integer[] { 5, 10 });
					put(5, new Integer[] {});
					put(10, new Integer[] { 50, 100 });
					put(50, new Integer[] {});
					put(100, new Integer[] { 100, 1000 });
					put(500, new Integer[] {});
					put(1000, new Integer[] {});
				}
			});
		}
		return romanSubtractValuesMapping;
	}

	/**
	 * Sets the roman subtract values mapping.
	 * 
	 * @param romanSubtractValuesMapping
	 *            the roman subtract values mapping
	 */
	public void setRomanSubtractValuesMapping(Map<Integer, Integer[]> romanSubtractValuesMapping) {
		this.romanSubtractValuesMapping = romanSubtractValuesMapping;
	}

	/**
	 * Gets the roman to interger.
	 * 
	 * @return the roman to interger
	 */
	public Map<Character, Integer> getRomanToInterger() {
		if (this.romanToInterger == null) {
			this.romanToInterger = Collections.unmodifiableMap(new HashMap<Character, Integer>() {
				{
					put('I', 1);
					put('V', 5);
					put('X', 10);
					put('L', 50);
					put('C', 100);
					put('D', 500);
					put('M', 1000);
				}
			});
		}
		return romanToInterger;
	}

	/**
	 * Gets the element to interger.
	 * 
	 * @return the element to interger
	 */
	public Map<String, Float> getElementToInterger() {
		if (this.elementToInterger == null) {
			this.elementToInterger = new HashMap<String, Float>();
		}
		return elementToInterger;
	}

	/**
	 * Sets the element to interger.
	 * 
	 * @param elementToInterger
	 *            the element to interger
	 */
	public void setElementToInterger(Map<String, Float> elementToInterger) {
		this.elementToInterger = elementToInterger;
	}

	/**
	 * Gets the unknown elements.
	 * 
	 * @return the unknown elements
	 */
	public List<String> getUnknownElements() {
		if (this.unknownElements == null) {
			this.unknownElements = new ArrayList<String>();
		}
		return unknownElements;
	}

	/**
	 * Sets the unknown elements.
	 * 
	 * @param unknownElements
	 *            the new unknown elements
	 */
	public void setUnknownElements(List<String> unknownElements) {
		this.unknownElements = unknownElements;
	}

	/**
	 * Sets the roman to interger.
	 * 
	 * @param romanToInterger
	 *            the roman to interger
	 */
	public void setRomanToInterger(Map<Character, Integer> romanToInterger) {

		this.romanToInterger = romanToInterger;
	}

	/**
	 * Gets the element to roman.
	 * 
	 * @return the element to roman
	 */
	public Map<String, String> getElementToRoman() {
		if (this.elementToRoman == null) {
			this.elementToRoman = new HashMap<String, String>();
		}
		return elementToRoman;
	}

	/**
	 * Sets the element to roman.
	 * 
	 * @param elementToRoman
	 *            the element to roman
	 */
	public void setElementToRoman(Map<String, String> elementToRoman) {
		this.elementToRoman = elementToRoman;
	}

	/**
	 * Gets the questions.
	 * 
	 * @return the questions
	 */
	public List<String> getQuestions() {
		if (this.questions == null) {
			this.questions = new ArrayList<String>();
		}
		return questions;
	}

	/**
	 * Sets the questions.
	 * 
	 * @param questions
	 *            the new questions
	 */
	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

	/**
	 * Gets the answers.
	 * 
	 * @return the answers
	 */
	public List<String> getAnswers() {
		if (this.answers == null) {
			this.answers = new ArrayList<String>();
		}
		return answers;
	}

	/**
	 * Sets the answers.
	 * 
	 * @param answers
	 *            the new answers
	 */
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}
