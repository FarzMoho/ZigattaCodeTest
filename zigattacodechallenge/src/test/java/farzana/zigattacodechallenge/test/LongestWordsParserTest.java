/**
 * 
 */
package farzana.zigattacodechallenge.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import farzana.zigattacodechallenge.LongestWordResultPOJO;
import farzana.zigattacodechallenge.LongestWordsParser;

/**
 * @author Farzana Mohona: create a test class to write test cases and this
 *         class will test the LongestWordsParser class by providing different
 *         data through DataProvider.
 */
public class LongestWordsParserTest {

	private LongestWordsParser longestWordSearcher;

	@BeforeMethod
	public void initializeLongestWordsParserClass() {
		longestWordSearcher = new LongestWordsParser();
	}

	/**
	 * This function test a text for longest length words
	 * 
	 * @param testData; whose data type is LongestWordTestPOJO class and it's values
	 *        are coming from testNG DataPRovider
	 * @Test a testNG annotation, which defines a method as a part of the test.
	 * @param dataProvider; The name of the data provider for this test method
	 */
	@Test(dataProvider = "longestWordsDataProvider")
	public void test_Longest_Words(LongestWordTestPOJO testData) {

		// Invoking the method under test and holding the result for later check
		LongestWordResultPOJO actual = longestWordSearcher.findLongestWords(testData.givenText);

		// Checking for longest length
		Assert.assertEquals(actual.longestLength, testData.expectedLongestLength, testData.assertionErrorMessage);

		// Checking for longest words count
		Assert.assertEquals(actual.longestWords.size(), testData.expectedLongestWords.length,
				testData.assertionErrorMessage);

		// Checking for every individual longest word
		for (int i = 0; i < testData.expectedLongestWords.length; i++) {
			Assert.assertEquals(actual.longestWords.get(i), testData.expectedLongestWords[i],
					testData.assertionErrorMessage);
		}
	}

	/**
	 * @DataProvider Mark a method as supplying data for a test method.
	 * @name The name of this DataProvider.
	 * @return an Object[] where eachObject[] can be assigned the parameter list of
	 *         the test method.
	 */
	@DataProvider(name = "longestWordsDataProvider")
	public Object[] longestWordsDataProvider() {
		// Usually these data come from external source (excel or text file).
		// For simplicity, hard coded values used here.
		return new Object[] { 
		  new LongestWordTestPOJO() {
			{
				givenText = "";
				expectedLongestLength = 0;
				expectedLongestWords = new String[0];
				assertionErrorMessage = "Case-1: Check with empty string";
			}
		}, new LongestWordTestPOJO() {
			{
				givenText = " ";
				expectedLongestLength = 0;
				expectedLongestWords = new String[0];
				assertionErrorMessage = "Case-2: Check with single white space";
			}
		}, new LongestWordTestPOJO() {
			{
				givenText = "The cow jumped over the moon";
				expectedLongestLength = 6;
				expectedLongestWords = new String[] { "jumped" };
				assertionErrorMessage = "Case-3: Check with only one longest word";
			}
		}, new LongestWordTestPOJO() {
			{
				givenText = "A";
				expectedLongestLength = 1;
				expectedLongestWords = new String[] { "A" };
				assertionErrorMessage = "Case-4: Check with only one length one longest word";
			}
		}, new LongestWordTestPOJO() {
			{
				givenText = "C k m";
				expectedLongestLength = 1;
				expectedLongestWords = new String[] { "C", "k", "m" };
				assertionErrorMessage = "Case-5: Check with only one length multiple longest word";
			}
		}, new LongestWordTestPOJO() {
			{
				givenText = "Mohona is the best person";
				expectedLongestLength = 6;
				expectedLongestWords = new String[] { "Mohona", "person" };
				assertionErrorMessage = "Case-6: Check with two longest words";
			}
		}, new LongestWordTestPOJO() {
			{
				givenText = "Mohona is Mohona";
				expectedLongestLength = 6;
				expectedLongestWords = new String[] { "Mohona" };
				assertionErrorMessage = "Case-7: Check with two longest same word";
			}
		} };
	}

}
