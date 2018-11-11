package farzana.zigattacodechallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Farzana Mohona: create a class with a method to return the length and
 *         longest words in a sentence. For example, “The cow jumped over the
 *         moon.” should return 6 and “jumped”. 
 *         Assumption: 
 *         - The sentence contains no punctuation 
 *         - The words are separated by single space only
 */
public class LongestWordsParser {

	// Considering word separator as constant throughout the application
	private static final String WORD_SEPARATOR = " "; // use "[.,!?]| " if consider split by punctuation

	/**
	 * This function parse a text for longest length words
	 * 
	 * @param givenString is the given text; the text which is coming from testNG
	 *                    DataProvider annotation
	 * @return LongestWordResult after finding the longest words
	 */
	public LongestWordResultPOJO findLongestWords(String givenString) {

		// split the string into individual words
		String[] allAvailableWords = givenString.split(WORD_SEPARATOR);

		// Initially considering longest length to be zero
		int longestLength = 0;

		// Loop through all the words to get the length of longest word
		for (int i = 0; i < allAvailableWords.length; i++) {
			if (allAvailableWords[i].length() > longestLength) {
				longestLength = allAvailableWords[i].length();
			}
		}

		// Declaring List instead of Array, as we don't know how many words are there with the longest length
		List<String> longestWords = new ArrayList<String>();

		// Now, as we know the longest length, its time to find out all the words with longest length
		for (int i = 0; i < allAvailableWords.length; i++) {
			if (allAvailableWords[i].length() == longestLength // current word has the longest length
					&& longestLength != 0 // current word cannot be empty
					&& !longestWords.contains(allAvailableWords[i]) // We should not add current word if it is already added before
			) {
				longestWords.add(allAvailableWords[i]);
			}
		}

		LongestWordResultPOJO result = new LongestWordResultPOJO();
		result.longestLength = longestLength;
		result.longestWords = longestWords;
		return result;
	}
}
