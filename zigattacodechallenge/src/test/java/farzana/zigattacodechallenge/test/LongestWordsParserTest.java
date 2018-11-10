/**
 * 
 */
package farzana.zigattacodechallenge.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import farzana.zigattacodechallenge.LongestWordResult;
import farzana.zigattacodechallenge.LongestWordsParser;

/**
 * @author User10K
 *
 */
public class LongestWordsParserTest {

	private LongestWordsParser longestWordSearcher;

	@BeforeMethod
	public void beforeMethod() {
		longestWordSearcher = new LongestWordsParser();
	}

	/**
	 * 
	 * @param testData
	 */
	@Test(dataProvider = "longestWordsDataProvider")
	public void test_Longest_Words(LongestWordTestModel testData) {
		
		// Invoking the method under test and holding the result for later check 
		LongestWordResult actual = longestWordSearcher.findLongestWords(testData.givenText);

		// Checking for longest length 
		Assert.assertEquals(actual.longestLength, testData.expectedLongestLength, testData.assertionErrorMessage);
		
		// Checking for longest words count 
		Assert.assertEquals(actual.longestWords.size(), testData.expectedLongestWords.length, testData.assertionErrorMessage);
		
		// Checking for every individual longest word 
		for	(int i=0; i < testData.expectedLongestWords.length; i++) {
			Assert.assertEquals(actual.longestWords.get(i), testData.expectedLongestWords[i], testData.assertionErrorMessage);
		}
	}

	@DataProvider(name = "longestWordsDataProvider")
	public Object[] longestWordsDataProvider() {
		// Usually these data come from external source (excel or text file).
		// For simplicity, hard coded values used here.
		return new Object[] { 
		   new LongestWordTestModel() {
			{
				givenText = "";
				expectedLongestLength = 0;
				expectedLongestWords = new String[0];
				assertionErrorMessage = "Case-1: Check with empty string";
			}
		}, new LongestWordTestModel() {
			{
				givenText = " ";
				expectedLongestLength = 0;
				expectedLongestWords = new String[0];
				assertionErrorMessage = "Case-2: Check with single white space";
			}
		}, new LongestWordTestModel() {
			{
				givenText = "The cow jumped over the moon";
				expectedLongestLength = 6;
				expectedLongestWords = new String[] { "jumped" };
				assertionErrorMessage = "Case-3: Check with only one longest word";
			}
		}, new LongestWordTestModel() {
			{
				givenText = "A";
				expectedLongestLength = 1;
				expectedLongestWords = new String[] { "A"};
				assertionErrorMessage = "Case-4: Check with only one length one longest word";
			}
		}, new LongestWordTestModel() {
			{
				givenText = "C k m";
				expectedLongestLength = 1;
				expectedLongestWords = new String[] { "C", "k", "m" };
				assertionErrorMessage = "Case-5: Check with only one length multiple longest word";
			}
		}, new LongestWordTestModel() {
			{
				givenText = "Mohona is the best person";
				expectedLongestLength = 6;
				expectedLongestWords = new String[] { "Mohona", "person" };
				assertionErrorMessage = "Case-6: Check with two longest words";
			}
		}, new LongestWordTestModel() {
			{
				givenText = "Mohona is Mohona";
				expectedLongestLength = 6;
				expectedLongestWords = new String[] { "Mohona" };
				assertionErrorMessage = "Case-7: Check with two longest same word";
			}
		} };
	}

	
}
