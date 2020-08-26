package randomSTR;
//Random generator string
public class RandomString {


	enum CharacterOptions { //define enum 
		LOWERCASE (0),
		UPPERCASE (1),
		LOWERUPPER (2),
		NUMBERSONLY (3),
		CHARSANDNUMBERS (4);
		
		public final int val;
		private CharacterOptions (int enumVal) { // define a constructor for a int from parentheses			
			this.val = enumVal;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 RandomStringMethods ranString = new RandomStringMethods(); //create a RandomStringMethods Object;
 
 try {
	 int fileNameLength = 15;  // set the length for random string
	 
	 //GET A RANDOM STRING WITHOUT A FILE EXTENSION
	 String myRandomString = ranString.randomString(CharacterOptions.NUMBERSONLY.val,fileNameLength); //only number 
	 System.out.println(myRandomString);

 
 //Get a random string with a file extension 
 String myFileName = ranString.randomString(CharacterOptions.CHARSANDNUMBERS.val,fileNameLength, "html");
 System.out.println(myFileName);
	   } catch (IllegalAccessException  err) {
		   System.out.println(err.getMessage());
	   }
	 }
}
