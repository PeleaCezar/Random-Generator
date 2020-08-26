package randomSTR;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStringMethods {

	private final String alphaNumeric =
"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
* Get a random string of characters. We can use 1 to 50 as the length of the string.
* @param stringOption Enter a number 0 to 4
* @param maxStringLength The length of your random string
* @return a String of random characters
 */	

	String randomString (int stringOption,int maxStringLength) throws IllegalAccessException {
		checkStringLength(maxStringLength);
		checkOptionsNumber(stringOption);
		
		return getRandomString (stringOption,maxStringLength);
	}
	
 /**
 * Get a random string of characters. You can use 1 to 50 as the length of the string.
 * @param stringOption Enter a number 0 to 4
 * @param maxStringLength The length of your random string
 * @param fileExtension The extension to use after the file name
 * @return A string of random characters
 */
	
	String randomString ( int stringOption, int maxStringLength, String fileExtension) throws IllegalAccessException {
	
		checkStringLength ( maxStringLength);
		checkOptionsNumber (stringOption);
		checkFileExtension(fileExtension);
		
		return getRandomString(stringOption,maxStringLength) + "." + fileExtension;
		
	}
	

	private void checkStringLength(int len) throws IllegalAccessException {
	if (len <=0 || len > 50) {
		throw new IllegalAccessException ("Filename length must be greater than 0 and less than 51.");		
	   }
	}
	
	
	
	private void checkOptionsNumber (int opt) throws IllegalAccessException {
		if (opt < 0 || opt > 4 ) //verify case 
		{
			throw new IllegalAccessException("Filename option must be 0 to 4");
		}
	}
	
	private void checkFileExtension (String extension) throws IllegalAccessException {
		if (extension ==  null || extension.trim().isEmpty()) {
			throw new IllegalAccessException ( "File extension can't be blank.");
		}
	}
	
	private String getRandomString (int options,int max) {
		 String ranCharString = "";
		 switch (options) {
		 case 0 : 
		 {
			 ranCharString = generateRandomString (max, 0, 26); //LOWERCASE
			 break;			 
		 }
		 case 1:
		 {
			 ranCharString =generateRandomString(max,26,52); //  UPPERCASE
			 break;
		 }
		 case 2 :
		 {
			 ranCharString = generateRandomString(max,0,52); //LOWERUPPER
			 break;			 
		 }
		 case 3 :
		 {
			 ranCharString = generateRandomString(max,52,62); // NUMBERSONLY
			 break;
		 }
		 case 4:
		 {
			 ranCharString = generateRandomString(max,0,62); //CHARSANDNUMBERS
			 break;
		 }
		 default : 
			 break;
		 }
		 return ranCharString;
	}
	
private String generateRandomString (int stringLength, int minValue, int maxValue) {
	String ranCharString ="";
	for (int init =1; init <= stringLength;init ++) {
		int randomValue =ThreadLocalRandom.current().nextInt(minValue,maxValue);
		
		String ranChar = alphaNumeric.substring(randomValue, randomValue +1);
		ranCharString =ranCharString.concat(ranChar);
	}
	return ranCharString;
}
	
}
